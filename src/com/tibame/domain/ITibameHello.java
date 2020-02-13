package com.tibame.domain;
//功能規範 method 
public interface ITibameHello {
	//打招呼功能規範 預設為抽象方法
	public  String helloWorld(String who);
	//強迫注入屬性實現(規範)Property
	public void setCompanyName(String companyName);
}
