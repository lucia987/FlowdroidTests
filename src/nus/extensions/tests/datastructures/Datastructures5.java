/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Datastructures5.java,v 1.1 2006/04/21 17:14:24 livshits Exp $
 */
package nus.extensions.tests.datastructures;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/**
 * @servlet description="nested data in a loop"
 * @servlet vuln_count = "1"
 * */
public class Datastructures5 extends MainActivity {
	public class C {
		private String str;
		private C next;

		public String getData() {
			return this.str;
		}

		public void setData(String str) {
			// privileged
			this.str = str;
		}

		public void setNext(C next) {
			this.next = next;
		}
	}

	private static final String FIELD_NAME = "name";

	protected void main(SourceEmulator source, SinkEmulator sink) {
		String name = source.getParameter(FIELD_NAME);
		C c1 = new C();
		c1.setData("abc");

		C c2 = new C();
		c2.setData("def");
		c1.setNext(c2);

		C c3 = new C();
		// setData is transfer, toUpperCase is a privileged
		c3.setData(name.toUpperCase());
		c2.setNext(c3);

		C c = c1;
		while (c != null) {
			String str = c.getData();
			PrintWriter writer = sink.getWriter();
			writer.println(str); /* BAD */
			c = c.next;
		}
	}

	public String getDescription() {
		return "nested data in a loop";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}