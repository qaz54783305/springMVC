package com.tibame.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomersServlet
 */
@WebServlet("/CustomersServlet")
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設定回應中文編碼
		response.setCharacterEncoding("big5");
		PrintWriter out=response.getWriter();
		//1.載入驅動 for MySQL
		try {
			//需要一個可以專屬連上MySQL資料庫的驅動(物件) 一般都會使用new 建構子()
			Class.forName("com.mysql.cj.jdbc.Driver");//Reflection 載入類別中繼資料到記憶去 尚未產生一個Instance物件(lazy...)
			//2.透過連接管理員 產生一個連接物件(具有開啟連接)--帳號/密碼 資料庫伺服器?/資料庫?
			String url="jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC"
					+ "&useUnicode=true&characterEncoding=utf8&useSSL=false";
			//介面多型化 連接工廠 來結合連接字串URL 產生一個連接物件(實際意義連結上資料庫建立一個Session)
			Connection connection=DriverManager.getConnection(url,"root","1111");
			if(!connection.isClosed())
			{    
				out.println("連接成功!!");
				connection.close(); //立即關閉連接 收回資料環境
			}
			//3.下達命令
		} catch (ClassNotFoundException e) {
			out.println("錯誤:"+e.getMessage());
			
		} catch (SQLException e) {
			out.println("錯誤:"+e.getMessage());
		}
		
	}

}
