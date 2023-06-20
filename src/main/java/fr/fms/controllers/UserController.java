package fr.fms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.fms.dao.CategoryRepository;

@Controller
public class UserController {

	@Autowired
	CategoryRepository categoryRepository;
}
