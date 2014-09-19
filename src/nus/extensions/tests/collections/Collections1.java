/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections1.java,v 1.5 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "simple collection deposit/retrieve" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections1 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList ll = new LinkedList();
        ll.addLast(s1);
        String s2 = (String) ll.getLast();
        
        PrintWriter writer = sink.getWriter();
        writer.println(s2);                    /* BAD */
    }
    
    public String getDescription() {
        return "simple collection deposit/retrieve";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}