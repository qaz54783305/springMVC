package com.tibame.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.EmployeesData;

/**
 * Servlet implementation class ShowCallbackServlet
 */
@WebServlet("/ShowCallbackServlet")
public class ShowCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
       
    public ShowCallbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeesData data=factory.getBean("empdata",EmployeesData.class);
		response.getWriter().println(data.getData());
	}

}
