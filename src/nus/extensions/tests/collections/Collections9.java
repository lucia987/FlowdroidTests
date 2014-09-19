/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections9.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "more complex collection copying" 
 *  @servlet vuln_count = "0" 
 *  */
public class Collections9 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList c1 = new LinkedList();
        c1.addLast(s1);
        ArrayList c2 = new ArrayList();
        c2.add("abc");
        c2.retainAll(c1);
        String s2 = (String) c2.get(0); 
        
        PrintWriter writer = sink.getWriter();
        writer.println(s2);                    /* OK */
    }
    
    public String getDescription() {
        return "more complex collection copying";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}