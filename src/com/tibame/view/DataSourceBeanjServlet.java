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
	//�غc�@��Spring Factory
	private ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
       
    
    public DataSourceBeanjServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("big5");
		PrintWriter out=response.getWriter();
		//�z�LSping Factory�h����n�@��DataSource���� �C�@���{���U�n�@��DataSource?
		DataSource dataSource=factory.getBean("dataSource",DataSource.class);
		//�z�L�s���u�t�h�n�@�ӭ���s������(�s���W��Ʈw)
		try {
			Connection connection=dataSource.getConnection();
			if(!connection.isClosed())
			{
				out.println("�s�����\!!");
				connection.close(); //Connection Pooling ���^���� �å��ߧY����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("���~:"+e.getMessage());
		}
	}

}
