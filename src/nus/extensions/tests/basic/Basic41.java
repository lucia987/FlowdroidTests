/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id$
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="use getInitParameter instead" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic41 extends MainActivity {
	protected void main(SourceEmulator req, SinkEmulator resp) {
	   //String s = getServletConfig().getServletContext().getInitParameter("name");
        String s = new SourceEmulator().getInitParameter("name");
		PrintWriter writer = resp.getWriter();
        writer.println(s);           						/* BAD */
    }
    
    public String getDescription() {
        return "use getInitParameter instead";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}