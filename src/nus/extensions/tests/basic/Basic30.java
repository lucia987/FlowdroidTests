/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic30.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic30 extends MainActivity {
    class Data {
        String value1;
        String value2;
    }
    
    protected void main(SourceEmulator source, SinkEmulator sink) 
    {
        String name = source.getParameter("name");
        Data d = new Data();
        d.value2 = name;
        d.value1 = "abc";
        
        PrintWriter writer = sink.getWriter();
        
        writer.println(d.value1);                   /* OK */
        writer.println(d.value2);                   /* BAD */
    }

    public String getDescription() {
        return "field sensitivity";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}