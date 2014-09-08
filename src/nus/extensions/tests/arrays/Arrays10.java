/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Arrays10.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.arrays;

import nus.extensions.tests.*;

public class Arrays10 extends MainActivity {
	protected void main(SourceEmulator source, SinkEmulator sink)
	{	
        String name = source.getParameter("name");
        String[][] array = new String[3][5];
        array[0] = new String[] {name, "abc"};
        
        sink.println(array[0][0]);         /* BAD */
        sink.println(array[0][2]);         /* OK */
    }
    
    public String getDescription() {
        return "comple multidimentional array test";
    }
    
    public int getVulnerabilityCount() {
        return 1;	
	}
}