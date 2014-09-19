/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections11b.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import nus.extensions.tests.SinkEmulator;

/** 
 *  @servlet description = "simple collection deposit/retrieve" 
 *  @servlet vuln_count = "1" 
 *  */
class Collections11b {
    protected void foo(Object o, SinkEmulator sink) {
    	Collection c = (Collection) o;
        String str = c.toString();
        PrintWriter writer = sink.getWriter();
        writer.println(str);                    /* BAD */
    }
}