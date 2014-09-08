/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic9.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic9 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter("name");
        Random r = new Random();
        boolean choice = r.nextBoolean();
        String s2 = s1;
        String s3 = s2;
        //String s4 = s1;
        String s5 = choice ? s3 : s2;
        String s6 = s5;
        
        sink.println(s6);    /* BAD */
    }
    
    public String getDescription() {
        return "chains of value assignments";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}