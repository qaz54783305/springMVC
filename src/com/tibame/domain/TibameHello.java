package com.tibame.domain;
//A版功能
public class TibameHello implements ITibameHello {
	//Attribute
	private String companyName;
	

	//setter and getter
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	//自訂建構子
	public TibameHello(){
		System.out.println("Constructor...");
	}
	//建構子Overloading
	public TibameHello(String companyName){
		this.companyName=companyName;
	}

	@Override
	public String helloWorld(String who) {
		// TODO Auto-generated method stub
		return String.format("com:%s say...  %s Hello World!!",
				companyName
				,who);
	}
	
	//自訂一個初始化method
	public void init()
	{
		//初始化公司行號名稱
		this.companyName="測試測試!!";
		System.out.println("init...");
	}
	

}
