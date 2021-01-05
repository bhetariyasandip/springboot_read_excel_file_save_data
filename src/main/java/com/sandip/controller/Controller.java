package com.sandip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sandip.entity.User;
import com.sandip.service.UserService;

@RestController
public class Controller {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/uploadProfileImage")
	public List<User>  uploadProfileImage(@RequestParam("file") MultipartFile file) throws Exception {
		return userService.save(file.getInputStream());
	}
	
	
	
}
