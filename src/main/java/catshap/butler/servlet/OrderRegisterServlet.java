package catshap.butler.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import catshap.butler.bean.Orders;
import catshap.butler.bean.Product;
import catshap.butler.bean.Users;
import catshap.butler.dao.OrdersDao;
import catshap.butler.interfaces.OrdersInterface;

@WebServlet("/regist/orders")
public class OrderRegisterServlet extends HttpServlet {

	private OrdersInterface orderDao;

	@Override
	public void init() throws ServletException {
		orderDao = new OrdersDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			JsonObject jsonResponse = new JsonObject();
			Users user = (Users)session.getAttribute("user");
			int userNo = user.getUserNo();
			
			if (user != null && validateOrder(userNo)) {
				int prodTotalPrice = Integer.parseInt(request.getParameter("prodTotalPrice"));
				int ordNo = insertOrdersAndGetOrdNo(userNo, prodTotalPrice);
				if (ordNo > 0) {			
					jsonResponse.addProperty("success", true);
					jsonResponse.addProperty("ordNo", ordNo);
					jsonResponse.addProperty("email", user.getEmail());
				} else {
					jsonResponse.addProperty("success", false);
				}
			}
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsonResponse.toString());
			out.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 이전 주문 내역이 있는지 확인하는 메소드
	private boolean validateOrder(int userNo) throws SQLException {
		Orders order = orderDao.getOrder(userNo);
		System.out.println(order);
		if (order == null) {
			return true;
		} 
		return false;
	}
	
	// 주문 내역 저장하는 메소드
	private int insertOrdersAndGetOrdNo(int userNo, int prodTotalPrice) throws SQLException {
		Orders order = new Orders();
		order.setUserNo(userNo);
		order.setOrdTotalPrice(prodTotalPrice);
		orderDao.insertOrdersAndGetOrdNo(order);
		return order.getOrdNo();
	}

}
