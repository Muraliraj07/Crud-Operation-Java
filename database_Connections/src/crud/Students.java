package crud;
import java.sql.*;
import java.util.*;
public class Students {

	public static void main(String[] args) {
		int n=-1;
		Scanner sc=new Scanner (System.in);
		
		while(n!=0) {
		
		  System.out.println("1. Add Student");
		  System.out.println("2. Update Student");
		  System.out.println("3. Delete Student");
		  System.out.println("4. Search Student");
		  System.out.println("5. Display Student"); 
		  System.out.println("0. Exit");
		  System.out.println("Choose any one...");
		  n=sc.nextInt();
		  
		  int regno,fees;
		  String name,dob,course,gender;
		
		switch(n) {
		case 1:
			try {
				
			
			
			System.out.println("Enter Reg No: ");
			regno=sc.nextInt();
			
			System.out.println("Enter Name: ");
			name=sc.next();
			
			System.out.println("Enter DOB: ");
			dob=sc.next();
			
			System.out.println("Enter Gender: ");
			gender=sc.next();
			
			System.out.println("Enter Course: ");
			course=sc.next();
			
			System.out.println("Enter Fees: ");
			fees=sc.nextInt();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"
														+ "students","root","");
			PreparedStatement ps=con.prepareStatement("insert into studentsinfo values"
											+ "(?,?,?,?,?,?)");
			ps.setInt(1,regno);
			ps.setString(2,name);
			ps.setString(3,dob);
			ps.setString(4,gender);
			ps.setString(5,course);
			ps.setInt(6,fees);
			
			int c=ps.executeUpdate();
			
			con.close();
			if(c>0) {
				System.out.println("Data Saved.");
			}
			else {
				System.out.println("Not Saved.");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println();

//Update			
		case 2:
			try {
				System.out.println("Enter Reg No: ");
				regno=sc.nextInt();
				
				System.out.println("Enter Name: ");
				name=sc.next();
				
				System.out.println("Enter DOB: ");
				dob=sc.next();
				
				System.out.println("Enter Gender: ");
				gender=sc.next();
				
				System.out.println("Enter Course: ");
				course=sc.next();
				
				System.out.println("Enter Fees: ");
				fees=sc.nextInt();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students",
											"root","");
				PreparedStatement ps=con.prepareStatement("update studentsinfo SET "
						
						+ "regno=?,dob=?,gender=?,course=?,fees=? where name=?");
				ps.setInt(1, regno);
				ps.setString(2, dob);
				ps.setString(6, name);
				ps.setString(3, gender);
				ps.setString(4, course);
				ps.setInt(5, fees);
				
				int c1=ps.executeUpdate();
				con.close();
				if(c1>0) {
					System.out.println("Data Updated.");
				}
				else {
					System.out.println("Error!");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			System.out.println();

			
//DELETE			
		case 3:
			try {
				System.out.println("Enter Reg No: ");
				regno=sc.nextInt();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"
						+ "students","root","");
				PreparedStatement st=con.prepareStatement("Delete from studentsinfo where regno=?");
				st.setInt(1,regno);
				
				int c2=st.executeUpdate();
				if(c2>0) {
					System.out.println("Deleted");
				}
				else {
					System.out.println("Error");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			System.out.println();

//SEARCH 
		case 4:
			try {
				System.out.println("Enter Reg No: ");
				regno=sc.nextInt();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"
						+ "students","root","");
				PreparedStatement st=con.prepareStatement("select*from studentsinfo where regno=?");
				st.setInt(1,regno);
				
				ResultSet rs=st.executeQuery();
				
				int err=0;
				while(rs.next()) {
					System.out.println("REG NO: "+rs.getInt(1));
					System.out.println("NAME: "+rs.getString(2));
					System.out.println("DOB: "+rs.getString(3));
					System.out.println("GENDER: "+rs.getString(4));
					System.out.println("COURSE: "+rs.getString(5));
					System.out.println("FEES: "+rs.getInt(6));
					err=1;
				}
				if(err==0) {
					System.out.println("Invalid");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			System.out.println();


//DISPLAY
		case 5:
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"
						+ "students","root","");
				PreparedStatement st=con.prepareStatement("select*from studentsinfo");
				
				ResultSet rs=st.executeQuery();
				
				int err1=0;
				while(rs.next()) {
					System.out.println("REG NO: "+rs.getInt(1));
					System.out.println("NAME: "+rs.getString(2));
					System.out.println("DOB: "+rs.getString(3));
					System.out.println("GENDER: "+rs.getString(4));
					System.out.println("COURSE: "+rs.getString(5));
					System.out.println("FEES: "+rs.getInt(6));
					err1=1;
				}
				if(err1==0) {
					System.out.println("Error");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			System.out.println();

			break;
			
		case 0:
			System.out.println("Exited");
			System.out.println();
			break;
		
		default:
            System.out.println("Invalid choice, please choose again.");
            break;
		}
	}
	}
}
