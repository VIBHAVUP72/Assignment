package org.jsp.assignments;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.Department;

public class FetchDeptByLoc 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Departmnet Location to Fetch");
		String loc = sc.next();
		String qry = "select d from Department d where d.loc=?1";
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = m.createQuery(qry);
		q.setParameter(1, loc);
		List<Department> dept = q.getResultList();
		if(dept.size()>0)
		{
			for(Department d :dept)
			{
				System.out.println("ID : "+d.getId());
				System.out.println("Name : "+d.getName());
				System.out.println("Location : "+d.getLoc());
			}
		}
		else
		{
			System.out.println("Invalid ID");
		}
		sc.close();
	}
}
