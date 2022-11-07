package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class JavaQuizMain {

	
	static String welcome_name = "";
	public static void alignmen(String welcome_name)
	{
		System.out.println("\n\t\t\t       Welcome " + welcome_name + " " + "\n\t\t\t           @\n\t\t\t       Java Quiz");
		System.out.println("\n\n****************************************************************************************\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JavaQuizMain jq = new JavaQuizMain();
		alignmen(welcome_name);
		
	    Login login = new Login();
		login.role();
		//login.direct_login(ch);
		
	}

}
