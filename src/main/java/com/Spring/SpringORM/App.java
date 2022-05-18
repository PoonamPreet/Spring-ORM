package com.Spring.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.orm.dao.StudentDao;
import com.Spring.orm.entities.Student;

public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Config.xml");
		StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		Student student=new Student(0,"Poonam","Delhi");

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		boolean go=true;
		while(go)
		{
			System.out.println("1.New Student");
			System.out.println("2.Delete Student");
			System.out.println("3.Update Student");
			System.out.println("4.Get Student");
			System.out.println("5.Get Students");
			System.out.println("6.Exit");


			try {
				int input=Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// Add a new Student
					//insert
					student.setStd_id(0);
					String std_name=br.readLine();
					student.setStd_name(std_name);
					String std_address=br.readLine();
					student.setStd_address(std_address);
					int r=studentDao.insert(student);
					System.out.println("Added.."+r);
					break;
				case 2:
					// Delete  Student
					//delete
					System.out.println("Enter user id");
					int id=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Data Deleted");
					break;

				case 3:
					//update Student
					//update
					System.out.println("Enter user id");
					id=Integer.parseInt(br.readLine());
					student=new Student(); 
					student.setStd_id(id);
					System.out.println("Enter user name");
					student.setStd_name(br.readLine());
					System.out.println("Enter address");
					student.setStd_address(br.readLine());
					studentDao.updateStudent(student);
					System.out.println("Data updated....");
					break;

				case 4:
					//get  Student
					System.out.println("Enter user id");
					id=Integer.parseInt(br.readLine());
					student=studentDao.getStudent(id);
					System.out.println(student);
					System.out.println("Name: "+student.getStd_name()+"   "+ "address:"+student.getStd_address());
					break;

				case 5:
					// get All Students
					List<Student> students=studentDao.getAllStudents();
					for(Student st:students)
					{
						System.out.println("Name: "+st.getStd_name()+"address:"+st.getStd_address());
					}

					break;

				case 6:
					//exit
					//System.exit(0);
					go=false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid input try with correct input");
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Thank you,visit again!!!6");

	}
}
