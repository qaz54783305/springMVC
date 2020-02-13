package com.tibame.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@WebServlet("/DataSourceBeanjServlet")
public class DataSourceBeanjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//建構一個Spring Factory
	private ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
       
    
    public DataSourceBeanjServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("big5");
		PrintWriter out=response.getWriter();
		//透過Sping Factory去正轉要一個DataSource物件 每一隻程式各要一個DataSource?
		DataSource dataSource=factory.getBean("dataSource",DataSource.class);
		//透過連接工廠去要一個個體連接物件(連接上資料庫)
		try {
			Connection connection=dataSource.getConnection();
			if(!connection.isClosed())
			{
				out.println("連接成功!!");
				connection.close(); //Connection Pooling 收回集區 並未立即關閉
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("錯誤:"+e.getMessage());
		}
	}

}
