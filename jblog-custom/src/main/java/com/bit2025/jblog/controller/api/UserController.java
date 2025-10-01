package com.bit2025.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit2025.jblog.dto.JsonResult;
import com.bit2025.jblog.service.UserService;
import com.bit2025.jblog.vo.UserVo;

@RestController("ApiUserController")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/checkid")
	public JsonResult checkId(@RequestParam(value="id", required=true, defaultValue="")String id) {
		UserVo vo = userService.getUser(id);
		return JsonResult.success(vo != null);
	}
}
