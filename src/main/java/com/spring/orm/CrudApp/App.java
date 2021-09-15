package com.spring.orm.CrudApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.SpringORM.Dao.StudentDao;
import com.spring.orm.SpringORM.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
        boolean go=true;
        while(go)
        {
        	System.out.println("1-Add Student");
        	System.out.println("2-Display All Student");
        	System.out.println("3-Get Single Student");
        	System.out.println("4-Delete Student");
        	System.out.println("5-Update Student");
        	System.out.println("6-Exit");
        	try
        	{
        		int input=Integer.parseInt(bufferedReader.readLine());
        		switch(input)
        		{
        		case 1:
        			System.out.println("Enter Id:");
        			int id=Integer.parseInt(bufferedReader.readLine());
        			System.out.println("Enter your Name:");
        			String name=bufferedReader.readLine();
        			System.out.println("Enter your City:");
        			String city=bufferedReader.readLine();
        			Student s=new Student();
        			s.setStudentId(id);
        			s.setStudentName(name);
        			s.setStudentCity(city);
        			studentDao.insert(s);
        			break;
        		case 2:
        			List<Student> s2=studentDao.getAll();
        	        for(Student st:s2)
        	        {
        	        	System.out.println("Id:"+ st.getStudentId());
        	        	System.out.println("Name:"+ st.getStudentName());
        	        	System.out.println("City:"+ st.getStudentCity());
        	        	System.out.println("__________________________________________");
        	        }
        	        break;
        		case 3:
        			System.out.println("Enter Id: ");
        			int Id=Integer.parseInt(bufferedReader.readLine());
        			Student s1=studentDao.getStudent(Id);
        			System.out.println("Id:"+ s1.getStudentId());
    	        	System.out.println("Name:"+ s1.getStudentName());
    	        	System.out.println("City:"+ s1.getStudentCity());
    	        	System.out.println("__________________________________________");
        			
    	        break;
        		case 4:
        			System.out.println("Enter Id: ");
        			int userId=Integer.parseInt(bufferedReader.readLine());
        			Student std=studentDao.getStudent(userId);
        			if(std!=null)
        			{
        				studentDao.delete(userId);
        				System.out.println("______________Deleted Successfully_____________________ ");
        				
        			}
        			else
        			{
        				System.out.println("Enter correct  Id This is not exist2 ");
        			}
        			break;
        		case 5:
        			System.out.println("Enter Id: ");
        			int usId=Integer.parseInt(bufferedReader.readLine());
        			Student stdt=studentDao.getStudent(usId);
        			if(stdt!=null)
        			{
        				System.out.println("Enter your Name:");
            			String n=bufferedReader.readLine();
            			System.out.println("Enter your City:");
            			String c=bufferedReader.readLine();
            			Student student=new Student();
            			student.setStudentId(usId);
            			student.setStudentName(n);
            			student.setStudentCity(c);
            			studentDao.update(student);
            			System.out.println("______________UPDATED Successfully_____________________ ");
            			
        				
        			}
        			else
        			{
        				System.out.println("Enter correct  Id This is not exist2 ");
        			}
        			break;
        		case 6:
        			go=false;
        			break;
        	
        			
        		  
        			
        			
        			
        		}
        	}
        	catch(Exception e)
        	{
        		System.out.println("Invalid Input" );
        	}
        }
        
    }
}
