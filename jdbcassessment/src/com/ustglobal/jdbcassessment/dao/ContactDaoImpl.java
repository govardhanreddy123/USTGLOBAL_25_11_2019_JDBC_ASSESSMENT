package com.ustglobal.jdbcassessment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ustglobal.jdbcassessment.dto.ContactBean;

public class ContactDaoImpl  implements ContactDao{

	public List<ContactBean> ContactDaoData() {

		String Url = "jdbc:mysql://localhost:3306/contactfiles?user=root&password=root";
		String sql = "select * from contact";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn =DriverManager.getConnection(Url);
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);

			ArrayList<ContactBean> result= new ArrayList<ContactBean>();
			while(rs.next()) {

				ContactBean bean = new ContactBean();
				String name = rs.getString("name");
				bean.setName(name);

				int number = rs.getInt("number");
				bean.setNumber(number);

				String groups = rs.getString("groups");
				bean.setGroups(groups);


				result.add(bean);
			}
			return result;

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public ContactBean searchContactData(String name) {
		String Url = "jdbc:mysql://localhost:3306/contactfiles?user=root&password=root";
		String sql =  "select * from contact where name =?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn =DriverManager.getConnection(Url);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs= pstmt.executeQuery();

			if(rs.next()) {

				ContactBean bean = new ContactBean();
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getInt("number"));
				bean.setGroups(rs.getString("groups"));

				return bean;
			}else {
				return null;
			}


		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		
		public int AddContactData(ContactBean bean) {

			String Url1 = "jdbc:mysql://localhost:3306/contactfiles?user=root&password=root";
			String query = "insert into contact values(?,?,?)";

			Connection con = null;
			PreparedStatement pstmt1 = null;

			try 
			{

				Class.forName("com.mysql.jdbc.Driver");                                   

				con  = DriverManager.getConnection(Url1);                            

				pstmt1 = con.prepareStatement(query);
				
				pstmt1.setString(1, bean.getName());
				pstmt1.setInt(2, bean.getNumber());
				pstmt1.setString(3, bean.getGroups());

				
				try {
				int	count = pstmt1.executeUpdate();
				return count;	
				} catch (Exception e) {
					System.out.println("name Exist");
					return 0;
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				return 0;
			}
			finally
			{
				try
				{
					if(con != null)
					{
						con.close();
					}
					if(pstmt1 != null)
					{
						pstmt1.close();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		}// method close
		
		public int editContactData(ContactBean bean) {

				String dburl = "jdbc:mysql://localhost:3306/contactfiles";
				String query = "update contact set sal=?,gender=? where name=?";


				Connection con = null;
				PreparedStatement pstmt = null;

				try 
				{

					Class.forName("com.mysql.jdbc.Driver");

					con  = DriverManager.getConnection(dburl,"root","root");                            

					pstmt = con.prepareStatement(query);
					
					pstmt.setString(3, bean.getName());
					pstmt.setInt(1, bean.getNumber());
					pstmt.setString(2, bean.getGroups());
					
					try {
						int count = pstmt.executeUpdate();
						return count;
					} catch (Exception e) {
						
						System.out.println("NO Id present");
						return 0;
					}

				} 
				catch (Exception e)
				{
					e.printStackTrace();
					return 0;
				}
				finally
				{
					try
					{
						if(con != null)
						{
							con.close();
						}
						if(pstmt != null)
						{
							pstmt.close();
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
		}

	}//implements close
