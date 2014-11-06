package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import jni.TEEObject;
import jni.TEEService;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class GeneralCase2Transformed extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public void propagateFurther(I i, String string) {
			i.setField(string);
		}

		public void propagateFurther(I i, TEEObject obsqRef1) {
			i.setField(obsqRef1);
		}
	}

	public class D implements I {
		private String str;

		public void setField(String string) {
			this.str = string;
		}

		public String getField() {
			return this.str;
		}

		public String accessField() {
			return this.str;
		}

		@Override
		public void setField(TEEObject obsqRef1) {
			TEEService.GeneralCase2$svc1(obsqRef1);

		}

		@Override
		public TEEObject getField0() {
			TEEObject ref = TEEService.GeneralCase2$svc2();
			return ref;
		}
	}

	public interface I {
		public void setField(String string);

		/**
		 * !!! we need to change the interface !!! to add our new method
		 */
		public void setField(TEEObject obsqRef1);

		public String getField();

		/**
		 * !!! we need to change the interface !!! to add our new method
		 */
		public TEEObject getField0();
	}

	protected void main(SourceEmulator source, SinkEmulator sink) {

		// String taint = source.getParameter(FIELD_NAME);
		TEEObject obsqRef1 = TEEService.GeneralCase2$svc(FIELD_NAME);
		// other statements
		C c1 = new C();
		// interface level
		I d1 = new D();
		// benign context
		c1.propagateFurther(d1, "def1");
		// using sensitive data
		C c2 = new C();
		c2.propagateFurther(d1, obsqRef1); // taint is in d1.str
		// String tainted_str = d1.getField();
		TEEObject obsqRef2 = d1.getField0();
		PrintWriter writer = sink.getWriter();
		writer.println(obsqRef2); /* BAD */

		// class level
		D d2 = new D();
		c1.propagateFurther(d2, "def1");
		c2.propagateFurther(d2, obsqRef1); // taint is in d2.str
		// tainted_str = d2.accessField();
		TEEObject obsqRef3 = d2.getField0();
		writer.println(obsqRef3); /* BAD */

	}

	public String getDescription() {
		return "transformation affects the interface";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}