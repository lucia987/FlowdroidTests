/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic35.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;
import java.util.Enumeration;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/**
 * @servlet description="values obtained from HttpServletRequest"
 * @servlet vuln_count = "6"
 */
public class Basic35 extends MainActivity {
      protected void main(SourceEmulator req, SinkEmulator resp) {
        Enumeration e = req.getHeaderNames();
        while(e.hasMoreElements()) {
            PrintWriter writer = resp.getWriter();
            // I believe these can be forged also
            // TODO: double-check this
            writer.println(req.getProtocol());                /* BAD */
            writer.println(req.getScheme());                  /* BAD */
            writer.println(req.getAuthType());                /* BAD */
            writer.println(req.getQueryString());             /* BAD */
            writer.println(req.getRemoteUser());              /* BAD */
            writer.println(req.getRequestURL());              /* BAD */
        }        
    }

    public String getDescription() {
        return "values obtained from headers";
    }

    public int getVulnerabilityCount() {
        return 6;
    }
}