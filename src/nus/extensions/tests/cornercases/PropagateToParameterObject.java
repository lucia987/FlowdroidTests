package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class PropagateToParameterObject extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public String getData() {
			return this.str;
		}
		
		public void useDataPropagateToParamObjField(C c) {
			c.setNext(c);
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
		C c1 = new C();
		c1.setData(name); // c1.str is tainted

		// using sensitive data
		C c2 = new C();
		c2.useDataPropagateToParamObjField(c1); // c2.next.str tainted
	
		String str = c2.next.getData();

		PrintWriter writer = sink.getWriter();
		writer.println(str); /* BAD */
	}

	public String getDescription() {
		return "flow to next parameter";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}