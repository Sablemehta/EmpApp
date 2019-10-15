package com.hexa.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;

import com.hexa.entity.Department;
import com.hexa.entity.Emp;
import com.hexa.exceptions.EmpException;
import com.hexa.util.HibernateUtil;

public interface IEmpDao {
	SessionFactory sfac = HibernateUtil.getSessionFactory();
	public List<Department> getDepartments();
	public int addEmployee(Emp emp)throws EmpException;
	public int editEmployee(Emp emp);
	public Emp getEmployee(int eid)throws EmpException;
	public int removeEmployee(int eid);
	public List<Emp> getEmployee();
	public List<Emp> getEmployee(String dept);
}
