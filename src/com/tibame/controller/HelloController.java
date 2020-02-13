package com.tibame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// Attribute View Page
	private String viewPage;
	private String errorPage;

	public String getErrorPage() {   
		return errorPage;
	}              

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	public String getViewPage() {
		return viewPage;
	}

	public void setViewPage(String viewPage) {     
		this.viewPage = viewPage;
	}

	// Method as Action �t�d����y�{ �I�sModel ���eView(�s�P�ǻ�Model)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("big5");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// �w�qModelAndView����
		ModelAndView modelView = null;
		// �i�汱��y�{
		// �I�sModel ���ͤ@�Ǫ��A
		// 2.�i��ϥΪ̱b������->Model->Database
//		JdbcTemplate dao = context.getBean("jdbcTemplate", JdbcTemplate.class);
		// �d�ߨϥΪ�
//		String sql = "select count(*) from member where username=? and password=?";
		// �I�s��k�㦳preparedStatement
//		int r = dao.queryForInt(sql, userName, password);

		// 3.���e���P�e���e�{(����o�̲��ͪ��AState)

		if (userName == "xxx" && password=="1234") {
			String msg = String.format("%s �|�� ���ҳq�L!!!", userName);
			modelView = new ModelAndView(this.viewPage, "message", msg);
		} else {

			String msg = String.format("%s �|�� ���ҥ���!!!", userName);
			modelView = new ModelAndView(this.errorPage, "message", msg);

		}

//				if(r>0)
//				{
//					//�X�k�|�� ���e�e��
//					//Model
//					String msg=String.format("%s �|�� ���ҳq�L��!!!",userName);
//					modelView=new ModelAndView(this.viewPage,"message",msg); //����̥hView �p����򪬺A? ���A�W��?
//					
//				}else
//				{
//					//���O�|�� ���e�e��View(�s�P���A�n�a�L�h Model)
//					//Model
//					String msg=String.format("%s �|�� ���ҥ���!!!",userName);
//					modelView=new ModelAndView(this.errorPage,"message",msg);
//					
//				}
		// ���eView?(���򪬺AStatus)
		return modelView;
	}

}
