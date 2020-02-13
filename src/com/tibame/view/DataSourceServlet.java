package com.tibame.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Servlet implementation class DataSourceServlet
 */
@WebServlet("/DataSourceServlet")
public class DataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DataSourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("big5");
		PrintWriter out=response.getWriter();
		//�غcDataSource
		BasicDataSource dataSource=new BasicDataSource();
		//1.�ݩʪ`�JProperty Injection
		String url="jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
		dataSource.setUrl(url);
		//�]�w�b���K�X
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//���hDriver
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//DataSource�O�@�ӳs���u�t �h�n�@�ӳs������(�}�Ҹ�Ʈw�s��)
		try {
			Connection connection=dataSource.getConnection();
			if(!connection.isClosed())
			{
				out.println("�s�����\!!");
				connection.close(); //Connection Pooling ���^���� �å��ߧY����
			}
		} catch (SQLException e) {
			out.println("���~:"+e.getMessage());
		}
		
	}

}
