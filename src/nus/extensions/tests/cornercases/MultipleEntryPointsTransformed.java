package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import jni.TEEObject;
import jni.TEEService;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.cornercases.MultipleEntryPoints.D;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class MultipleEntryPointsTransformed extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		/**
		 * entry point is substituted anyway
		 */
		public void propagateFurther(D d, String string, SourceEmulator source) {
			d.setField(string);
			// second taint source
			// String taint2 = source.getParameter(FIELD_NAME);
			TEEObject obsqRef3 = TEEService
					.MultipleEntryPointsTransformed$svc(FIELD_NAME);
			D d1 = new D();
			d1.setField(obsqRef3);
		}

		/**
		 * we need to add modifications from the first context to the other context
		 */
		public void propagateFurther(D d, TEEObject obsqRef1,
				SourceEmulator source) {
			d.setField(obsqRef1);
			TEEObject obsqRef3 = TEEService
					.MultipleEntryPointsTransformed$svc(FIELD_NAME);
			D d1 = new D();
			d1.setField(obsqRef3);
		}
	}

	public class D {
		private String str;

		public void setField(String string) {
			this.str = string;
		}

		public void setField(TEEObject obsqRef1) {
			TEEService.MultipleEntryPointsTransformed$svc1(obsqRef1);
		}

		public String getField() {
			return this.str;
		}

		public TEEObject getField0() {
			TEEObject ref = TEEService.MultipleEntryPointsTransformed$svc2();
			return ref;
		}

	}

	protected void main(SourceEmulator source, SinkEmulator sink) {

		// String taint = source.getParameter(FIELD_NAME);
		TEEObject obsqRef1 = TEEService
				.MultipleEntryPointsTransformed$svc(FIELD_NAME);

		// benign context
		C c1 = new C();
		D d1 = new D();
		c1.propagateFurther(d1, "def1", source);

		// using sensitive data
		C c2 = new C();
		c2.propagateFurther(d1, obsqRef1, source); // taint is in d1.str
		// String tainted_str = d1.getField();
		TEEObject obsqRef2 = d1.getField0();
		PrintWriter writer = sink.getWriter();
		writer.println(obsqRef2); /* BAD */
}

	public String getDescription() {
		return "several taint sources in one method";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}