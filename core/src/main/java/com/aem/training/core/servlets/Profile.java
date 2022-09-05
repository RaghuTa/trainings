package com.aem.training.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;



@Component(service = Servlet.class,
property = { "sling.servlet.paths" + "=" + "/bin/cricketinfo/data",
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST
        })
public class Profile extends SlingAllMethodsServlet{

	/**  https://reqres.in/#support-heading
	 * http://dummy.restapiexample.com/api/v1/employees/
	 * 
	 */
	//Logger LOG=LoggerFactory.getLogger(Profile.class);
	private static final Logger lOG=LoggerFactory.getLogger(Profile.class);
	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(final SlingHttpServletRequest req,
	            final SlingHttpServletResponse resp) throws ServletException, IOException {
	 }
	 
	 @Override
	    protected void doPost(SlingHttpServletRequest req,
	             SlingHttpServletResponse resp) throws ServletException, IOException {
		/* resp.setContentType("text/plain");
		 final String param=req.getParameter("Name");
		 final String param1=req.getParameter("Gender");
		 resp.getWriter().write("Name = " + param);
		 resp.getWriter().write("Gender = " + param1);*/
		 lOG.info("This is testing SlingServletPath Servlet for ProfileInfoServlet");
			PrintWriter pw=resp.getWriter();
			String name=req.getParameter("fname");
			String gender=req.getParameter("gender");
			/*
			 * pw.print(name); pw.print(gender);
			 */
			lOG.info("The name enter in the textfield: {}",name);
			lOG.info("Selected value in the radio button: {}",gender);
			if((StringUtils.isNotBlank(name)) && (StringUtils.isNotBlank(gender)))
			{
			resp.getWriter().write("submitted successfully");
			}
		   }
		 	 }
	 