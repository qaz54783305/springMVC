package com.tibame.domain;
//A���\��
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
	//�ۭq�غc�l
	public TibameHello(){
		System.out.println("Constructor...");
	}
	//�غc�lOverloading
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
	
	//�ۭq�@�Ӫ�l��method
	public void init()
	{
		//��l�Ƥ��q�渹�W��
		this.companyName="���մ���!!";
		System.out.println("init...");
	}
	

}
