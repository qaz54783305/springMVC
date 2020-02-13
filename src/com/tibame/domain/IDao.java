package com.tibame.domain;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

//�W���㦳Generic �x��
public interface IDao<T> {
	//�d�ߪ���k�W�d �浧�d��-�^���@�Ӫ���Entity(JavaBean)
	//Select * from customer where customer_id=? and xxxx=?
	public T select(String sql,Object...args) throws SQLException;
	//�j��`�JDataSource(Dependency Injection_�`�J)
	@Autowired
	public void setDataSource(DataSource dataSource);

}
