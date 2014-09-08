/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays2.java,v 1.3 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.*;

public class Arrays2 extends MainActivity {
    public void main(SourceEmulator source, SinkEmulator sink)
    {
        String s1 = source.getParameter("name");
        String[] array = new String[10];
        array[0] = s1;
        
        sink.println(array[0]);         /* BAD */
        sink.println(array[1]);         /* OK */
        sink.println(array[2]);         /* OK */
    }
    
    public String getDescription() {
        return "a more complex array test";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}