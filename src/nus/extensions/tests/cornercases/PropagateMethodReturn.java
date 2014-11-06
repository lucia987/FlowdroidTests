package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class PropagateMethodReturn extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public String getData() {
			return this.str;
		}
		
		public String useDataPropagateToReturn(String str) {
			String modificator = Integer.toString(RESULT_OK);	
			return str + modificator;
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
		String result = c2.useDataPropagateToReturn(name); // result is tainted
		c1.setData(result); // c1.str is tainted
	
		String str = c1.getData();

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