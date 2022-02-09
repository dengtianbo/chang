package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;

@Mapper
public interface EmployeeDao {
	/**
	 * 查询所有员工信息
	 * @param p
	 * @return
	 */
	public List<Employee> findEmpAll(EmployeeSearchBean esb);

	/**
	 * 根据编号批量删除
	 * @param ids
	 * @return
	 */
	public int deleteByIds(Integer[] ids);

	/**
	 * 保存一个员工信息
	 * @param e
	 * @return
	 */
	public boolean save(Employee e);

	/**
	 * 通过id查找员工信息
	 * 
	 * @param id
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
