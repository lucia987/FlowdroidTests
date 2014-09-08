/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Datastructures1.java,v 1.1 2006/04/21 17:14:24 livshits Exp $
 */
package nus.extensions.tests.datastructures;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="simple test of field assignment" 
 *  @servlet vuln_count = "1" 
 *  */
public class Datastructures0 extends MainActivity {
    public class C {
    	public String str;
    	public String tag = "abc";
    	
    	/*
    	public String getData(){return this.str;}
    	//we manually fixed this, was originally:
    	//public String getTag(){return this.str;}
    	public String getTag(){return this.tag;}
    	public void setData(String str){this.str = str;}
    	*/
	}

	private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
       String name = source.getParameter(FIELD_NAME);
       C c = new C();
       c.str = name;
       
       sink.println(c.str);                              /* BAD */
       sink.println(c.tag);                              /* OK */
    }
    
    public String getDescription() {
        return "simple test of field assignment";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}