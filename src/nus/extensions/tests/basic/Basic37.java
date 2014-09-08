/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic37.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.util.StringTokenizer;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic37 extends MainActivity {
    private static final String FIELD_NAME = "name";
      
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String name = source.getParameter(FIELD_NAME);
        StringTokenizer tok = new StringTokenizer(name, "\t");
        while(tok.hasMoreTokens()) {
            sink.println(tok.nextToken());              /* BAD */    
        }
    }

    public String getDescription() {
        return "StringTokenizer test";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}