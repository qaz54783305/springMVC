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
		//建構DataSource
		BasicDataSource dataSource=new BasicDataSource();
		//1.屬性注入Property Injection
		String url="jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
		dataSource.setUrl(url);
		//設定帳號密碼
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//底層Driver
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//DataSource是一個連接工廠 去要一個連接物件(開啟資料庫連接)
		try {
			Connection connection=dataSource.getConnection();
			if(!connection.isClosed())
			{
				out.println("連接成功!!");
				connection.close(); //Connection Pooling 收回集區 並未立即關閉
			}
		} catch (SQLException e) {
			out.println("錯誤:"+e.getMessage());
		}
		
	}

}
