/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections7.java,v 1.3 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "test of map iterators" 
 *  @servlet vuln_count = "1" 
 *  */
public class Collections7 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator writer) {
        String name = source.getParameter(FIELD_NAME);
        Map m = new HashMap();
        m.put("a", name);
        for(Iterator iter = m.entrySet().iterator(); iter.hasNext();) {
            Map.Entry e = (Entry) iter.next();
            
            writer.println(e.getKey());                         /* OK */
            writer.println(e.getValue());                       /* BAD */
        }
    }
    
    public String getDescription() {
        return "test of map iterators";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}