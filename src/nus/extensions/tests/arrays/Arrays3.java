/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
 
    $Id: Arrays3.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Arrays3 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter("name");
        String[] array1 = new String[10];
        String[] array2 = new String[10];

        array1[0] = s1;
        array2[0] = "abc";
        
        sink.println(array1[0]);         /* BAD */
        sink.println(array2[0]);         /* OK */
    }
    
    public String getDescription() {
        return "a more complex array test";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}