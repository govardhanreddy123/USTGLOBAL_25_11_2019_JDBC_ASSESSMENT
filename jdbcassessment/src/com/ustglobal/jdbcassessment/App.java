package com.ustglobal.jdbcassessment;

import java.util.List;
import java.util.Scanner;

import com.ustglobal.jdbcassessment.dao.ContactDao;
import com.ustglobal.jdbcassessment.dao.ContactDaoImpl;
import com.ustglobal.jdbcassessment.dto.ContactBean;
import com.ustglobal.jdbcassessment.util.ContactManager;

public class App {
	public static void main(String[] args) {

		System.out.println("press 1 to get all contact data");
		System.out.println("press 2 to search contact");
		System.out.println("press 3 to operate on contact");

		Scanner scn = new Scanner(System.in);
		int ch = scn.nextInt();

		switch(ch) {
		case 1 :
			ContactDao daoAll = ContactManager.getContactDao();
			List<ContactBean> result= daoAll.ContactDaoData();
			
			for(ContactBean bean : result) {
				System.out.println("name: "+bean.getName());
				System.out.println("number :"+bean.getNumber());
				System.out.println("groups :"+bean.getGroups());
				System.out.println("==========================");
			}
			

			break;

		case 2:
			ContactDao daoSearch = ContactManager.getContactDao();
		    System.out.println("enter the name");
			String name = scn.next();
			ContactBean bean2 =daoSearch.searchContactData(name);
			if(bean2!=null) {
				System.out.println("name :  "+bean2.getName());
				System.out.println("number : "+bean2.getNumber());
				System.out.println("groups : "+bean2.getGroups());
				
				System.out.println("press 1 to call ");
				System.out.println("press 2 to message");
				System.out.println("press 3 to  go back to main menu");
				
				Scanner scn1 = new Scanner(System.in);
				int m = scn.nextInt();
				
				switch(m) {
				case 1:
					break;
					
				case 2:
					break;
					
				case 3 :
					break;
					
				}
				
				
			}else {
				System.out.println("no data found");
			}
			break;
			
			

		case 3:
			
			System.out.println("press 1 to add contact");
			System.out.println("press 2 to delete contact");
			System.out.println("press 3 to edit contact");
			
			Scanner scn2 = new Scanner(System.in);
			int n = scn2.nextInt();
			switch(n) {
			
			case 1:
				ContactDao daoadd = ContactManager.getContactDao();
				ContactBean beanadd = new ContactBean();
				System.out.println("enter the name :");
				beanadd.setName(scn2.next());
				System.out.println("Enter number : ");
				beanadd.setNumber(scn2.nextInt());
				System.out.println("Enter groups");
				beanadd.setGroups(scn2.next());
				int count_a = daoadd.AddContactData(beanadd);
				if (count_a > 0) {
					System.out.println(count_a + " Row(S) inserted");
				}
				else {
					System.out.println("Try New..");
				}
				break;
			case 2:
				ContactDao daoedit = ContactManager.getContactDao();
				ContactBean beanedit = new ContactBean();
				
			

				System.out.println("Enter  old Name : ");
				beanedit.setName(scn2.next());
				System.out.println("Enter number : ");
				beanedit.setNumber(scn2.nextInt());
				System.out.println("Enter groups ");
				beanedit.setGroups(scn2.next());
				int count_u = daoedit.editContactData(beanedit);
				if(count_u == 1) {
					System.out.println(count_u+"row(S) updated");
				}
				else {
					System.out.println("Try again");
				}

				break;
				
			case 3 :
				
				break;
				
				
				
			}
			
			

			break;
		}//end of main switch



	}//end of main 
}
