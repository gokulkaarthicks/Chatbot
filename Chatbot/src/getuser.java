

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.*;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

@WebServlet("/getuser")
public class getuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<userInfo> al=Validate.getUsersData();
		Gson gson = new Gson();
		String element = gson.toJson(al, new TypeToken<ArrayList<tempInfo>>() {}.getType());
		System.out.println(element);
		response.getWriter().append(element);
	}


}
