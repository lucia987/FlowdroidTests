/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Factories1.java,v 1.3 2006/04/04 20:00:41 livshits Exp $
 */
package nus.extensions.tests.factories;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="simple factory problem with toLowerCase" 
 *  @servlet vuln_count = "1" 
 *  */
public class Factories1 extends MainActivity {
    protected void main(SourceEmulator req, SinkEmulator resp) {
        String s1 = req.getParameter("name");
        String s2 = s1.toLowerCase();
        String s3 = "abc".toLowerCase();
            
        PrintWriter writer = resp.getWriter();
        
        writer.println(s2);    /* BAD */
        writer.println(s3);    /* OK */
    }
    
    public String getDescription() {
        return "simple factory problem with toLowerCase";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}