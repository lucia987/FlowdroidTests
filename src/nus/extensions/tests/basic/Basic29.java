/**
 * @author Benjamin Livshits <livshits@cs.stanford.edu>
 * 
 * $Id: Basic29.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic29 extends MainActivity {
    class Node {
        String value;
        Node   next = null;
    }

	public void main(SourceEmulator source, SinkEmulator sink)
	{
        String name = source.getParameter("name");
        Node head = new Node();
        Node next = new Node();
        head.next = next;
        next.value = name;

        PrintWriter writer = sink.getWriter();
        
        writer.println(next.value);                  /* BAD */
        writer.println(head.next.value);             /* BAD */
        writer.println(head.value);                  /* OK */
    }

    public String getDescription() {
        return "recursive data structures";
    }

    public int getVulnerabilityCount() {
        return 2;
    }
}