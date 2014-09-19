/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id$
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="use getInitParameterNames" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic42 extends MainActivity {
	protected void main(SourceEmulator req, SinkEmulator resp) {
	    //ServletContext context = getServletConfig().getServletContext();
        SourceEmulator context = new SourceEmulator();
		Enumeration e = context.getInitParameterNames();
        while(e.hasMoreElements()) {
            String name = (String) e.nextElement();
            Object value = context.getInitParameter(name); 
            PrintWriter writer = resp.getWriter();
            writer.println(value.toString());          					 /* BAD */
        }
    }
    
    public String getDescription() {
        return "use getInitParameterNames";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}