package com.hexa.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexa.entity.Department;
import com.hexa.entity.Emp;
import com.hexa.exceptions.EmpException;
import com.hexa.util.HibernateUtil;

public class EmpDaoImpl implements IEmpDao{
   
    
	@Override
	public int addEmployee(Emp emp) throws EmpException {
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.save(emp);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			throw new EmpException("ID already exists");
		}finally {
			sess.close();
		}
		return 1;
	}

	@Override
	public int editEmployee(Emp emp) {
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.saveOrUpdate(emp);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			return 0;
		}finally {
			sess.close();
		}
		return 1;
	}

	@Override
	public Emp getEmployee(int eid) throws EmpException {
		Session sess = sfac.openSession();
		Emp emp = sess.get(Emp.class, eid);
		sess.close();
		if(emp == null)
			throw new EmpException("ID not found of EId : " + eid);
		return emp;
	}

	@Override
	public int removeEmployee(int eid) {
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			Emp emp = sess.get(Emp.class, eid);
			sess.delete(emp);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			return 0;
		}finally {
			sess.close();
		}
		return 1;
	}

	@Override
	public List<Emp> getEmployee() {
		Session sess = sfac.openSession();
		Query qry  = sess.createQuery("from Emp ");
		List<Emp> lst = qry.list();
		sess.close();
		return lst;
	}

	@Override
	public List<Emp> getEmployee(String dept) {
		Session sess = sfac.openSession();
		Query qry  = sess.createQuery("from Emp where dept=:dname");
		qry.setParameter("dname", dept);
		List<Emp> lst = qry.list();
		sess.close();
		return lst;
	}

	@Override
	public List<Department> getDepartments() {
		Session sess = sfac.openSession();
		Query qry  = sess.createQuery("from Department");
		List<Department> lst = qry.list();
		sess.close();
		return lst;
	}

}
