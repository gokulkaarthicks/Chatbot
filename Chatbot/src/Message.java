

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ApiHelper.*;
import com.dbutil.*;
/**
 * Servlet implementation class Message
 */
@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
    watson obj=new watson(); 
    private String temp="Nothing"; 
    tempInfoBuilder data=new tempInfoBuilder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html"); 
        String ip=request.getReader().readLine(); 
        PrintWriter writer = response.getWriter();
        if(temp.contains("name"))
        	data=data.setName(ip);
        if(temp.contains("Please Enter Your Account Number?"))
        	data=data.setAccountNumber(ip);
        if(temp.contains("applying for moratorium?"))
        	data=data.setReason(ip);
        if(temp.contains("back to normal situation"))
        	data=data.setRepaymentDate(ip);
        if(temp.contains("Mail id?"))
        	data=data.setEmail(ip);
        if(temp.contains("Loan number?"))
        	data=data.setLoanNumber(Long.parseLong(ip));
        if(temp.contains("mobile number?"))
        	data=data.setMobileNumber(Long.parseLong(ip));        
        if(temp.contains(" economic condition during this lockdown"))
        	data=data.setCurrentState(ip);
        if(temp.contains(" do you want to continue")){
        	data=data.getConfirmation(ip);
        	tempInfo dat=data.getObj();
        	Validate.insertData(dat);
        	data=new tempInfoBuilder();
        }
        if(ip.equals("quit")){
        	writer.println("SERVER CLOSED !!!");
        	obj.deleteSession();
        }
        else{
        	if(ip.equals("hello")){
        		obj=new watson();
        		writer.println("Connected to Moratorium Bot!!!");
        	}
        	else{
        		temp=obj.getMessage(ip);
        		writer.println(temp);
        	}
        }
	}

}
