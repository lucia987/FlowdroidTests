/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic13.java,v 1.5 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="use getInitParameter instead" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic13 extends MainActivity {
    protected void main(SourceEmulator req, SinkEmulator resp) {        
        String s = req.getInitParameter("name");
        PrintWriter writer = resp.getWriter();
        writer.println(s);           /* BAD */
    }
    
    public String getDescription() {
        return "use getInitParameterInstead";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}