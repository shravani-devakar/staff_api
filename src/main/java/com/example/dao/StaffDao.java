package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Staff;

@Repository
public class StaffDao {

	@Autowired
	private SessionFactory sf;

	public boolean insertStaff(Staff staff) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(staff);
		tx.commit();

		session.close();
		return true;

	}

	public List<Staff> getAllStaff() {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> list = criteria.list();

		session.close();
		return list;

	}

	public Staff getById(int id) {

		Session session = sf.openSession();

		Staff staff = session.get(Staff.class, id);

		session.close();
		return staff;

	}

	public List<Staff> salaryGT(double salary) {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", salary));

		List<Staff> list = criteria.list();

		session.close();
		return list;
	}

	public List<Staff> experienceBtw(int exp1, int exp2) {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", exp1, exp2));

		List<Staff> list = criteria.list();

		session.close();
		return list;

	}

	public Staff maxSalaryStaff() {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.max("salary"));

		Double maxSalary = (Double) criteria.uniqueResult();

		Criteria criteria2 = session.createCriteria(Staff.class);
		criteria2.add(Restrictions.eq("salary", maxSalary));

		Staff staff = (Staff) criteria2.uniqueResult();

		session.close();
		return staff;

	}

	public boolean updateSalaryById(int id, double newSal) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Staff staff = session.get(Staff.class, id);

		staff.setSalary(newSal);
		session.update(staff);
		tx.commit();

		session.close();
		return true;
	}

	public String minExpStaff() {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.min("experience"));

		int minExp = (int) criteria.uniqueResult();

		Criteria criteria2 = session.createCriteria(Staff.class);
		criteria2.add(Restrictions.eq("experience", minExp));
		criteria2.setProjection(Projections.property("name"));

		String name = (String) criteria2.uniqueResult();

		session.close();
		return name;

	}

	public List<Staff> getStaffByProfile(String profile) {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile", profile).ignoreCase());

		List<Staff> list = criteria.list();

		session.close();
		return list;

	}

	public List<Staff> getStaffNeProfile(String profile) {

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", profile).ignoreCase());

		List<Staff> list = criteria.list();

		session.close();
		return list;
	}

}
