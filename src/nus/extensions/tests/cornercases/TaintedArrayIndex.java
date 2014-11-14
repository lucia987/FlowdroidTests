/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: .java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.cornercases;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class TaintedArrayIndex extends MainActivity {
	public void main(SourceEmulator source, SinkEmulator sink) {
		String[] array = new String[5];

		String name = source.getParameter("3");
		int index = Integer.valueOf(name);
		String s = array[index]; // this is not detected by FD. It's like the
									// case of implicit flow.

		PrintWriter writer = sink.getWriter();
		writer.println(s); /* BAD */
	}

	public String getDescription() {
		return "multidimentional arrays";
	}

	public int getVulnerabilityCount() {
		return 1;
	}
}