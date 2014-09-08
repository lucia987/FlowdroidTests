/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections11.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "interprocedural collection passing" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections11 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList c1 = new LinkedList();
        c1.addLast(s1);
        Collections11b c11b = new Collections11b();
        c11b.foo(c1, sink);
    }
    
    public String getDescription() {
        return "interprocedural collection passing";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}