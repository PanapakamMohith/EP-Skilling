package com.ep.student.main;
import java.util.*;

import com.EP_Practical.Bean.StudentBean;
import com.EP_Practical.insert.StudentDAO;
public class StudentMain{

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		while(true)
		{
			System.out.println();
			System.out.println("Enter 1 to insert student details.");
			System.out.println("Enter 2 to update student details.");
			System.out.println("Enter 3 to remove student details.");
			System.out.println("Enter 4 to display student details.");
			int itr = s.nextInt();
			if(itr == 1)
			{
				System.out.println("Enter Student id to insert: ");
				int regno = s.nextInt();
				System.out.println("Enter Student name to insert: ");
				String name = s.next();
				System.out.println("Enter Student email to insert: ");
				String email = s.next();
				StudentBean sb = new StudentBean(regno,name,email);
				StudentDAO dao = new StudentDAO();
				int row = dao.studentInsert(sb);
				System.out.println(row + "row(s) affected");
			}
			else if(itr == 2)
			{
				System.out.println("Enter Student ID: ");
				int regno = s.nextInt();
				System.out.println("Enter Student name to Update: ");
				String name = s.next();
				System.out.println("Enter Student email to Update: ");
				String email = s.next();
				StudentDAO dao = new StudentDAO();
				int row = dao.studentUpdate(regno, name, email);
				System.out.println(row + "row(s) affected");
			}
			else if(itr == 3)
			{
				System.out.println("Enter Student ID to remove: ");
				int regno = s.nextInt();
				StudentDAO dao = new StudentDAO();
				int row = dao.studentDelete(regno);
				System.out.println(row + "row(s) affected");
			}
			else if(itr == 4)
			{
				StudentDAO dao = new StudentDAO();
				dao.studentDetails();
			}
			else
			{
				break;
			}
		}
		s.close();
	}
}
