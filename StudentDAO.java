package com.EP_Practical.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EP_Practical.Bean.StudentBean;
import com.EP_Practical.Connections.DBUtil;

public class StudentDAO {

	public int studentInsert(StudentBean st)
	{
		Connection con = null;
		String query = "insert into student values(?,?,?)";
		int count = 0;
		try {
			 con = DBUtil.DBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,st.getRegno());
			pst.setString(2,st.getName());
			pst.setString(3,st.getEmail());
			count = pst.executeUpdate();
			con.close();
			pst.close();
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return count;
	}
	public int studentUpdate(int regno,String name,String email)
	{
		Connection con = null;
		String query = "update student set name = ?,email = ? where regno = ?";
		int count = 0;
		try
		{
			con = DBUtil.DBConnection();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setInt(3,regno);
			count = pst.executeUpdate();
			con.close();
			pst.close();
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return count;
	}
	public int studentDelete(int regno)
	{
		Connection con = null;
		String query = "delete from student where regno = ?";
		int count = 0;
		try
		{
			con = DBUtil.DBConnection();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,regno);
			count = pst.executeUpdate();
			con.close();
			pst.close();
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return count;
	}
	public void studentDetails()
	{
		Connection con = null;
		String query = "select * from student";
		try
		{
			con = DBUtil.DBConnection();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			String studentdata = "";
			while(rs.next())
			{
				studentdata = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3);
				System.out.println(studentdata);
			}
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
