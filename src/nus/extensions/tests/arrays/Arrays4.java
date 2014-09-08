/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays4.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Arrays4 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String name = source.getParameter("name");
        int n = 15432532;
        
        String[] array = new String[10];        
        array[0] = name;
        
        sink.println(array[n-n]);         /* BAD */
    }
    
    public String getDescription() {
        return "a test of array indeces";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}