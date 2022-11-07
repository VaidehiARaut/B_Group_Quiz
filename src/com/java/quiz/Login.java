package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	static Connection con;
	static Statement stmt;
	static ResultSet  rs;
	static int stu_id=0, admin_id = 0;
	public static void dbConnection()  // this function should be used commonly
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquizdb","root", "root");	// use database named as javaquizdb in your code		
			stmt = con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public int role()  // this method will help us to know whether user is student or admin
	{ 
		// code here : plz use try catch blocks in this method
		
		System.out.println("1. Student\n2. Admin\n\n");
		System.out.println("Enter who you are ");
		Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
       
		System.out.println("\n\n1. Registered\n2. New\n\n");
		System.out.println("Enter your choice ");
		sc = new Scanner(System.in);
		
		int ch_state = sc.nextInt();
		
		if (choice==1 && ch_state==1)   //condition for student already registered
			direct_login(choice);
		else if(choice==1 && ch_state==2) //condition for new student 
		{
			Student.student_registration(); // student registraion
			direct_login(choice);     // after registration direct login
		}
		
		// by Pallavi
		
		if (choice==2 && ch_state==1)   
			direct_login(choice);
		else if(choice==2 && ch_state==2) //condition for new admin 
		{
			Admin.admin_registration(); // admin registration
			direct_login(choice);     // after registration direct login
		}
		
		return choice;
		
	}
	
	public void direct_login(int ch) // Direct login for registered as well as for newly registered student and admin
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your login name : ");		
		String login_name = sc.nextLine();
		System.out.println("Enter your pwd : ");
		String pwd = sc.nextLine();	
		try
		{ 
		   dbConnection();
		 
		// by Pallavi
		// code here : condition should be checked if ch is student or admin 
		// code here : According to that query will be fired on student detailes table or admin details table 
		 if (ch==1) {
		 rs = stmt.executeQuery("select id, username, password from student"); // if ch is 1(student)
		 
		 while (rs.next())
		 {   
			 
			 if(login_name.equalsIgnoreCase(rs.getString(2)) && pwd.equals(rs.getString(3)));
			 {
			       System.out.println("Login is successful\n\n"); 
			       stu_id = rs.getInt(1);
			 }
			 // by Pallavi
			 // code here : for validation if login fails allow him to register 
			 break;
		 }
		 
		 // by Pallavi
		 // code here : condition should be checked if ch is student or admin 
		 // code here : According to that student account or admin account screen on console should be opened
		
		 Student.student_account(login_name); // After login, student account screen 
		 }
		 else
		 {
             rs = stmt.executeQuery("select Admin_ID, Admin_UserName, Admin_Pwd from admin");
             while (rs.next())
    		 {       			 
            	 if(login_name.equalsIgnoreCase(rs.getString(2)) && pwd.equals(rs.getString(3)));
            	 {
			        System.out.println("Login is successful\n\n"); 
				    admin_id = rs.getInt(1);
            	 } 
            	 break;
    		 } 
             Admin.admin_account(login_name); // code here     // After login, admin account screen
		 }
		
		 
		 
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	
	
	
}
