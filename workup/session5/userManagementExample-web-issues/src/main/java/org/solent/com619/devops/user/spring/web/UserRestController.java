package org.solent.com619.devops.user.spring.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com619.devops.user.dao.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.solent.com619.devops.user.model.dto.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class UserRestController {
	
    final static Logger LOG = LogManager.getLogger(UserRestController.class);

    @Autowired
    UserRepository userRepository;

    @Operation(summary = "Get a list of users")
    @RequestMapping("/getUsers")
    public Iterable<User> list() {
        return userRepository.findAll();
    }
    

}
