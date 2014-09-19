/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic7.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic7 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter("name");
        String s2 = s1.toUpperCase();
        StringBuffer buf = new StringBuffer(s2);
        buf.append("abcdefgh");
        buf.insert(3, 's');
        String s3 = buf.toString();
        
        PrintWriter writer = sink.getWriter();
        writer.println(s3);    /* BAD */
    }
    
    public String getDescription() {
        return "complex test of derived strings involving a string buffer";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}