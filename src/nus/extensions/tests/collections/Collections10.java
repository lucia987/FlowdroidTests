/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Collections10.java,v 1.1 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "more complex collection copying" 
 *  @servlet vuln_count = "0" 
 *  */
public class Collections10 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
        String s1 = source.getParameter(FIELD_NAME);
        LinkedList c1 = new LinkedList();
        c1.addLast(s1);
        ArrayList c2 = new ArrayList();
        c2.add("abc");
        
        Iterator iter = c1.iterator();

        while(iter.hasNext()){
        	String str = (String) iter.next();
        	
        	sink.println(str);                    /* BAD */
        }
        
        iter = c2.iterator();
        while(iter.hasNext()){
        	String str = (String) iter.next();
        	
        	sink.println(str);                    /* OK */
        }
    }
    
    public String getDescription() {
        return "more complex collection copying";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}