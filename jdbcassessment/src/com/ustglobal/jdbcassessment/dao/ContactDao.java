package com.ustglobal.jdbcassessment.dao;

import java.util.List;

import com.ustglobal.jdbcassessment.dto.ContactBean;

public interface ContactDao {
	
	public List<ContactBean> ContactDaoData();
	public ContactBean searchContactData(String name);
	public int AddContactData(ContactBean bean);
	public int editContactData(ContactBean bean);
	
	

}
