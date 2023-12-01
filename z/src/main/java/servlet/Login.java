package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBUser;
import database.connectionDB;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String USER_NAME = req.getParameter("taikhoan");
		String PASSWORD = req.getParameter("matkhau");
		System.out.println(USER_NAME+PASSWORD);
		DBUser l = new DBUser();
		User a = new User();
		a = l.checkUSER(USER_NAME,PASSWORD);
		System.out.println(a.getUserName());
		if(a==null) {
			String erro = "Tài khoản hoặc mật khẩu sai!";
			req.setAttribute("erro",erro);
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("data", a);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		
		
	}
	

	public static void main(String[] args) throws SQLException {
		DBUser l = new DBUser();
		User a = l.checkUSER("PERSON11", "123");
		System.out.println(a.getUserName());

	}
	

}
