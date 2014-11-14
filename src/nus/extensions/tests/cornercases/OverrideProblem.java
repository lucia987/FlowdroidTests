package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class OverrideProblem extends MainActivity {
	private static final String FIELD_NAME = "name";

	public class C {
		private String str;
		private C next;

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

	public class B extends C {
		private String str;

		public void setData(String str) {
			this.str = str + "inherited";
		}

		public void setData0(String str) {
			this.str = str + "alternative";
		}
	}

	public interface D {
		public void setData(String str);
	}

	public class F implements D {
		private String str;

		@Override
		public void setData(String str) {
			// TODO Auto-generated method stub
		}

		public void setData0(String str) {
			this.str = str + "alternative";
		}
	}

	protected void main(SourceEmulator source, SinkEmulator sink) {

		C c = new B();
		c.setData("input");
		// c.setData0(); // does not compile - requires update of a superclass
		B b = new B();
		b.setData0("input");

		D d = new F();
		d.setData("input");
		// d.setData0(); // does not compile - requires update of an interface
		F f = new F();
		f.setData0("input");

	}

	public String getDescription() {
		return "alternative methods break hierarchy";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}