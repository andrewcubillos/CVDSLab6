package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.*;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.util.ArrayList;


@WebServlet(
    urlPatterns = "/solocarpinteria"
)
public class SampleSimilarServlet extends HttpServlet{
    static final long serialVersionUID = 35L;
	private String message;
	

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	   Writer responseWriter = resp.getWriter();
	   ArrayList<Todo> listofthings= new ArrayList();
	   try{
	   
       Optional<String> optid = Optional.ofNullable(req.getParameter("id"));
       String id = optid.isPresent() && !optid.get().isEmpty() ? optid.get():""; 
	   Todo thing = Service.getTodo(Integer.parseInt(id));
	   listofthings.add(thing);
	   resp.setStatus(HttpServletResponse.SC_OK);
	   message=Service.todosToHTMLTable(listofthings);
	   
	   }
	   catch(NumberFormatException nex){
		   
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   message = Service.getHTMLError(resp.getStatus(),"Invalid Requst");
		   
		   
	   }
	   catch(MalformedURLException mex){
		    
		   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		   message = Service.getHTMLError(resp.getStatus(),"Internal Server Error");
	   }
	   catch(FileNotFoundException fex){
		   
		   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		   message = Service.getHTMLError(resp.getStatus(),"Not Found");
		   
	   }
	   catch(Exception e){
		   
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   message = Service.getHTMLError(resp.getStatus(),"Invalid Requst");
		   
	   }
	   finally{
		   responseWriter.write(message);
		   
	   }
   }
    @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
	   Writer responseWriter = resp.getWriter();
	   ArrayList<Todo> listofthings= new ArrayList();
	   try{
	   
       Optional<String> optid = Optional.ofNullable(req.getParameter("id"));
       String id = optid.isPresent() && !optid.get().isEmpty() ? optid.get():""; 
	   Todo thing = Service.getTodo(Integer.parseInt(id));
	   listofthings.add(thing);
	   resp.setStatus(HttpServletResponse.SC_OK);
	   message=Service.todosToHTMLTable(listofthings);
	   
	   }
	   catch(NumberFormatException nex){
		   
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   message = Service.getHTMLError(resp.getStatus(),"Invalid Requst");
		   
		   
	   }
	   catch(MalformedURLException mex){
		    
		   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		   message = Service.getHTMLError(resp.getStatus(),"Internal Server Error");
	   }
	   catch(FileNotFoundException fex){
		   
		   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		   message = Service.getHTMLError(resp.getStatus(),"Not Found");
		   
	   }
	   catch(Exception e){
		   
		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		   message = Service.getHTMLError(resp.getStatus(),"Invalid Requst");
		   
	   }
	   finally{
		   responseWriter.write(message);
		   
	   }
   }
}