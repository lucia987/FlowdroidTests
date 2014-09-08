/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic22.java,v 1.5 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.util.Locale;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="basic path traversal" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic22 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s = source.getParameter(FIELD_NAME);
        String name = s.toLowerCase(Locale.UK);

        // this is not a problem just yet: it's perhaps okay to create a file file 
        // a tainted filename, but not use it in any way
        SinkEmulator sink2 = new SinkEmulator(name);                       
        // this is definitely bad; an error should be flagged either on this or the 
        // previous line
        //f.createNewFile();                              /* BAD */
    }
    
    public String getDescription() {
        return "basic path traversal";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}