package org.jsp.assignments;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanybi.Department;

public class FetchDeptById {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Departmnet ID to Fetch");
		int id = sc.nextInt();
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Department d = m.find(Department.class, id);
		if(d!=null)
		{
			System.out.println("ID : "+d.getId());
			System.out.println("Name : "+d.getName());
			System.out.println("Location : "+d.getLoc());
		}
		else
		{
			System.out.println("Invalid ID");
		}
		sc.close();
	}

}
