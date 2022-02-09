package com.situ.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.model.Department;
import com.situ.model.DepartmentSearchBean;
import com.situ.service.DepartmentService;

@Controller
@RequestMapping("/department/")
public class DepartmentController {
	@Autowired
	private DepartmentService service ;

	/**
	 * 显示列表
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @param esb
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Map<String, Object> map,  Integer pageNo,
			Integer pageSize,DepartmentSearchBean dsb) {
		if(pageNo==null||pageNo<1) {
			pageNo=1;
		}
		if(pageSize==null||pageSize==0) {
			pageSize=5;
		}
		
		PageHelper.startPage(pageNo , pageSize);

		List<Department> departments = service.findDepartAll(dsb);
		
		PageInfo<Department> p=new PageInfo<>(departments);
		
		
		map.put("departments", departments);
		map.put("p", p);
		map.put("dsb", dsb);
		return "department/department";
	}

	/**
	 * 实现批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> delete(Integer[] ids) {

		System.out.println(ids.length);
		Map<String, Object> resp = new HashMap<>();
		int rows = service.deleteByIds(ids);
		System.out.println(rows);
		if (rows > 0) {
			resp.put("success", true);
			resp.put("rows", rows);
		} else {
			resp.put("success", false);
			resp.put("error", "删除数据时异常");
		}
		return resp;

	}

	@GetMapping("/add")
	public String gotoAdd() {
		return "department/add";
	}

	/**
	 * 添加员工信息
	 * @param map
	 * @param e
	 * @return
	 */
	@PostMapping("/add")
	public String subAdd(Map<String, Object> map, Department d) {
		System.out.println(d);
		boolean success;
		try {
			success = service.save(d);
		} catch (Exception e1) {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("d", d);
			return "department/add";
		}
		if (success) {
			return "redirect:/department/list";
		} else {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("d", d);
			return "department/add";
		}
	}

	@GetMapping("/edit")
	public String gotoEdit(Integer id, Map<String, Object> map) {

		Department d = service.findById(id);
		if (d != null) {
			map.put("d", d);
			return "department/edit";
		} else {
			map.put("error", "沒有該部门");
			return "redirect:/department/list";
		}

	}

	
	@PostMapping("/edit")
	public String subEdit(Map<String, Object> map, Department d) {
		System.out.println(d);
		boolean success;
		try {
			success = service.update(d);
		} catch (Exception e1) {
			map.put("error", "沒有該部门");
			
			return "department/edit";
		}
		if(success) {
			return "redirect:/department/list";
		}else {
			return "department/edit";
		}

		
	}

}
