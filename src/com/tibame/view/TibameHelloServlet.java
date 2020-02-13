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
	//建構一個工廠Instance
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
       
    
    public TibameHelloServlet() {
        super();
       
    }

	//HTTP Get 一般使用瀏覽器直接請求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//執行階段建構物件
		response.setCharacterEncoding("big5");
		//ITibameHello hello=new TibameHello();//A版到B版 開刀式修改作業
		//Bean元件 工廠生產 可以透過工廠抽換版本
		//介面多型化
		ITibameHello hello=factory.getBean("tibamehello3",ITibameHello.class);
		//呼叫方法
		String msg=hello.helloWorld("eric");
		//response.getWriter().println(msg);//UI呈現
		Company com=factory.getBean("com",Company.class);
		String name=com.getBoss().getName();
		response.getWriter().println(name);
	}

}
