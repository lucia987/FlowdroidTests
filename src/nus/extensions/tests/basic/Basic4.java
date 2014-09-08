/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic4.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic4 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String str = source.getParameter("name");
        Random r = new Random();
        int choice = r.nextInt();
        
        switch (choice) {   
            case 1: break;
            case 2: break;
            case 3: 
                sink.println(str);    /* BAD */
                break;
            default:
        }
    }
    
    public String getDescription() {
        return "test path sensitivity just a bit";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}