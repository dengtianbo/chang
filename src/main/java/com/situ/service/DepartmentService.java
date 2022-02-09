package com.situ.service;

import java.util.List;


import com.situ.model.Department;
import com.situ.model.DepartmentSearchBean;
import com.situ.utils.PaginateInfo;

/**
 * 员工业务
 * @author 浅墨~~
 * @date  2021年12月2日
 */


public interface DepartmentService {
	
	
	public List<Department> findDepartAll( DepartmentSearchBean dsb);

	public int deleteByIds(Integer [] ids) ;

	//添加员工
	public boolean save(Department d) ;

	/**
	 * 通过id查找员工信息
	 * @param valueOf
	 * @return
	 */
	public Department findById(Integer id);

	/**
	 * 修改员工信息
	 * @param e
	 * @return
	 */
	public boolean update(Department e);

	/**
	 * 查询部门的所有id
	 * @return
	 */
	public List<Integer> find() ;
	
	
}
