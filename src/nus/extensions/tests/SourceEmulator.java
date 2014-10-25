package nus.extensions.tests;

import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Map;
/*
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
*/
public class SourceEmulator
{
	public SourceEmulator() {}
	public SourceEmulator(SourceEmulator req) {
		// TODO Auto-generated constructor stub
	}
	/*
	 "<javax.servlet.ServletRequest: java.lang.String getParameter(java.lang.String)>",
	 "<javax.servlet.http.HttpServletRequest: java.lang.String getParameter(java.lang.String)>",
	 "<javax.servlet.http.HttpServletRequest: java.lang.String getParameter(java.lang.String)>",
	 "<com.oreilly.servlet.MultipartRequest: java.lang.String getParameter(java.lang.String)>"};
 	*/
	public String getParameter(String src) { return src;}


	//"<javax.servlet.ServletConfig: java.util.Enumeration Names()>",
	public Enumeration Names() { return null;}
	
	//"<javax.servlet.ServletRequest: java.lang.String[] getParameterValues(java.lang.String)>",
	//"<javax.servlet.http.HttpServletRequest: java.lang.String[] getParameterValues(java.lang.String)>",
	public String[] getParameterValues(String src) { return null;}
		
	//"<javax.servlet.ServletRequest: java.util.Map getParameterMap()>",
	//"<javax.servlet.http.HttpServletRequest: java.util.Map getParameterMap()>",	
	public Map getParameterMap() { return null;}

	public Enumeration getParameterNames() { return null;}	
	/*
	//"<javax.servlet.ServletRequest: java.lang.String getProtocol()>",
	//"<javax.servlet.http.HttpServletRequest: java.lang.String getProtocol()>",
	public String getProtocol() { return null;}
	
	//"<javax.servlet.ServletRequest: java.lang.String getScheme()>",
	//"<javax.servlet.http.HttpServletRequest: java.lang.String getScheme()>", 
	public String getScheme() { return null;}
	
	//"<javax.servlet.http.HttpServletRequest: java.lang.String getAuthType()>",
	public String getAuthType() { return null;}
	//"<javax.servlet.http.HttpServletRequest: java.lang.String getQueryString()>",
	public String getQueryString() { return null;}
	//"<javax.servlet.http.HttpServletRequest: java.lang.String getRemoteUser()>",
	public String getRemoteUser() { return null;}
	//"<javax.servlet.http.HttpServletRequest: java.lang.StringBuffer getRequestURL()>",	
	public String getRequestURL() { return null;}
	*/
	//"<javax.servlet.ServletConfig: java.lang.String getInitParameter(java.lang.String)>",
	//"<javax.servlet.ServletContext: java.lang.String getInitParameter(java.lang.String)>",
	//"<soot.jimple.infoflow.test.securibench.supportClasses.DummyServletConfig: java.lang.String getInitParameter(java.lang.String)>",
	public String getInitParameter(String src)
	{
		return new String("initParameter("+src+")");
	}
	
	//	"<javax.servlet.ServletConfig: java.util.Enumeration getInitParameterNames()>",
	public Enumeration getInitParameterNames()
	{
		return null;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getComment() {
		// TODO Auto-generated method stub
		return null;
	}
	public Enumeration getHeaders(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getHeader(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getScheme() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getAuthType() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getRemoteUser() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getRequestURL() {
		// TODO Auto-generated method stub
		return null;
	}
	public SequenceInputStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	//"<javax.servlet.http.HttpServletRequest: javax.servlet.http.Cookie[] getCookies()>",
	public Cookie[] getCookies() { return null;}
	//"<javax.servlet.http.HttpServletRequest: java.lang.String getHeader(java.lang.String)>",
	public String getHeader(String str) { return null;}
	//"<javax.servlet.http.HttpServletRequest: java.util.Enumeration getHeaders(java.lang.String)>",
	public Enumeration getHeaders(String str) { return null;}
	 //"<javax.servlet.http.HttpServletRequest: java.util.Enumeration getHeaderNames()>",
	public Enumeration getHeaderNames() { return null;}

	//"<javax.servlet.http.HttpServletRequest: javax.servlet.ServletInputStream getInputStream()>",
	//"<javax.servlet.ServletRequest: javax.servlet.ServletInputStream getInputStream()>",
	public ServletInputStream getInputStream() { return null;}
	*/
}
