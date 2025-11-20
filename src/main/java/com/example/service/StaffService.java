package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StaffDao;
import com.example.entity.Staff;

@Service
public class StaffService {

	@Autowired
	private StaffDao staffDao;

	public String insertStaff(Staff staff) {

		boolean isInserted = staffDao.insertStaff(staff);
		if (isInserted) {

			return "Staff inserted susseccfully..!!";

		} else {

			return "Not inserted..!!";

		}
	}

	public List<Staff> getAllStaff() {

		List<Staff> list = staffDao.getAllStaff();

		if (list != null) {

			return list;

		} else {

			return null;

		}

	}

	public Staff getById(int id) {

		Staff staff = staffDao.getById(id);

		if (staff != null) {

			return staff;

		} else {

			return null;

		}

	}

	public List<Staff> salaryGT(double salary) {

		List<Staff> list = staffDao.salaryGT(salary);

		if (list != null) {

			return list;

		} else {

			return null;

		}
	}

	public List<Staff> experienceBtw(int exp1, int exp2) {

		List<Staff> list = staffDao.experienceBtw(exp1, exp2);

		if (list != null) {

			return list;

		} else {

			return null;

		}
	}

	public Staff maxSalaryStaff() {

		Staff staff = staffDao.maxSalaryStaff();

		if (staff != null) {

			return staff;

		} else {

			return null;

		}

	}

	public String updateSalaryById(int id, double newSal) {

		boolean isUpdated = staffDao.updateSalaryById(id, newSal);

		if (isUpdated) {

			return "Salary updated successfully of staff id : " + id;

		} else {

			return "Salary did not updated..!!";

		}

	}

	public String minExpStaff() {

		String name = staffDao.minExpStaff();

		if (name != null) {

			return "Staff with minimum experience : " + name;

		} else {

			return null;

		}

	}

	public List<Staff> getStaffByProfile(String profile) {

		List<Staff> list = staffDao.getStaffByProfile(profile);

		if (list != null) {

			return list;

		} else {

			return null;

		}

	}

	public List<Staff> getStaffNeProfile(String profile) {

		List<Staff> list = staffDao.getStaffNeProfile(profile);

		if (list != null) {

			return list;

		} else {

			return null;

		}
	}

}
