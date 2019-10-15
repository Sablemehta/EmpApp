package com.hexa.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hexa.dao.EmpDaoImpl;
import com.hexa.dao.IEmpDao;
import com.hexa.entity.Department;
import com.hexa.entity.Emp;
import com.hexa.exceptions.EmpException;

public class EmpAppController {

	IEmpDao dao = new EmpDaoImpl();
	
	public String processViewAll(HttpServletRequest req) {
		List<Emp> lst = dao.getEmployee();
		req.setAttribute("elist", lst);
		return "EmpList.jsp";
	}
	
	public List<Department> getDepartment() {
		return dao.getDepartments();
	}
	
	public String processViewByDept(HttpServletRequest req) {
		String dname = req.getParameter("dept");
		List<Emp> lst = dao.getEmployee(dname);
		req.setAttribute("elist", lst);
		return "EmpList.jsp";
	}
	
	public String processViewById(HttpServletRequest req) {
		int eid = Integer.parseInt(req.getParameter("txteid"));
		try {
		Emp emp =dao.getEmployee(eid);
		req.setAttribute("employee", emp);
		} catch(EmpException e) {
			req.setAttribute("msg", e.getMessage());	
		}
		if(req.getServletPath().equals("/edit.htm")) {
			return "EditEmployee.jsp";
		}
		return "EmpId.jsp";
	}
	
	public String updateEmployee(HttpServletRequest req) {
		int eid = Integer.parseInt(req.getParameter("txteid"));
		double sal = Double.parseDouble(req.getParameter("txtsal"));
		String dept = req.getParameter("cbodept");
		String strdoj = req.getParameter("txtdt");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate ldt = LocalDate.parse(strdoj, dtf);
		
		Emp emp;
		try {
			emp=dao.getEmployee(eid);
			emp.setDept(dept);
			emp.setDoj(ldt);
			emp.setEmpSal(sal);
			dao.editEmployee(emp);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	return "viewall.htm";
	}
//	public int addEmployee(Emp emp) throws EmpException {
//		Session sess = sfac.openSession();
//		Transaction tx = sess.beginTransaction();
//		try {
//			sess.save(emp);
//			tx.commit();
//		}catch(HibernateException ex) {
//			tx.rollback();
//			throw new EmpException("ID already exists");
//		}finally {
//			sess.close();
//		}
//		return 1;
//	}
	
	public String addEmployeeToTheTable(HttpServletRequest req) {
		Emp emp = new Emp();
		emp.setEmpId(Integer.parseInt(req.getParameter("txteid")));
		emp.setEmpName(req.getParameter("txtname"));
		emp.setEmpSal(Double.parseDouble(req.getParameter("txtsal")));
		emp.setDept(req.getParameter("cbodept"));
		String sdt = req.getParameter("txtdt");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate ldt = LocalDate.parse(sdt, dtf);
		emp.setDoj(ldt);
		try {
			dao.addEmployee(emp);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "viewall.htm";
	}
}
