/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays6.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Arrays6 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String name = source.getParameter("name");
        String[] array = new String[10];
        
        array[0] = "abc";
        array[0] = name;        
        
        sink.println(array[0]);         /* BAD */
    }
    
    public String getDescription() {
        return "strong updates to array elements";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}