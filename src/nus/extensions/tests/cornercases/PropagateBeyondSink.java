package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class PropagateBeyondSink extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public void propagateFurther(D d, String string) {
			d.setField(string);
		}
	}

	public class D {
		private String str;

		public void setField(String string) {
			this.str = string;
		}

		public String getField() {
			return this.str;
		}

	}

	protected void main(SourceEmulator source, SinkEmulator sink) {

		String taint = source.getParameter(FIELD_NAME);
		// other statements
		C c1 = new C();
		D d1 = new D();
		// benign context
		c1.propagateFurther(d1, "def1");

		// using sensitive data
		C c2 = new C();
		c2.propagateFurther(d1, taint); // taint is in d1.str

		String tainted_str = d1.getField();

		// 1st sink - regular
		PrintWriter writer = sink.getWriter();
		writer.println(tainted_str); /* BAD */
		
		String s = new String(tainted_str);
		// 2nd sink
		writer.println(s);
		
		// 3rd sink that propagates taint
		String returnedS = sink.executeAndReturn(s);

		// 4th sink
		sink.execute(returnedS); 
		
		String x = tainted_str.toString(); // does not appear in the log 
		// 5th sink
		writer.println(x);
	}

	public String getDescription() {
		return "flow beyond the sink";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}