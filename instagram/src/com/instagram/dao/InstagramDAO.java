package com.instagram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.instagram.entity.InstagramEmployee;

public class InstagramDAO implements InstagramDAOInterface{
	private InstagramDAO() {}

	@Override
	public int createProfileDAO(InstagramEmployee ie) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into InstagramEmployee values(?,?,?,?)");
			ps.setString(1, ie.getName());
			ps.setString(2, ie.getPass());
			ps.setString(3, ie.getEmail());
			ps.setString(4, ie.getAddress());
			i=ps.executeUpdate();
			System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public static InstagramDAOInterface createDaoObject() {
		// TODO Auto-generated method stub
		return new InstagramDAO();
	}

}
