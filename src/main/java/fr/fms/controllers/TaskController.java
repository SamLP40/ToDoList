package fr.fms.controllers;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.TaskRepository;
import fr.fms.entities.Task;

/**
 * @author Le-porcherS
 * @Date 22-06-23
 * Contrôleur qui permet au service (Business) d'accéder aux méthodes d'ajout/suppression/modification d'une tâche
 * Il renvoie le contenu à l'utilisateur (connecté)
 */
@Controller
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	 /**
	  * Méthode qui permet d'afficher le contenu de la page web, et les fonctionnalités paramétrées.
	 * @param model
	 * @param page
	 * @param keyword
	 * @param id
	 * @return
	 */
	@GetMapping("/index")
	 public String index(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="keyword", defaultValue="") String keyword, 
			 						@RequestParam(name="idCat", defaultValue="0") Long id ) {
		 Page<Task> tasks = taskRepository.findByNameContains(keyword, PageRequest.of(page, 4));
		 model.addAttribute("taskList", tasks.getContent());
		 model.addAttribute("pages", new int[tasks.getTotalPages()]);
		 model.addAttribute("currentPage", page);
		 model.addAttribute("keyword", keyword);
		 
		 return "main";
	 }
	 
	 /**
	  * Méthode qui permet de rechercher une tâche par mot clé
	 * @param task
	 * @param model
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/save")
	 public String save(@Valid Task task, Model model, BindingResult bindingResult) {
		 
		 if(bindingResult.hasErrors()) {
			 model.addAttribute("category");
			 return "task";
		 }
		 taskRepository.save(task);
		return "redirect:/index";
	 }
	 
	 /** 
	  * Méthode qui permet, en cliquant sur un bouton, d'ouvrir un formulaire pour créer un article
	 * @param model
	 * @return
	 */
	@GetMapping("/create")
	 public String create(Model model) {
		 model.addAttribute("task", new Task());
		 return "task";
	 }
	 /**
	  * Méthode qui supprime un article de la base de données
	 * @param id
	 * @param page
	 * @param keyword
	 * @return
	 */
	@GetMapping("/delete")
	 public String delete(Long id, int page, String keyword) {
		 taskRepository.deleteById(id);
		 return "redirect:/index?page="+page+"&keyword"+keyword;
	 }
}

