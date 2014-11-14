package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class GeneralCase2 extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public void propagateFurther(I i, String string) {
			i.setField(string);
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
	}

	public interface I {
		public void setField(String string);

		public String getField();
	}

	protected void main(SourceEmulator source, SinkEmulator sink) {

		String taint = source.getParameter(FIELD_NAME);
		// other statements
		C c1 = new C();
		// interface level
		I d1 = new D();
		// benign context
		c1.propagateFurther(d1, "def1"); 
		// using sensitive data
		C c2 = new C();
		c2.propagateFurther(d1, taint); // taint is in d1.str 
		String tainted_str = d1.getField(); 
		PrintWriter writer = sink.getWriter();
		writer.println(tainted_str); /* BAD */

		// class level
		D d2 = new D();
		c1.propagateFurther(d2, "def1");
		c2.propagateFurther(d2, taint); // taint is in d2.str
		tainted_str = d2.accessField();
		writer.println(tainted_str); /* BAD */

	}

	public String getDescription() {
		return "transformation affects the interface";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}