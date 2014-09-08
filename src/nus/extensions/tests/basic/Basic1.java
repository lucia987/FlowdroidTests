/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic1.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="very simple XSS" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic1 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String str = source.getParameter("name");
        
        sink.println(str);    /* BAD */
    }
    
    public String getDescription() {
        return "very simple XSS";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}