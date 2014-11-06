package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import jni.TEEObject;
import jni.TEEService;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class PropagateToConstructorTransformed extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

		public C(String str) {
			String modificator = Integer.toString(RESULT_OK);
			this.str = str + modificator;
			next = null;
		}

		public C(TEEObject obsqRef1) {
			TEEService.PropagateToConstructorTransformed$svc1(obsqRef1);
			next = null;
		}

		public String getData() {
			return this.str;
		}

		public void setData(String str) {
			this.str = str;
		}

		public void setNext(C next) {
			this.next = next;
		}

		public C getNext() {
			return this.next;
		}
	}

	protected void main(SourceEmulator source, SinkEmulator sink) {

		// String name = source.getParameter(FIELD_NAME);
		TEEObject obsqRef1 = TEEService
				.PropagateToConstructorTransformed$svc(FIELD_NAME);

		// other statements
		C c1 = new C("def");

		// using sensitive data
		C c2 = new C(obsqRef1); // c2.str is tainted
		c1.setNext(c2); // c1.str is not tainted, but c1.next.str is tainted

		// FIXME: how do we know that this getData shall return opaque ref?
		String str = c1.getNext().getData();

		PrintWriter writer = sink.getWriter();
		writer.println(str); /* BAD */
	}

	public String getDescription() {
		return "flow to constructor to next";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}