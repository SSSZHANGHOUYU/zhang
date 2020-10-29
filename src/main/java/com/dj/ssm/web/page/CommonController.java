package com.dj.ssm.web.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/toIndex")
	public String toIndex()
	{
		return "/common/index";
	}
	
	@RequestMapping("toMenu")
	public String toMenu()
	{
		return "/common/menu";
	}
	
	@RequestMapping("toTop")
	public String toTop()
	{
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/common/top";
	}
	
	@RequestMapping("toMain")
	public String toMain()
	{
		return "/common/main";
	}
}
