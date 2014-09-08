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
        /*
    	Cookie[] cookies = source.getCookies();
        
        String name     = cookies[0].getName();
        String value    = cookies[0].getValue();
        String comment  = cookies[0].getComment();
        
        
        if(name != null) {
            sink.println(name);                      // BAD 
        }
        if(value != null) {
            sink.println(value);                     // BAD 
        }
        if(comment != null) {
            sink.println(comment);                   // BAD 
        }
        */
    }

    public String getDescription() {
        return "values obtained from cookies";
    }

    public int getVulnerabilityCount() {
        return 2;
    }
}