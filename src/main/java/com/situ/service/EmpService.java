package com.situ.service;

import java.util.List;


import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;

/**
 * 员工业务
 * @author 浅墨~~
 * @date  2021年12月2日
 */


public interface EmpService {
	
	public List<Employee> findEmpAll( EmployeeSearchBean esb);

	/**
	 * 根据ids删除数组
	 * @param ids
	 * @return
	 */
	public int deleteByIds(Integer [] ids);

	//添加员工
	public boolean save(Employee e);

	/**
	 * 通过id查找员工信息
	 * @param valueOf
	 * @return
	 */
	public Employee findById(Integer id);

	/**
	 * 修改员工信息
	 * @param e
	 * @return
	 */
	public boolean update(Employee e);
	
	
}
