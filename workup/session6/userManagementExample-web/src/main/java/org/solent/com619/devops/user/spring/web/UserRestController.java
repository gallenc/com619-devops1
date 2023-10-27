package org.solent.com619.devops.user.spring.web;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com619.devops.user.dao.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;

import org.solent.com619.devops.user.model.dto.User;
import org.solent.com619.devops.user.model.dto.UserRole;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class UserRestController {

	final static Logger LOG = LogManager.getLogger(UserRestController.class);

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserAuthoriserService userAuthorisedService;

	@Operation(summary = "Get a list of all users")

	@RequestMapping("/getUserList")
	public Iterable<User> listUsers(HttpServletRequest httpRequest) {
		
		if (UserRole.ADMINISTRATOR != userAuthorisedService.authorisedUserRole(httpRequest)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "unauthorised request");
		};
		

		return userRepository.findAll();
	}
	
	
	@Operation(summary = "Get particular user details")
	@RequestMapping("/getUser")
	public User findUser(@RequestParam String username, HttpServletRequest httpRequest) {
		
		if (UserRole.ADMINISTRATOR != userAuthorisedService.authorisedUserRole(httpRequest)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "unauthorised request");
		};
		

		List<User> users = userRepository.findByUsername(username);
		if (users.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unknown username "+username);
		
		return users.get(0);
		
	}

	

}
