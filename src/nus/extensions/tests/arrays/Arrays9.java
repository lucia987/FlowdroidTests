/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays9.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Arrays9 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {    
    	String name = source.getParameter("name");
        String[][] array = new String[3][5];
        array[0][0] = name;
        
        sink.println(array[0][0]);         /* BAD */
    }
    
    public String getDescription() {
        return "multidimentional arrays";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}