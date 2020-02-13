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
		//1.�ݭn�@��bean�u�t����@�M�ΦX����
		response.setCharacterEncoding("UTF-8");
		ApplicationContext factory=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.�h�n�@�ӥ��۩I������Өϥ�(���O�h���Ƭ[�c) �ϥΤ����h����
		IHello hello=factory.getBean("hello",Hello.class);
		String msg=hello.helloWorld();
		response.getWriter().println(msg);
	}

}
