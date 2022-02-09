package com.situ.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.DepartmentDAO;
import com.situ.model.Department;
import com.situ.model.DepartmentSearchBean;
import com.situ.service.DepartmentService;

/**
 * 部门业务
 * @author 浅墨~~
 * @date  2021年12月2日
 */

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDAO dao;
	
	public List<Department> findDepartAll( DepartmentSearchBean dsb){
		
		return dao.findDepartAll(dsb);
	}

	public int deleteByIds(Integer [] ids) {
		
		return dao.deleteByIds(ids);
	}

	//添加部门
	public boolean save(Department d) {
		
		return dao.save(d);
	}

	/**
	 * 通过id查找员工信息
	 * @param valueOf
	 * @return
	 */
	public Department findById(Integer id) {
		
		return dao.findById(id);
	}

	/**
	 * 修改部门信息
	 * @param e
	 * @return
	 */
	public boolean update(Department e) {
		return dao.update(e);
	}

	/**
	 * 查询部门的所有id
	 * @return
	 */
	public List<Integer> find() {
		
		List<Department> ds = dao.find();
		List<Integer> list =new  ArrayList<Integer>();
		for (Department d : ds) {
			list.add(d.getId());
		}
		return list;
	}

	
	
	
}
