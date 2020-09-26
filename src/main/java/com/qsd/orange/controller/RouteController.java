package com.qsd.orange.controller;

import com.qsd.orange.po.SysUser;
import com.qsd.orange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Esion
 * @version 1.0
 * @created 2020年9月23日 下午6:51:13
 */
@Controller
public class RouteController {

	@Autowired
	private UserService userService;

	/**
	 * 用户信息显示
	 * */
	@GetMapping("")
	public String index(Model model, Authentication authentication) {
		User users = (User)authentication.getPrincipal();
		String username = users.getUsername();
		SysUser user = userService.getInfo(username);
		model.addAttribute("name", user.getName());
		model.addAttribute("type", user.getType());
		return "index";
	}

	/**
	 * 进行公告填充
	 * */
	@GetMapping("home")
	public String home() {
		return "home";
	}

}
