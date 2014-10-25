/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic34.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.Enumeration;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/**
 * @servlet description="values obtained from headers"
 * @servlet vuln_count = "2"
 */
public class Basic34 extends MainActivity {
      protected void main(SourceEmulator req, SinkEmulator resp) {
        Enumeration e = req.getHeaderNames();
        while(e.hasMoreElements()) {
            String headerName = (String) e.nextElement();
            String headerValue = (String) req.getHeader(headerName);
         
            PrintWriter writer = resp.getWriter();
            // I believe arbitrary header names can be forged
            // TODO: double-check this
            writer.println(headerName);                       /* BAD */
            writer.println(headerValue);                      /* BAD */
        }        
    }

    public String getDescription() {
        return "values obtained from headers";
    }

    public int getVulnerabilityCount() {
        return 2;
    }
}