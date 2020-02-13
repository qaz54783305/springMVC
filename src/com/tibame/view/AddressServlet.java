package com.tibame.view;

import java.io.IOException;
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
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//建構一個Spring Factory
	private ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");   
   
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDao dao=factory.getBean("addressdao",IDao.class);
		//查詢 
		try {
			dao.select("", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
