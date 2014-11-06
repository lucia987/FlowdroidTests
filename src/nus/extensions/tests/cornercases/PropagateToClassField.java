package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class PropagateToClassField extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public String getData() {
			return this.str;
		}

		public String useDataPropagateToClassField(String str) {
			String modificator = Integer.toString(RESULT_OK);
			this.str = str + modificator;
			return Integer.toString(RESULT_OK);
		}
		
		public void setData(String str) {
			this.str = str;
		}

		public void setNext(C next) {
			this.next = next;
		}
		
		public C getNext(){
			return this.next;
		}
	}

	protected void main(SourceEmulator source, SinkEmulator sink) {
		
		String name = source.getParameter(FIELD_NAME);
		// other statements
		C c1 = new C();
		c1.setData("def");

		// using sensitive data
		C c2 = new C();
		c2.useDataPropagateToClassField(name); // c2.str is tainted
		c1.setNext(c2); // c1.str is not tainted, but c1.next.str is tainted
		String str = c1.getNext().getData();

		PrintWriter writer = sink.getWriter();
		writer.println(str); /* BAD */
	}

	public String getDescription() {
		return "flow to field to next";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}