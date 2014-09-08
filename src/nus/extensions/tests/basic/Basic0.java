/**
    @author Benjamin Livshits <livshits@cs.stanford.edu>
    
    $Id: Basic1.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import nus.extensions.tests.*;

public class Basic0 extends MainActivity {
    protected void main(SourceEmulator source, SinkEmulator sink)
    {
        String str = source.getParameter("name");
        
        String str2 = str.toString();
        sink.println(str2);    /* BAD */
    }
    
    public String getDescription() {
        return "very simple XSS";
    }

    public int getVulnerabilityCount() {
        return 1;
    }

}