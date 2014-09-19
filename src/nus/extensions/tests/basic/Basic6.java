/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic6.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic6 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter("name");
        String s2 = s1.toUpperCase();
        String s3 = s2.concat(";");
        String s4 = s3.replace(';', '.');
        String s5 = ":" + s4 + ":";
        String s6 = s5.substring(s5.length() - 1);
        
        PrintWriter writer = sink.getWriter();
        writer.println(s6);    /* BAD */
    }
    
    public String getDescription() {
        return "complex test of derived strings";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}