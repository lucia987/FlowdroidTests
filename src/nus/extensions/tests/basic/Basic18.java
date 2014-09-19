/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic18.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic18 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s = source.getParameter(FIELD_NAME);

        for(int i = 0; i < 100; i++) {

            PrintWriter writer = sink.getWriter();
        	if(i > 5 && (i % 17 == 0)) {
                writer.println(s);                    /* BAD */
            }
        }
    }
    
    public String getDescription() {
        return "protect agains simple loop unrolling";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}