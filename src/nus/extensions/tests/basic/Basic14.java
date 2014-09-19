/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic14.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.Enumeration;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="use the servlet context and casts" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic14 extends MainActivity {

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        for(Enumeration e = source.getInitParameterNames(); e.hasMoreElements(); ) {
            String s  = (String) e.nextElement();

            PrintWriter writer = sink.getWriter();
            writer.println(s);                      /* BAD */
        }           
    }
    
    public String getDescription() {
        return "use the servlet context and casts";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}