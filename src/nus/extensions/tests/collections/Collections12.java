/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections12.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "collection copying through an array" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections12 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
    	String s1 = source.getParameter(FIELD_NAME);

        //writer.println(s1);
    	
    	LinkedList c1 = new LinkedList();
        c1.addLast(s1);
        //writer.println(c1);
        Object[] array = c1.toArray();
        
        PrintWriter writer = sink.getWriter();
        writer.println(array[0]);                    /* BAD */
    }
    
    public String getDescription() {
        return "collection copying through an array";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}