package nus.extensions.tests.cornercases;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;
import nus.extensions.tests.datastructures.Datastructures2.C;

public class GeneralLibraryOnPath extends MainActivity {
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

		//android or gui library call has to become a service
		try {
			Cipher cipher = javax.crypto.Cipher.getInstance(taint);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		String tainted_str = d1.getField();

		PrintWriter writer = sink.getWriter();
		writer.println(tainted_str); /* BAD */
	}

	public String getDescription() {
		return "flow to field to next";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}