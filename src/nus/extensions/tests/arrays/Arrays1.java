/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays1.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import java.io.PrintWriter;

import nus.extensions.tests.*;

public class Arrays1 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String s1 = source.getParameter("name");
        String[] array = new String[10];
        array[0] = s1;
        
        PrintWriter writer = sink.getWriter();
        
        writer.println(array[0]);         /* BAD */        
    }
    
    public String getDescription() {
        return "a simple array test";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}