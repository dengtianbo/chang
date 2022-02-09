package com.situ.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.config.Global;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.DepartmentService;
import com.situ.service.EmpService;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	private EmpService service;

	@Autowired
	private DepartmentService deservice;

	/**
	 * 显示列表
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @param esb
	 * @return
	 */
	@RequestMapping(value = { "/list" })
	public String list(Map<String, Object> map, Integer pageNo, Integer pageSize, EmployeeSearchBean esb) {

		// System.out.println(esb.getId());
		//PaginateInfo p = new PaginateInfo(pageNo, pageSize);

		// 使用mybatis的分页插件进行分页
		if(pageNo==null||pageNo<1) {
			pageNo=1;
		}
		if(pageSize==null||pageSize==0) {
			pageSize=15;
		}
		
		PageHelper.startPage(pageNo , pageSize);

		List<Employee> employees = service.findEmpAll(esb);
		
		PageInfo<Employee> p=new PageInfo<Employee>(employees);
		
		map.put("employees", employees);
		map.put("p", p);
		map.put("esb", esb);
		return "employee/employee";
	}

	/**
	 * 实现批量删除
	 * @param ids
	 * @return
	 */
	@PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> delete(Integer[] ids) {

		Map<String, Object> resp = new HashMap<>();
		int rows = service.deleteByIds(ids);
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
	public String gotoAdd(Map<String, Object> map) {
		List<Integer> ids = deservice.find();

		map.put("ids", ids);
		System.out.println(ids.size());
		return "employee/add";
	}

	/**
	 * 添加员工信息
	 * @param map
	 * @param e
	 * @return
	 */
	@PostMapping("/add")
	public String subAdd(Map<String, Object> map, Employee e) {
		System.out.println(e);
		List<Integer> ids = deservice.find();
		boolean success;
		try {
			success = service.save(e);
		} catch (Exception e1) {

			map.put("ids", ids);
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("e", e);
			return "employee/add";
		}
		if (success) {
			return "redirect:/employee/list";
		} else {
			map.put("ids", ids);
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("e", e);
			return "employee/add";
		}
	}

	@GetMapping("/edit")
	public String gotoEdit(Integer id, Map<String, Object> map) {

		List<Integer> ids = deservice.find();

		Employee e = service.findById(id);
		if (e != null) {
			map.put("e", e);
			map.put("ids", ids);
			return "employee/edit";
		} else {
			map.put("error", "沒有該員工");
			return "redirect:/employee/list";
		}

	}

	@PostMapping("/edit")
	public String subEdit(Map<String, Object> map, Employee e,
			@RequestParam(name = "portrait-pic") MultipartFile file) {
		System.out.println(e);
		List<Integer> ids = deservice.find();

		String uid = UUID.randomUUID().toString();// 保证不重复
		String originalName = file.getOriginalFilename();// 原始文件名
		System.out.println(originalName);
		int lidx = originalName.lastIndexOf(".");
		String ext = originalName.substring(lidx + 1);// 上传文件的扩展名
		// 用户可自定义位置
		String fullName = Global.UPLOAD_PORTRAIT_PATH + "/" + uid + "." + ext;// 文件全名

		File target = new File(fullName);
		try {
			file.transferTo(target);
			e.setPortrait("/upload/image/portrait/" + uid + "." + ext);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		boolean success;
		try {
			success = service.update(e);
		} catch (Exception e1) {
			map.put("error", "沒有該員工");
			map.put("ids", ids);
			return "employee/edit";

		}
		if (success) {
			return "redirect:/employee/list";
		} else {
			map.put("ids", ids);
			return "employee/edit";
		}

	}

}
