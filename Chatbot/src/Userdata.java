

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.Validate;
import com.dbutil.TempInfo;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;


@WebServlet("/Userdata")
public class Userdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TempInfo> al=Validate.getData();
		Gson gson = new Gson();
		String element = gson.toJson(al, new TypeToken<ArrayList<TempInfo>>() {}.getType());
		response.getWriter().append(element);
	}

	

}
