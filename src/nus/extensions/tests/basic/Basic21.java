/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic21.java,v 1.7 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.sql.SQLException;
import java.util.Locale;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SinkException;
import nus.extensions.tests.SourceEmulator;

/** 
 *  @servlet description="SQL injection with less commonly used methods" 
 *  @servlet vuln_count = "4" 
 *  */
public class Basic21 extends MainActivity {
    private static final String FIELD_NAME = "name";

    protected void main(SourceEmulator req, SinkEmulator resp) {
        String s = req.getParameter(FIELD_NAME);
        String name = s.toLowerCase(Locale.UK);

        //Connection con = null;
        SinkEmulator con = null;
        try {
            //con = DriverManager.getConnection(MicroTestCase.CONNECTION_STRING);
            con = new SinkEmulator();
        	//Statement stmt = con.createStatement();
            SinkEmulator stmt = new SinkEmulator();
            stmt.executeUpdate("select * from Users where name=" + name);       /* BAD */
            stmt.executeUpdate("select * from Users where name=" + name, 0);    /* BAD */
            stmt.executeUpdate("select * from Users where name=" + name,        /* BAD */ 
                new String[] {});     
            stmt.executeQuery("select * from Users where name=" + name);        /* BAD */
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
        return "SQL injection with less commonly used methods";
    }
    
    public int getVulnerabilityCount() {
        return 4;
    }
}