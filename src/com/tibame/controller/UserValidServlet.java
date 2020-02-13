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

//��@controller,�����ѥ���e��
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
		//1.�^��������
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		//2.�i��b������
		JdbcTemplate dao =context.getBean("jdbcTemplate",JdbcTemplate.class);
		//�d�ߨϥΪ�
		String sql="SELECT username FROM member where username=? AND password=?";
		//query ->��h�� queryForObject ->��@��
		int result = dao.queryForInt(sql, userName, passWord);
		if(result>0) {
		//�O�|�� ���e�e��
        String msg = String.format("%s �|�����ҳq�L!!!", userName);
        request.setAttribute("msg", msg);
        //response.getWriter().println("�A�O�|��!!");	
		RequestDispatcher disp = request.getRequestDispatcher("ok.jsp");
		//�����ͩR�g��(session)
		disp.forward(request, response);
		}else {
		//���O�|��	 
//			response.getWriter().println("�A���O�|��!!");	
			 String msg = String.format("%s �|�����ҥ���!!!", userName);
			 request.setAttribute("msg", msg);
			 RequestDispatcher disp = request.getRequestDispatcher("fail.jsp");
			 disp.forward(request, response);
		}
		//3.���e�줣�P�e���e�{
	}

}
