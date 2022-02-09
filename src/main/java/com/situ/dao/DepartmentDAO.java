package com.situ.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Department;
import com.situ.model.DepartmentSearchBean;


@Mapper
public interface DepartmentDAO {


	/**
	 * 查询所有部门信息
	 * @param p
	 * @return
	 */
	public List<Department> findDepartAll(DepartmentSearchBean dsb);

	/**
	 * 根据编号批量删除
	 * @param ids
	 * @return
	 */
	public int deleteByIds(Integer[] ids);

	/**
	 * 保存一个部门信息
	 * @param d
	 * @return
	 */
	public boolean save(Department d);

	/**
	 * 通过id查找部门信息
	 * @param id
	 * @return
	 */
	public Department findById(Integer id);

	/**
	 * 修改部门信息
	 * @param e
	 * @return
	 */
	public boolean update(Department e);

	/**
	 * 查询部门的所有id
	 * @return
	 */
	public List<Department> find();

}
