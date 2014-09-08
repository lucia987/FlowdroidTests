/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic26.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic26 extends MainActivity {
    private static final String FIELD_NAME = "name";

	public void main(SourceEmulator source, SinkEmulator sink)
	{
       Map m = source.getParameterMap();
       for(Iterator iter = m.entrySet().iterator(); iter.hasNext();) {
           Map.Entry e = (Entry) iter.next();
           if(e.getKey().equals(FIELD_NAME)) {
               sink.println(e.getValue());        
           }           
       }
    }
    
    public String getDescription() {
        return "test getParameterMap";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}