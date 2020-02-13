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
		//�]�w�^������s�X
		response.setCharacterEncoding("big5");
		PrintWriter out=response.getWriter();
		//1.���J�X�� for MySQL
		try {
			//�ݭn�@�ӥi�H�M�ݳs�WMySQL��Ʈw���X��(����) �@�볣�|�ϥ�new �غc�l()
			Class.forName("com.mysql.cj.jdbc.Driver");//Reflection ���J���O���~��ƨ�O�Хh �|�����ͤ@��Instance����(lazy...)
			//2.�z�L�s���޲z�� ���ͤ@�ӳs������(�㦳�}�ҳs��)--�b��/�K�X ��Ʈw���A��?/��Ʈw?
			String url="jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC"
					+ "&useUnicode=true&characterEncoding=utf8&useSSL=false";
			//�����h���� �s���u�t �ӵ��X�s���r��URL ���ͤ@�ӳs������(��ڷN�q�s���W��Ʈw�إߤ@��Session)
			Connection connection=DriverManager.getConnection(url,"root","1111");
			if(!connection.isClosed())
			{    
				out.println("�s�����\!!");
				connection.close(); //�ߧY�����s�� ���^�������
			}
			//3.�U�F�R�O
		} catch (ClassNotFoundException e) {
			out.println("���~:"+e.getMessage());
			
		} catch (SQLException e) {
			out.println("���~:"+e.getMessage());
		}
		
	}

}
