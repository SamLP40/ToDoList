package fr.fms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.TaskRepository;
import fr.fms.entities.Task;

@Controller
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	 @GetMapping("/homepage")
	 public String home(Model model, @RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="kw", defaultValue="0") String keyword, @RequestParam(name="idCat", defaultValue="0") Long id ) {
		 List<Task> tasks = taskRepository.findAll();
		 model.addAttribute("taskList", tasks);
		 return "main";
	 }
	 
	 @PostMapping("/save")
	 public String save(Model model, Task task) {
		return "main";
	 }
}
