/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic40.java,v 1.3 2006/04/21 17:14:26 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/**
 * @servlet description="MultipartRequest test"
 * @servlet vuln_count = "1"
 */
public class Basic40 extends MainActivity {
    private static final String FIELD_NAME = "name";
      
    protected void main(SourceEmulator req, SinkEmulator resp) {
        //MultipartRequest mreq = new MultipartRequest(req, System.getenv("HOME"));
        SourceEmulator mreq = new SourceEmulator(req);
    	String name = mreq.getParameter(FIELD_NAME);
        
        PrintWriter writer = resp.getWriter();
        writer.println(name);									/* BAD */
    }
    

    public String getDescription() {
        return "MultipartRequest test";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}