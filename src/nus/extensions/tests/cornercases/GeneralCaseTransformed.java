package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import jni.TEEObject;
import jni.TEEService;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

/**
 * this is a general case of taint propagation. Propagation happens through the
 * field of an object passed as a parameter.
 * 
 * @author rubinovk
 * 
 */
public class GeneralCaseTransformed extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public void propagateFurther(D d, String string) { // on path1
			d.setField(string);// on path1
		}

		// we can make a polymorphic method here
		// it is public, ideally we should restrict its use; how?
		/**
		 * duplicate to pass obscure ref and call methods with changed
		 * signatures
		 */
		public final void propagateFurther(D d, TEEObject obsqRef1) {
			d.setField(obsqRef1);
		}
	}

	public class D {
		private String str;

		public void setField(String string) {
			this.str = string;
		}

		/**
		 * duplicate to call a service
		 * @param obsqRef1
		 */
		public final void setField(TEEObject obsqRef1) {
			TEEService.GeneralCase$svc1(obsqRef1);
		}

		public String getField() {
			return this.str;
		}

		/**
		 * duplicate to call a service and pass a reference back
		 * @return
		 */
		public TEEObject getField0() {
			TEEObject ref = TEEService.GeneralCase$svc2();
			return ref;
		}

	}

	// create new method main0 with a secure entry point?
	// no, because no matter from where we come, there's a source
	// here and we have to protect the chain
	/**
	 * not duplicated, but modified, because it contains an entry point.
	 */
	protected void main(SourceEmulator source, SinkEmulator sink) {

		// String taint = source.getParameter(FIELD_NAME);
		TEEObject obsqRef1 = TEEService.GeneralCase$svc(FIELD_NAME);
		// other statements
		C c1 = new C();
		D d1 = new D();
		// benign context
		c1.propagateFurther(d1, "def1");

		// using sensitive data
		C c2 = new C();
		c2.propagateFurther(d1, obsqRef1);

		// String tainted_str = d1.getField();
		TEEObject obsqRef2 = d1.getField0();

		PrintWriter writer = sink.getWriter();
		//STOP analysis and transformation here; sink method
		writer.println(obsqRef2);
	}

	public String getDescription() {
		return "flow to field through parameter";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}