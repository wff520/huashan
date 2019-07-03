package com.yidu.wff.base.fixedArea.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.wff.base.fixedArea.biz.FixedAreaBiz;
import com.yidu.wff.base.fixedArea.biz.impl.FixedAreaImpl;
import com.yidu.wff.base.fixedArea.dao.FixedAreaDao;
import com.yidu.wff.base.fixedArea.domain.FixedArea;
import com.yidu.wff.util.IDGenerator;
@RequestMapping("/fixedArea")
@Controller
public class FixedAreaController {
	@Autowired
	private FixedAreaBiz fixedAreaBiz;
    @GetMapping("/fixedAreaes")
	public ModelAndView findAllFixedArea(ModelAndView modelAndView) {
    	modelAndView.addObject("list", (ArrayList<FixedArea>) fixedAreaBiz.findAllFixedArea())
    	.setViewName("/base/commons");
		return modelAndView;
	}
    @GetMapping("/addfixedArea")
   	public ModelAndView toAddFixedArea(@ModelAttribute("fixedArea") FixedArea fixedArea,ModelAndView modelAndView) {
    	modelAndView.setViewName("/base/addFix");
    	return modelAndView;
   	}
    @PostMapping("/fixedArea")
    public ModelAndView  addFixedArea(FixedArea fixedArea,ModelAndView modelAndView) {
    	System.out.println("11111111111111"+fixedArea);
    	fixedArea.setFixed_area_id(IDGenerator.getId());
    	fixedArea.setMaster_id(IDGenerator.getId());
    	System.out.println(fixedArea);
    	if (1==fixedAreaBiz.addFixedArea(fixedArea)) {
			System.out.println("添加成功");
		}
    	modelAndView.addObject("list", (ArrayList<FixedArea>) fixedAreaBiz.findAllFixedArea())
    	.setViewName("/base/commons");
    	return modelAndView;
    }
    @GetMapping("/toUpdateFixedArea")
    public ModelAndView  toUpdateFixedArea(@ModelAttribute("fixedArea") FixedArea fixedArea,String fixed_area_id,ModelAndView modelAndView) {
    	modelAndView.addObject("fixedArea", fixedAreaBiz.findFixedAreaById(fixed_area_id))
    	.setViewName("/base/updateFix");
    	return modelAndView;
    }
    @PutMapping(value = "/upfixedArea",produces="text/html;charest=utf-8")
    public String  updateFixedArea(FixedArea fixedArea) {
    	System.out.println(fixedArea);
  	if (1==fixedAreaBiz.updateFixedArea(fixedArea)) {
			System.out.println("修改成功");
		}
    	/*modelAndView.addObject("list",fixedAreaBiz.findAllFixedArea())
    	.setViewName("/base/commons");,ModelAndView modelAndView*/
    	
    	return "redirect:/fixedArea/fixedAreaes";
    }
    @DeleteMapping(value = "/fixedArea",produces="text/html;charest=utf-8")
    public String  deleteFixedArea(String fixed_area_id) {
    	System.out.println(fixed_area_id);
  	if (1==fixedAreaBiz.deleteFixedArea(fixed_area_id)) {
			System.out.println("shanchu成功");
		}
    	return "redirect:/fixedArea/fixedAreaes";
    }
    @GetMapping("/partFixedArea")
    public String  partFixedArea(String fixed_area_name,Model model) {
    	System.out.println(fixed_area_name);
    	model.addAttribute("list", fixedAreaBiz.findPartFixedArea(fixed_area_name));
    	System.out.println("chenggong");
    	return "/base/commons";
    }
}
