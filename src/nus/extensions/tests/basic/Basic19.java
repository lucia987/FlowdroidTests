/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic19.java,v 1.7 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.sql.SQLException;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SinkException;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="simple SQL injection with prepared statements" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic19 extends MainActivity {
    private static final String FIELD_NAME = "name";
    private static final String CONNECTION_STRING = "connection";

    protected void main(SourceEmulator req, SinkEmulator resp) {
        String name = req.getParameter(FIELD_NAME);
        
        //Connection con = null; 
        SinkEmulator sink = null;
        try {
            //con = DriverManager.getConnection(CONNECTION_STRING);
        	sink = new SinkEmulator();
            sink.prepareStatement("select * from Users where name=" + name); /* BAD */
        } catch (SinkException e) {
            System.err.println("An error occurred");
        } finally {
            try {
                if(sink != null) sink.close();
            } catch (SinkException e) {
                e.printStackTrace();
            }
        }
    }
    
    public String getDescription() {
        return "simple SQL injection with prepared statements";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}