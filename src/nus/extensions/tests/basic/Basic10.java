/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic10.java,v 1.5 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic10 extends MainActivity {
	
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String s1 = source.getParameter("name");
        String s2 = s1;
        String s3 = s2;
        String s4 = s3;
        StringBuffer b1 = new StringBuffer(s4);
        //StringBuffer b2 = b1;
        StringBuffer b3 = b1;
        String s5 = b3.toString();
        String s6 = s5;

        PrintWriter writer = sink.getWriter();
        
        writer.println(s6);    /* BAD */
    }
    
    public String getDescription() {
        return "chains of value assignments";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}