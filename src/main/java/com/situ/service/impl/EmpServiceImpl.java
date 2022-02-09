package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.EmployeeDao;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.EmpService;

/**
 * 员工业务
 * @author 浅墨~~
 * @date  2021年12月2日
 */

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmployeeDao dao;
	
	public List<Employee> findEmpAll( EmployeeSearchBean esb){
		
		return dao.findEmpAll(esb);
	}

	public int deleteByIds(Integer [] ids) {
		
		return dao.deleteByIds(ids);
	}

	//添加员工
	public boolean save(Employee e) {
//		dao.save(e);
//		dao.save(e);
		return dao.save(e);
	}

	/**
	 * 通过id查找员工信息
	 * @param valueOf
	 * @return
	 */
	public Employee findById(Integer id) {
		
		return dao.findById(id);
	}

	/**
	 * 修改员工信息
	 * @param e
	 * @return
	 */
	public boolean update(Employee e) {
		return dao.update(e);
	}
	
	
}
