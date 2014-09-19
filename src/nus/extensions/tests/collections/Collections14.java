/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections14.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Collections14 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList c = new LinkedList();
        for(int i = 0; i < 3000; i++){
        	c.addFirst("i: " + i);
        }
        c.addLast(s1);
        
        PrintWriter writer = sink.getWriter();
        writer.println(c.getLast());                    /* BAD */
    }
    
    public String getDescription() {
        return "more complex collection copying through an array";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}