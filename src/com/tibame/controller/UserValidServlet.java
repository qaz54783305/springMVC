package com.tibame.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//當作controller,不提供任何畫面
@WebServlet("/uservalid")
public class UserValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext"); 
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OKOKOKOKOKO!!!!");
		//1.擷取表單欄位
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		//2.進行帳號驗證
		JdbcTemplate dao =context.getBean("jdbcTemplate",JdbcTemplate.class);
		//查詢使用者
		String sql="SELECT username FROM member where username=? AND password=?";
		//query ->找多筆 queryForObject ->找一筆
		int result = dao.queryForInt(sql, userName, passWord);
		if(result>0) {
		//是會員 派送畫面
        String msg = String.format("%s 會員驗證通過!!!", userName);
        request.setAttribute("msg", msg);
        //response.getWriter().println("你是會員!!");	
		RequestDispatcher disp = request.getRequestDispatcher("ok.jsp");
		//維持生命週期(session)
		disp.forward(request, response);
		}else {
		//不是會員	 
//			response.getWriter().println("你不是會員!!");	
			 String msg = String.format("%s 會員驗證失敗!!!", userName);
			 request.setAttribute("msg", msg);
			 RequestDispatcher disp = request.getRequestDispatcher("fail.jsp");
			 disp.forward(request, response);
		}
		//3.派送到不同畫面呈現
	}

}
