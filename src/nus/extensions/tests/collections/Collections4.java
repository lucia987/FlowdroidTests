/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections4.java,v 1.5 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.util.Iterator;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "test of iterators" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections4 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String name = source.getParameter(FIELD_NAME);
        LinkedList ll = new LinkedList();
        ll.addLast(name);
        
        for(Iterator iter = ll.iterator(); iter.hasNext();) {
            Object o = iter.next();
            
            sink.println(o);                    /* BAD */
        }
    }
    
    public String getDescription() {
        return "test of iterators";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}