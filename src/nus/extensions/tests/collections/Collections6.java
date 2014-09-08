/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections6.java,v 1.4 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "test of maps" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections6 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String name = source.getParameter(FIELD_NAME);
        Map m = new HashMap();
        m.put("a", name);
        String s1 = (String) m.get("b");
        String s2 = (String) m.get("a");
        
        sink.println(s1);                    /* OK */
        sink.println(s2);                    /* BAD */
    }
    
    public String getDescription() {
        return "test of maps";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}