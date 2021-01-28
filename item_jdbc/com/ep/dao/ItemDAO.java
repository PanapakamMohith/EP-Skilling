package com.ep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ep.connections.*;
import com.ep.bean.Bean;
public class ItemDAO {
	
	public int insertItem(Bean b)
	{
		Connection con = null;
		String query = "insert into sales values(?,?,?)";
		int count = 0;
		try {
			 con = com.ep.connections.DBUtil.DBConnection();
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
			pst.setInt(1,b.getItemid());
			pst.setString(2,b.getItemname());
			pst.setInt(3,b.getCost());
			count = pst.executeUpdate();
			con.close();
			pst.close();
		}catch (Exception e)
		{
			System.out.println(e);
		}
		return count;
	}
	public void itemDetails()
	{
		Connection con = null;
		String query = "select *from sales";
		try
		{
			con = com.ep.connections.DBUtil.DBConnection();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			String itemdata = "";
			while(rs.next())
			{
				itemdata = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3);
				System.out.println(itemdata);
			}
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void totalCost()
	{
		Connection con = null;
		String query = "select sum(item_cost) as total_cost from sales;";
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
			rs.next();
			String total_cost_item ="Total cost of items: " + rs.getInt(1);
			System.out.println(total_cost_item);
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
