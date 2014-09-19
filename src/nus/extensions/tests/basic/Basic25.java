/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic25.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.Locale;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="test getParameterValues" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic25 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
       String[] s = source.getParameterValues(FIELD_NAME);
       String name = s[0].toLowerCase(Locale.UK);

       PrintWriter writer = sink.getWriter();
       
       writer.println(name);                    /* BAD */
    }
    
    public String getDescription() {
        return "test getParameterValues";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}