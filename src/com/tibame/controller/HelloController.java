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

	// Method as Action 負責控制流程 呼叫Model 派送View(連同傳遞Model)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("big5");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 定義ModelAndView類型
		ModelAndView modelView = null;
		// 進行控制流程
		// 呼叫Model 產生一些狀態
		// 2.進行使用者帳號驗證->Model->Database
//		JdbcTemplate dao = context.getBean("jdbcTemplate", JdbcTemplate.class);
		// 查詢使用者
//		String sql = "select count(*) from member where username=? and password=?";
		// 呼叫方法具有preparedStatement
//		int r = dao.queryForInt(sql, userName, password);

		// 3.派送不同畫面呈現(持續這裡產生狀態State)

		if (userName == "xxx" && password=="1234") {
			String msg = String.format("%s 會員 驗證通過!!!", userName);
			modelView = new ModelAndView(this.viewPage, "message", msg);
		} else {

			String msg = String.format("%s 會員 驗證失敗!!!", userName);
			modelView = new ModelAndView(this.errorPage, "message", msg);

		}

//				if(r>0)
//				{
//					//合法會員 派送畫面
//					//Model
//					String msg=String.format("%s 會員 驗證通過的!!!",userName);
//					modelView=new ModelAndView(this.viewPage,"message",msg); //到哪裡去View 如何持續狀態? 狀態名稱?
//					
//				}else
//				{
//					//不是會員 派送畫面View(連同狀態要帶過去 Model)
//					//Model
//					String msg=String.format("%s 會員 驗證失敗!!!",userName);
//					modelView=new ModelAndView(this.errorPage,"message",msg);
//					
//				}
		// 派送View?(持續狀態Status)
		return modelView;
	}

}
