/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic11.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="a simple false positive because of two calls to String.toLowerCase" 
 *  @servlet vuln_count = "2" 
 *  */
public class Basic11 extends MainActivity {
	 public void main(SourceEmulator source, SinkEmulator sink)
	 {
        String s1 = source.getParameter("name");
        String s2 = "abc";
        String s3 = s1.toUpperCase();
        String s4 = s2.toUpperCase();
        
        sink.println(s3);         /* BAD */
        sink.println(s1 + ";");   /* BAD */
        sink.println(s4);         /* OK */
    }
    
    public String getDescription() {
        return "a simple false positive because of two calls to String.toLowerCase";
    }
    
    public int getVulnerabilityCount() {
        return 2;
    }
}