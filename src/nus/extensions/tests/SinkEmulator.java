package nus.extensions.tests;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SinkEmulator
{
	public SinkEmulator() throws SinkException {}
	/*
	"<java.io.File: void <init>(java.lang.String)>",	
	"<java.io.FileWriter: void <init>(java.lang.String)>",
	"<java.io.FileInputStream: void <init>(java.lang.String)>"};
	 */
	public SinkEmulator(String s) {}
	/*
	// "<java.io.PrintWriter: void println(java.lang.String)>",
	public void println(String taint) {}

	//"<java.io.PrintWriter: void println(java.lang.Object)>",
	public void println(Object o) {}
*/
	//"<javax.servlet.http.HttpServletResponse: void sendRedirect(java.lang.String)>",
	public void sendRedirect(String str) { }

	//"<java.sql.Connection: java.sql.PreparedStatement prepareStatement(java.lang.String)>",
	public PreparedStatement prepareStatement(String str) { return null;}
	public void close() throws SinkException {}

	//"<java.sql.Statement: boolean execute(java.lang.String)>",
	public boolean execute(String str) { return true;}
	
	//"<java.sql.Statement: int executeUpdate(java.lang.String)>",
	public int executeUpdate(String str) { return 0;}
	
	//"<java.sql.Statement: int executeUpdate(java.lang.String,int)>",
	public int executeUpdate(String str, int i) { return 0; }
	
	//"<java.sql.Statement: int executeUpdate(java.lang.String,java.lang.String[])>",
	public int executeUpdate(String str1, String str2[]) { return 0;}
	
	//"<java.sql.Statement: java.sql.ResultSet executeQuery(java.lang.String)>",
	public ResultSet executeQuery(String str) { return null;}
	
	
	public PrintWriter getWriter() {
		// TODO Auto-generated method stub
		return null;
	}
}
