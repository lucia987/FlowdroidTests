/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic8.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.BitSet;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic8 extends MainActivity {
    
	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String str = source.getParameter("name");
        BitSet bs = new BitSet(10);
        
        if(bs.get(0)) {
            if(bs.get(1)) {
                if(bs.get(2)) {
                    if(bs.get(3)) {
                        if(bs.get(4)) {
                            
                        }
                    } else {
                    	PrintWriter writer = sink.getWriter();
                        writer.println(str);    /* BAD */
                    }
                }
            }
        }
    }
    
    public String getDescription() {
        return "test of complex conditionals";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}