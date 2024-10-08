package catshap.butler.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import catshap.butler.bean.Users;
import catshap.butler.dao.UserDao;
import catshap.butler.interfaces.UserInterface;

@WebServlet("/user-exit-pass-confirm")
public class UserChangeStatusServlet extends HttpServlet {

	private UserInterface userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();
		user.setUpass( request.getParameter("upass"));
		user.setUserNo(Integer.parseInt(request.getParameter("userNo")));
		
		JsonObject jsonResponse = new JsonObject();	
		try {
			int result = userDao.updateExitUserStatus(user);
			jsonResponse = new JsonObject();
			if (result > 0) {
				jsonResponse.addProperty("success", true);
			} else {
				jsonResponse.addProperty("success", false);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonResponse.toString());
		out.flush();
	}
	
}
