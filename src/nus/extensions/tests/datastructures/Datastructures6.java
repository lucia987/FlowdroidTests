/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Datastructures6.java,v 1.1 2006/04/21 17:14:24 livshits Exp $
 */
package nus.extensions.tests.datastructures;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="nested data in a loop" 
 *  @servlet vuln_count = "1" 
 *  */
public class Datastructures6 extends MainActivity {
    public class C {
    	private String str;
    	private C next;
    	
    	public String getData(){return this.str;}
    	public void setData(String str){this.str = str;}
    	public void setNext(C next){this.next = next;}
	}

	private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
       String name = source.getParameter(FIELD_NAME);
       C c = new C();
       C head = c;
    
       for(int i = 0; i < 1600; i++){
    	   C next = new C();    	   
    	   c.setNext(next);
    	   c = next;
       }
       
       c.setData(name);
       c = head;
       while(c != null) {
    	   PrintWriter writer = sink.getWriter();
           writer.println(c.getData());                              /* BAD */
           
    	   c = c.next;
       }
    }
    
    public String getDescription() {
        return "nested data in a loop";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}