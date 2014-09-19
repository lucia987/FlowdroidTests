/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays5.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;


import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Arrays5 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String name = source.getParameter("name");
        String[] array = new String[10];
        
        array[0] = name;
        array[0] = "abc";

        PrintWriter writer = sink.getWriter();
         
        writer.println(array[0]);         /* OK */
    }
    
    public String getDescription() {
        return "strong updates to array elements";
    }
    
    public int getVulnerabilityCount() {
        return 0;
    }
}