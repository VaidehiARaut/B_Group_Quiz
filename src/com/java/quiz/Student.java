package com.java.quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Student {

	static int stu_id=0;
 	static String grade="";
 	static int wrong_ans=0;
	 	
	public static void student_registration()
	{
		 		// using scanner class
		 		System.out.println("\t\t\t\tStudent Registration");
		 		System.out.println("*****************************************************************************************");
		 		System.out.println(" ");
		 		Scanner sc = new Scanner(System.in);
		 		System.out.println("Name");
		 		String studentname = sc.nextLine();
		 		
		 		System.out.println("Enter UserName");
		 		String username=sc.nextLine();
		 		
		 		System.out.println("Enter PassWord");
		 		String password=sc.nextLine();
		 		
		 		System.out.println("Enter MobileNumber");
		 		long mobilenum=sc.nextLong();
		 		
		 		System.out.println("Enter Email_Id");
		 		String emailid = sc.next();
		 		
		 		int score=0;
		 		
		 		try {
		 				Login.dbConnection();

		 				String sqlquery = "insert into student(studentname,username,password,mobilenum,emailid,score,grade,id,wrong_ans) values (?,?,?,?,?,?,?,?,?);";
		 				PreparedStatement prepare = Login.con.prepareStatement(sqlquery);
		 				stu_id++;
		 		
		 				prepare.setString(1,studentname);
		 				prepare.setString(2,username);
		 				prepare.setString(3,password);
		 				prepare.setLong(4,mobilenum);
		 				prepare.setString(5,emailid);
		 				prepare.setInt(6, score);
		 				prepare.setString(7,grade);	
		 				prepare.setInt(8, stu_id);
		 				prepare.setInt(9, wrong_ans);
		 		
		 				int rowsAffected = prepare.executeUpdate();
		 			}
		 			catch(Exception e)
		 			{
		 				e.printStackTrace();
		 			}
		 		System.out.println("\nRegistration is successful\n\nPlz login");
	}
	
	public static void student_account(String login_name)
	{
    	 JavaQuizMain.alignmen(login_name);
		 System.out.print("Here Your Quiz Starts\n\n\n");
		 
		 start_quiz(login_name);  // code here : Code for randomly generated quiz by Ashwini
		 
    }
	
	public static void start_quiz(String login_name)
	{
		int score = 0, wrong_ans = 0;
		String grade = "";
		try
		{
			Login.dbConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
        Random ran = new Random();
		try 
		{
			int i = 1;
			
			do
			{
				int x = ran.nextInt(2) + 3;
						
				Login.rs = Login.stmt.executeQuery("select java_question, optionA, optionB, optionC, option_yes from javaquiz where id=" +x); // if ch is 1(student)
				Login.rs.next();
				System.out.println(i + ". " + Login.rs.getString(1) );
				System.out.println("   a. " + Login.rs.getString(2) + "\n" + "   b. " + Login.rs.getString(3) + "\n" + "   c. " + Login.rs.getString(4) + "\n" + "   d. " + Login.rs.getString(5) + "\n\n\n");
				
				System.out.println("Enter your option : ");
				Scanner sc = new Scanner(System.in);
				char option = sc.nextLine().charAt(0);
				System.out.println("\n");
				if (option=='d')
					score++;
				else
					wrong_ans++;
				i++;
			} while (i<=4);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		JavaQuizMain.alignmen(login_name);
		System.out.println("\n\n");
		if(score==4 || score==3)
		{
			System.out.println("Congratualation...!!!\n");
			grade = "A";
		}
		else if(score==2) { grade="B"; System.out.println("Good attempt...!!!\n");}
		else if(score==1) { grade="c"; System.out.println("Scope is there for improvement...!!!\n");}
		else { grade="Fail"; System.out.println("Work Hard...!!!\n");}
		   
		System.out.println(login_name + ", Your score is " + score + "\n\t Wrong answers " + wrong_ans + "\n\n\t Grade is " + grade);
		System.out.println("\n\n\n\n\n\n");
		try 
		{
			String updateQuery = "update student set score = ?, grade = ?, wrong_ans = ? where username = '" + login_name + "'";
			PreparedStatement preparedStmt = Login.con.prepareStatement(updateQuery);
			preparedStmt.setInt   (1, score);
			preparedStmt.setString(2, grade);
			preparedStmt.setInt(3, wrong_ans);

	        preparedStmt.executeUpdate();	      
	        Login.con.close();
		}
		catch(SQLException e) {e.printStackTrace();}
	}
}
