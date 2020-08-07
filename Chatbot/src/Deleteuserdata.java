

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.Validate;
import com.otp.auth.SendEmail;


@WebServlet("/Deleteuserdata")
public class Deleteuserdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int AccountNumber=Integer.parseInt(request.getParameter("accno"));
		//Validate.deleteComplaint(AccountNumber);
		String in=request.getParameter("accno");
		System.out.println(in);
		String AccountNumber=in.substring(1,in.length()-1);
		System.out.print(Integer.parseInt(in.substring(in.length()-2,in.length()-1))+1);
		String email=Validate.getEmail(AccountNumber);
		System.out.print(email);
		if(in.charAt(0)=='1'){
			SendEmail.getOtp(email, 1);
			Validate.deleteComplaint(AccountNumber);
		}else{
			SendEmail.getOtp(email, 2);
			Validate.deleteComplaint(AccountNumber);
		}
		
	}

}
