package com.tibame.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.Hello;
import com.tibame.domain.IHello;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.需要一個bean工廠物件　套用合約書
		response.setCharacterEncoding("UTF-8");
		ApplicationContext factory=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.去要一個打招呼的物件來使用(類別多型化架構) 使用介面多型化
		IHello hello=factory.getBean("hello",Hello.class);
		String msg=hello.helloWorld();
		response.getWriter().println(msg);
	}

}
