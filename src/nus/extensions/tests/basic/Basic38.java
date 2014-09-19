/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic38.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.StringTokenizer;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic38 extends MainActivity {
    private static final String FIELD_NAME = "name";
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String name = source.getParameter(FIELD_NAME);
        StringTokenizer tok1 = new StringTokenizer(name, "\t");
        StringTokenizer tok2 = new StringTokenizer("abc\tdef", "\t");
        
        while(tok1.hasMoreTokens() && tok2.hasMoreElements()) {
         	PrintWriter writer = sink.getWriter();
            
            writer.println(tok1.nextToken());              /* BAD */
            writer.println(tok2.nextToken());              /* OK */
        }
    }

    public String getDescription() {
        return "StringTokenizer test with a false positive";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}