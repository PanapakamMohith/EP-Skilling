package com.ep.main;

import java.util.Scanner;
import com.ep.bean.Bean;
import com.ep.dao.ItemDAO;

public class ItemMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true)
		{
			System.out.println();
			System.out.println("Enter 1 to insert item details.");
			System.out.println("Enter 2 to display item details.");
			System.out.println("Enter 3 to get total cost of items");
			int itr = s.nextInt();
			if(itr == 1)
			{
				System.out.println("Enter Item id to insert: ");
				int id = s.nextInt();
				System.out.println("Enter Item name to insert: ");
				String name = s.next();
				System.out.println("Enter Item cost to insert: ");
				int cost = s.nextInt();
				Bean b = new Bean(id,name,cost);
				ItemDAO dao = new ItemDAO();
				int row = dao.insertItem(b);
				System.out.println(row + "row(s) affected");
			}
			else if(itr == 2)
			{
				ItemDAO dao = new ItemDAO();
				dao.itemDetails();
			}
			else if(itr == 3)
			{
				ItemDAO dao = new ItemDAO();
				dao.totalCost();
			}
			else
			{
				break;
			}
		}
		s.close();
	}
}
