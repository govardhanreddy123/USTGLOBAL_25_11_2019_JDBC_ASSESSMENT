package com.ustglobal.jdbcassessment.util;

import com.ustglobal.jdbcassessment.dao.ContactDao;
import com.ustglobal.jdbcassessment.dao.ContactDaoImpl;

public class ContactManager {
	
	private ContactManager() {
		
	}
	
	public static ContactDao getContactDao() {
		return new ContactDaoImpl();
	}
	
	
}
