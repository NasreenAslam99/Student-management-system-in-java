package com.sms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Studentmain {
	private static Scanner Sc=new Scanner(System.in);
	public static void addStudent() {
		System.out.println("Enter the student name:");
		String name=Sc.nextLine();
		
		System.out.println("enter the student age:");
		int age=Integer.parseInt(Sc.nextLine());
		
		System.out.println("Enter the student email:");
		String email=Sc.nextLine();
		
		System.out.println("Enter the student course:");
		String course=Sc.nextLine();
		
		String sql="insert into studentdemo(name, age, email, course) values(?,?,?,?)";
		
		try(Connection connection=Jdbcconnection.getConnection();
				PreparedStatement st=connection.prepareStatement(sql)){
			
			st.setString(1, name);
			st.setInt(2, age);
			st.setString(3, email);
			st.setString(4, course);
			int rowsAffected=st.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Student added succesfully");
			}
		}catch (SQLException e) {
			    System.out.println("Error adding student: " + e.getMessage());
			}
		
		
	}
	
	
	//update a student record
	public static void updateStudent() {
		System.out.println("Enter student ID to update:");
		int id= Integer.parseInt(Sc.nextLine());
		
	System.out.println("enter new student name:");
		String name=Sc.nextLine();
		
		System.out.println("enter new student age:");
		int age=Integer.parseInt(Sc.nextLine());
		
		System.out.println("Enter new student email:");
		String email=Sc.nextLine();
		
		System.out.println("Enter new student course:");
		String course=Sc.nextLine();
		
		String sql = "UPDATE studentdemo SET name = ?, age = ?, email = ?, course = ? WHERE id = ?";
		
		try(Connection connection=Jdbcconnection.getConnection();
				PreparedStatement st=connection.prepareStatement(sql)){
			
			st.setString(1, name);
			st.setInt(2, age);
			st.setString(3, email);
			st.setString(4, course);
			st.setInt(5, id);
		
			int rowsAffected=st.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Student updated succesfully");
			}
		}catch (SQLException e) {
			    System.out.println("Error adding student: " + e.getMessage());
			}
		
		
	}
	
	//delete a student record
	public static void deleteStudent() {
		System.out.println("enter student id to delete:");
		int id =Integer.parseInt(Sc.nextLine());
		
		String sql="delete from studentdemo where id=?";
		try(Connection connection=Jdbcconnection.getConnection();
				PreparedStatement st=connection.prepareStatement(sql)){
			
			st.setInt(1, id);
			int rowsAffected=st.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Student deleted succesfully");
			}
		}catch (SQLException e) {
			    System.out.println("Error adding student: " + e.getMessage());
			}
		
		
	}
	//view all students
	public static void viewAllStudents() {
		String sql="select * from studentdemo";
		
		try (Connection connection=Jdbcconnection.getConnection();
				Statement SS=connection.createStatement();
				ResultSet rs=SS.executeQuery(sql)){
				
			while(rs.next()) {
				System.out.println("ID:"+rs.getInt("id"));
				System.out.println("Name:"+rs.getString("name"));
				System.out.println("Age:"+rs.getInt("age"));
				System.out.println("Email:"+rs.getString("email"));
				System.out.println("-----------------------");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
		
	
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View All Student");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice:");
		
		int choice=Integer.parseInt(Sc.nextLine());
		
		switch(choice) {
		case 1:
			addStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			viewAllStudents();
			break;
		case 5:
			System.out.println("existing....");
			return;
			default:
				System.out.println("invalid choice, please try again!!");
		}
		}
		
	}
	

}
