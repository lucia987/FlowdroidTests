/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic36.java,v 1.2 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.SequenceInputStream;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

/**
 * @servlet description="values obtained from HttpServletRequest input stream"
 * @servlet vuln_count = "1"
 */
public class Basic36 extends MainActivity {
      protected void main(SourceEmulator req, SinkEmulator resp) {
        SequenceInputStream in = req.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String line;
		try {
			line = r.readLine();
		    PrintWriter writer = resp.getWriter();        
	        writer.println(line);              /* BAD */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }

    public String getDescription() {
        return "values obtained from HttpServletRequest input stream";
    }

    public int getVulnerabilityCount() {
        return 1;
    }
}