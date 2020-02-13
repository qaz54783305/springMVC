package com.tibame.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.Company;
import com.tibame.domain.ITibameHello;
import com.tibame.domain.TibameHello;

/**
 * Servlet implementation class TibameHelloServlet
 */
@WebServlet("/TibameHelloServlet")
public class TibameHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Attribute
	//�غc�@�Ӥu�tInstance
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
       
    
    public TibameHelloServlet() {
        super();
       
    }

	//HTTP Get �@��ϥ��s���������ШD
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���涥�q�غc����
		response.setCharacterEncoding("big5");
		//ITibameHello hello=new TibameHello();//A����B�� �}�M���ק�@�~
		//Bean���� �u�t�Ͳ� �i�H�z�L�u�t�⴫����
		//�����h����
		ITibameHello hello=factory.getBean("tibamehello3",ITibameHello.class);
		//�I�s��k
		String msg=hello.helloWorld("eric");
		//response.getWriter().println(msg);//UI�e�{
		Company com=factory.getBean("com",Company.class);
		String name=com.getBoss().getName();
		response.getWriter().println(name);
	}

}
