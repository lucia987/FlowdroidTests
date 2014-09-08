/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic23.java,v 1.6 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.util.Locale;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="path traversal" 
 *  @servlet vuln_count = "3" 
 *  */
public class Basic23 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s = source.getParameter(FIELD_NAME);
        String name = s.toLowerCase(Locale.UK);

        try {
            /* FileWriter fw = */ new SinkEmulator(name);                        /* BAD */
            ///* FileWriter fr = */ new FileWriter(name);                        /* BAD */
            ///* FileInputStream fis = */ new FileInputStream(name);             /* BAD */
            
        } catch(Throwable e) {
            System.err.println("An error occurred");
        }
    }
    
    public String getDescription() {
        return "path traversal";
    }
    
    public int getVulnerabilityCount() {
        return 3;
    }
}