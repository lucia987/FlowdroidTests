/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Datastructures4.java,v 1.1 2006/04/21 17:14:24 livshits Exp $
 */
package nus.extensions.tests.datastructures;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="simple nexted data (false positive)" 
 *  @servlet vuln_count = "1" 
 *  */
public class Datastructures4 extends MainActivity {
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
       C c1 = new C();
       c1.setData(name);
       
       C c2 = new C();
       c2.setData("abc");
       c1.setNext(c2);
       
       String str = c1.next.str;
       
       PrintWriter writer = sink.getWriter();
       writer.println(str);                              /* OK */
    }
    
    public String getDescription() {
        return "simple nexted data";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}