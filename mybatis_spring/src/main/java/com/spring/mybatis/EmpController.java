package com.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@Autowired
	EmpServiceImpl service;
	
	@RequestMapping(value="insert.emp", method=RequestMethod.GET)
	public ModelAndView insertEmp(){
		ModelAndView mav = new ModelAndView();
		List<JobVO> joblist = service.getJobList();
		mav.addObject("joblist",joblist);
		mav.setViewName("insertform");
		return mav;
	}
	
	
	@RequestMapping(value="insert.emp", method=RequestMethod.POST)
	public String insertEmp(@ModelAttribute("empvo") EmpVO vo){
		service.insertEmp(vo);
		return "insertformSubmit";
	}
	
	
	@RequestMapping("list.emp")
	public ModelAndView getList(){
		List<EmpVO> list = service.getAllEmp();
		return new ModelAndView("emplist", "emplist", list);
	}
	
	@RequestMapping("one.emp")
	public ModelAndView getOneEmp(@RequestParam(value= "emp", required=false, defaultValue="100") int emp){
		EmpVO oneEmp = service.getEmp(emp);
		return new ModelAndView("emp", "oneEmp", oneEmp);
	}

}
