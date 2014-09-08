/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays7.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Arrays7 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String name = source.getParameter("name");
        String[] array = new String[] {name, "abc"};
        
        sink.println(array[0]);         /* BAD */
    }
    
    public String getDescription() {
        return "test of array initializers";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}