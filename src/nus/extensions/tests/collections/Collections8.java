/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections8.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "collection copying" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections8 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList c1 = new LinkedList();
        c1.addLast(s1);
        ArrayList c2 = new ArrayList();
        c2.add("abc");
        c2.addAll(c1);
        String s2 = (String) c2.get(0); 
        
        sink.println(s2);                    /* BAD */
    }
    
    public String getDescription() {
        return "collection copying";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}