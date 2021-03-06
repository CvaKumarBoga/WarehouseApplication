package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.EmailUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private EmailUtil email;
	
	@RequestMapping("/reg")
	private String showPage(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,ModelMap map) {
		Integer id=service.saveUser(user);
		String message="User Register Succsfiully";
		map.addAttribute("user", new User());
		
		String text="Hello! " + user.getUserName()
		+ " , welcome to Warehouse App.. Your user name is: " + user.getUserEmail()
		+ " , Password is : " + user.getUserPwd()
		+ " , Your Roles are : " +user.getRoles();
		
		boolean flag=email.sendEmail(user.getUserEmail(),"Welcome to User APP!!",text);
		if(flag)
			message+=", Email also sent!!";
		else
			message+=", Email sending is failed!!";
		//email config end
		map.addAttribute("msg",message);
		return "UserRegister";
		
	}
	@RequestMapping("/all")
	public String getAllUsers(ModelMap map) {
		List<User> ob=service.getAllUsers();
		map.addAttribute("list",ob);
		return "UserData";
	}
	
	@RequestMapping("/delete")
	public String deleteUomType(@RequestParam Integer id,ModelMap map) {
		service.deleteUser(id);
		List<User> ob=service.getAllUsers();
		map.addAttribute("list", ob);
		String message="User '"+id+"' is succfully deleted";
		map.addAttribute("msg", message);
		return "UserData";
	}
	//show edit page
		@RequestMapping("/edit")
		public String showEdit(@RequestParam Integer id,ModelMap map) {
			User u=service.getUserById(id);
			map.addAttribute("User", u);
			return "UomTypeEdit";
		}
		//do update
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String doUpdate(@ModelAttribute User user,ModelMap map) {
			service.updateUser(user);
			List<User> ob=service.getAllUsers();
		//	String message="UouType '"+id+"' is updaated succesfull";
			map.addAttribute("list", ob);
			map.addAttribute("msg","UomType '"+user.getId()+"' is Updated");
			return "UserData";
		}
}
