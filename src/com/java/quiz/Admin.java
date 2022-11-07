package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class Admin {
static int admin_id=5;	
static Scanner sc;
public static void admin_registration()  
{	
	 // code here : Admin registration code by Vikram
		System.out.println("\t\t\t\tAdmin Registration");
		System.out.println("*****************************************************************************************");
		System.out.println(" ");
		sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String admin_name = sc.nextLine();
		
		System.out.println("Enter UserName");
		String admin_username=sc.nextLine();
		
		System.out.println("Enter PassWord");
		String admin_password=sc.nextLine();		
		
		System.out.println("Enter Email_Id");
		String email_id = sc.nextLine();
		
		System.out.println("Enter MobileNumber");
		String admin_mob=sc.nextLine();
		
		System.out.println("Enter Designation");
		String admin_designation = sc.nextLine();
		
		int regi_date = 0;
		int admin_DOB = 0;
		
		try {
				Login.dbConnection();		
				String sqlquery = "insert into admin(Admin_ID, Admin_Name, Admin_UserName, Admin_Pwd, Admin_Email, Admin_Mobile, Admin_Designation, Regi_Date, Admin_DOB) values (?,?,?,?,?,?,?,?,?);";
				PreparedStatement prepare = Login.con.prepareStatement(sqlquery);
			    admin_id++;
				prepare.setInt(1,admin_id);
				prepare.setString(2, admin_name);
				prepare.setString(3, admin_username);
				prepare.setString(4, admin_password);
				prepare.setString(5, email_id);
				prepare.setString(6, admin_mob);
				prepare.setString(7, admin_designation);	
				prepare.setInt(8, regi_date);
				prepare.setInt(9, admin_DOB);
		
				int rowsAffected = prepare.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("\nRegistration is successful\n\nPlz login");
}

public static void admin_account(String login_name)
{
	 JavaQuizMain.alignmen(login_name);
	 System.out.print("\n\n1. List scholors ...\n2. Search Student\n\n\n\n\n\n");
	 System.out.println("Enter your choice");
	 Scanner sc1 = new Scanner(System.in);
	 int ad_ch = sc1.nextInt();
	 if (ad_ch==1)
	     listScholars(); // code for showing all the records of students according to their marks
	 else
	     searchStudent(); // code to search by id 
	 
	 
}

public static void listScholars()
{
	try {
		Login.dbConnection();
		String sqlquery="select id, studentName, score, grade, wrong_ans, emailId from student order by score DESC";
		PreparedStatement pre=Login.con.prepareStatement(sqlquery);
		
		ResultSet rst=pre.executeQuery();
		
		System.out.println("\t\t\t\tRead The All Students Record From DataBase\n");
		System.out.println("*******************************************************************************");
		System.out.println(" Id"+"\t       Student Name\t         Score\t      grade\t      Wrong Answers\t      Email Id\n\n");
		while(rst.next())
        {
			System.out.println(" " + rst.getString(1) + 
					"             " + rst.getString(2) + 
					"             " + rst.getString(3) + 
			        "             " + rst.getString(4)+ 
					"             " + rst.getString(5)+ 
					"             " + rst.getString(6));
			System.out.println();
	    }
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public static void searchStudent()
{
	System.out.print("By\n\n1. Name ...\n2. Id\n\n\n\n\n\n");
	 System.out.println("Enter your choice");
	 Scanner sc1 = new Scanner(System.in);
	 int search_ch = sc1.nextInt();
	 if (search_ch==1)   // code to search by name 
	 {
		 try {
				Login.dbConnection();
				System.out.println("Enter the name you want to search");
				Scanner sc2 = new Scanner(System.in);
				String nm = sc2.nextLine();
				
				String sqlquery="select id, studentName, score, grade from student where studentName = '" + nm + "'";
				PreparedStatement pre=Login.con.prepareStatement(sqlquery);
				
				ResultSet rst=pre.executeQuery();
				
				System.out.println("\t\t\t\tRead The All Students Record From DataBase\n");
				System.out.println("*******************************************************************************");
				System.out.println(" Id"+"\t       Student Name\t         Score\t      grade\n\n");
				while(rst.next())
		        {
					System.out.println(" " + rst.getString(1) + 
							"             " + rst.getString(2) + 
							"             " + rst.getString(3) + 
					        "             " + rst.getString(4));
					System.out.println();
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
	 }
	 else if(search_ch==2)   
	     {                // code to search by id 
		 try {
				Login.dbConnection();
				System.out.println("Enter the id you want to search");
				Scanner sc2 = new Scanner(System.in);
				int search_id = sc2.nextInt();
				 				
				String sqlquery="select id, studentName, score, grade from student where id = '" + search_id + "'";
				PreparedStatement pre=Login.con.prepareStatement(sqlquery);
				
				ResultSet rst=pre.executeQuery();
				
				System.out.println("\t\t\t\tRead The All Students Record From DataBase\n");
				System.out.println("*******************************************************************************");
				System.out.println(" Id"+"\t       Student Name\t         Score\t      grade\n\n");
				while(rst.next())
		        {
					System.out.println(" " + rst.getString(1) + 
							"             " + rst.getString(2) + 
							"             " + rst.getString(3) + 
					        "             " + rst.getString(4));
					System.out.println();
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
	     } 
}

}
