/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic12.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic12 extends MainActivity {
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter("name");
        boolean choice = new Random().nextBoolean();

        PrintWriter writer = sink.getWriter();
        
        if(choice) {
            writer.println(s1 + ":");   /* BAD */
        } else{
        	writer.println(s1 + ";");   /* BAD */
        }
        
        writer.println("\n");           /* OK */
    }
    
    public String getDescription() {
        return "a simple conditional; both branches should be taken";
    }
    
    public int getVulnerabilityCount() {
        return 2;
    }
}