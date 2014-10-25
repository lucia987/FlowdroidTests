/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Factories3.java,v 1.3 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.factories;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description = "factory problem with a string wrapper" 
 *  @servlet vuln_count = "1" 
 *  */
public class Factories3 extends MainActivity {
    class StringWrapper {
        StringWrapper(String value){
            this.value = value;
        }
        public String toString() {
            return value;
        }
        
        protected String value;
    }
    
    protected void main(SourceEmulator req, SinkEmulator resp) {
        String s1 = req.getParameter("name");
        
        StringWrapper w1 = new StringWrapper(s1);
        StringWrapper w2 = new StringWrapper("abc");
            
        PrintWriter writer = resp.getWriter();
        
        writer.println(w1.toString());    /* BAD */
        writer.println(w2.toString());    /* OK */
    }
    
    public String getDescription() {
        return "factory problem with a string wrapper";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}