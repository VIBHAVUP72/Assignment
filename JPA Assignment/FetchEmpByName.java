package org.jsp.assignments;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.Employee;

public class FetchEmpByName 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name to Fetch");
		String name = sc.next();
		String qry = "select e from Employee e where e.name=?1";
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = m.createQuery(qry);
		q.setParameter(1, name);
		List<Employee> emp = q.getResultList();
		if(emp.size()>0)
		{
			for(Employee e :emp)
			{
				System.out.println("ID : "+e.getId());
				System.out.println("Name : "+e.getName());
				System.out.println("Designation : "+e.getDesg());
				System.out.println("Salary : "+e.getSal());
				
			}
		}
		else
		{
			System.out.println("Invalid ID");
		}
		sc.close();
	}
}
