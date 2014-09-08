/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections2.java,v 1.5 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "collection deposit/retrieve, check for false positives" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections2 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList ll1 = new LinkedList();
        ll1.addLast(s1);
        
        LinkedList ll2 = new LinkedList();
        ll1.addLast("abc");
        
        String s2 = (String) ll1.getLast();
        String s3 = (String) ll2.getLast();
        
        sink.println(s2);                    /* BAD */
        sink.println(s3);                    /* OK */
    }
    
    public String getDescription() {
        return "simple collection deposit/retrieve";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}