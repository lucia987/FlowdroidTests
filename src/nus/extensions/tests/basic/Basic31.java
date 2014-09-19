/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic31.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic31 extends MainActivity {
    class Data {
        String value1;
        String value2;
    }
    
    protected void main(SourceEmulator source, SinkEmulator sink) {
        
    	//Cookie[] cookies = source.getCookies();
        
        String name     = source.getName();
        String value    = source.getValue();
        String comment  = source.getComment();
        
        PrintWriter writer = sink.getWriter();
        
        if(name != null) {
            writer.println(name);                      // BAD 
        }
        if(value != null) {
        	writer.println(value);                     // BAD 
        }
        if(comment != null) {
        	writer.println(comment);                   // BAD 
        }
    }

    public String getDescription() {
        return "values obtained from cookies";
    }

    public int getVulnerabilityCount() {
        return 2;
    }
}