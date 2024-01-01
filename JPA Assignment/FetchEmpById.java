package org.jsp.assignments;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.Employee;

public class FetchEmpById
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID to Fetch");
		int id = sc.nextInt();
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Employee e = m.find(Employee.class, id);
		if(e!=null)
		{
			System.out.println("ID : "+e.getId());
			System.out.println("Name : "+e.getName());
			System.out.println("Designation : "+e.getDesg());
			System.out.println("Salary : "+e.getSal());
		}
		else
		{
			System.out.println("Invalid ID");
		}
		sc.close();
	}
}
