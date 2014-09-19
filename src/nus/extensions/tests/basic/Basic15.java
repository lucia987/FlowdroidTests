/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic15.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;


/** 
 *  @servlet description="test casts more exhaustively" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic15 extends MainActivity {
    private static final String FIELD_NAME = "name";


	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String s1 = source.getParameter(FIELD_NAME);
        Object o = s1 + ";";
        String s2 = (String) o;
        StringBuffer buf = new StringBuffer(s2);
        Object o2 = buf;
        String s3 = ((StringBuffer) o2).toString();

        PrintWriter writer = sink.getWriter();
        writer.println(s3);                    /* BAD */
    }
    
    public String getDescription() {
        return "test casts more exhaustively";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}