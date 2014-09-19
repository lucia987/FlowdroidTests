/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections3.java,v 1.5 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "collection of collections" 
 *  @servlet vuln_count = "2" 
 *  */
public class Collections3 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        ll2.addLast(s1);
        ll2.addLast(ll1);
        
        LinkedList c = (LinkedList) ll2.getLast();
        String s2 = (String) c.getLast(); 
        
        PrintWriter writer = sink.getWriter();
        writer.println(s2);                    /* BAD */
        // this is because the print out of c includes the test of s1
        writer.println(c);                     /* BAD */     
    }
    
    public String getDescription() {
        return "collection of collections";
    }
    
    public int getVulnerabilityCount() {
        return 2;
    }
}