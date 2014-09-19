/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic3.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic3 extends MainActivity {

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String str = source.getParameter("name");
        PrintWriter writer = sink.getWriter();
        String s2 = str.toLowerCase();

//        Map<String, String> map = new HashMap<String, String>();
//        String s2 = map.get(str);

        
        writer.println(s2);    /* BAD */
    }
    
    public String getDescription() {
        return "simple derived string test";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}