/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic5.java,v 1.5 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic5 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter("name");
        String s2 = s1.toUpperCase();
        String s3 = s2.concat(";");
        String s4 = s3.replace(';', '.');
        String s5 = s4.trim();
        
        PrintWriter writer = sink.getWriter();
        
        writer.println(s3);    /* BAD */
        writer.println(s4);    /* BAD */
        writer.println(s5);    /* BAD */
    }
    
    public String getDescription() {
        return "moderately complex test of derived strings";
    }
    
    public int getVulnerabilityCount() {
        return 3;
    }
}