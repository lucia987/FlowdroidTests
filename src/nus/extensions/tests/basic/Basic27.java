/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic27.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.Enumeration;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="test getParameterMap" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic27 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
       Enumeration e = source.getParameterNames();
       while(e.hasMoreElements()) {
           String name = (String) e.nextElement();
           if(name.equals(FIELD_NAME)) {
               String value = source.getParameter(name);
               sink.println("value: " + value);           /* BAD */
           }
       }
    }
    
    public String getDescription() {
        return "test getParameterMap";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}