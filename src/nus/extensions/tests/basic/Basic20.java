/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic20.java,v 1.7 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SinkException;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="simple SQL injection" 
 *  @servlet vuln_count = "1" 
 *  */
public class Basic20 extends MainActivity {
    private static final String FIELD_NAME = "name";
    private static final String CONNECTION_STRING = "connection";

    protected void main(SourceEmulator req, SinkEmulator resp) {
        String name = req.getParameter(FIELD_NAME);

        SinkEmulator con = null;
        try {
            //con = DriverManager.getConnection(CONNECTION_STRING);
            con = new SinkEmulator();
        	//Statement stmt = con.createStatement();
            SinkEmulator stmt = new SinkEmulator();
            stmt.execute("select * from Users where name=" + name);     /* BAD */
        } catch (SinkException e) {
            System.err.println("An error occurred");
        } finally {
            try {
                if(con != null) con.close();
            } catch (SinkException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public String getDescription() {
        return "simple SQL injection";
    }
    
    public int getVulnerabilityCount() {
        return 1;
    }
}