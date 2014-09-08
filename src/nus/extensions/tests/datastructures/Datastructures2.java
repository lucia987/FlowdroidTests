/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Datastructures2.java,v 1.1 2006/04/21 17:14:24 livshits Exp $
 */
package nus.extensions.tests.datastructures;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="multiple objects of the same type" 
 *  @servlet vuln_count = "1" 
 *  */
public class Datastructures2 extends MainActivity {
    public class C {
    	private String str;
    	public String getData(){return this.str;}
    	public String getTag(){return this.str;}
    	public void setData(String str){this.str = str;}
	}

	private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator source, SinkEmulator sink) {
       String name = source.getParameter(FIELD_NAME);
       C c1 = new C();
       c1.setData("def");
       
       C c2 = new C();
       c2.setData(name);
       
       String str1 = c1.getData();
       String str2 = c2.getData();
       
       sink.println(str1);                              /* OK */
       sink.println(str2);                              /* BAD */
    }
    
    public String getDescription() {
        return "simple test of field assignment";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}