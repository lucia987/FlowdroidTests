/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic2.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.util.Random;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="XSS combined with a simple conditional" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic2 extends MainActivity {

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String str = source.getParameter("name");
        Random r = new Random();
        boolean choice = r.nextBoolean();
        
        if(choice) {        
            sink.println(str);    /* BAD */
        }
    }

    public String getDescription() {
        return "XSS combined with a simple conditional";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}