/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic24.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.util.Locale;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="unsafe redirect" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic24 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s = source.getParameter(FIELD_NAME);
        String name = s.toLowerCase(Locale.UK);

        sink.sendRedirect("/user/" + name);          /* BAD */
    }
    
    public String getDescription() {
        return "unsafe redirect";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}