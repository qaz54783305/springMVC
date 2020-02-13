package com.tibame.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.IDao;

/**
 * Servlet implementation class AutowiredDemoServlet
 */
@WebServlet("/AutowiredDemoServlet")
public class AutowiredDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
       
    
    public AutowiredDemoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("big5");
		PrintWriter out=response.getWriter();
		//1.透過Spring xml Config去要一個Bean
		IDao dao=factory.getBean("MyCustomers",IDao.class);
		try {
			dao.select("select * from customer where customer_id=?",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
