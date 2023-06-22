package fr.fms.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	 @GetMapping("/index")
	 public String index(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="kw", defaultValue="") String keyword, @RequestParam(name="idCat", defaultValue="0") Long id ) {
		 Page<Task> tasks = taskRepository.findByNameContains(keyword, PageRequest.of(page, 4));
		 model.addAttribute("taskList", tasks.getContent());
		 model.addAttribute("pages", new int[tasks.getTotalPages()]);
		 model.addAttribute("currentPage", page);
		 model.addAttribute("keyword", keyword);
		 
		 return "main";
	 }
	 
	 @PostMapping("/save")
	 public String save(Model model, Task task) {
		return "main";
	 }
}
