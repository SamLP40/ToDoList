package fr.fms;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Task;

@SpringBootApplication
public class ToDoListAppApplication implements CommandLineRunner {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoListAppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Task> tasks = taskRepository.findAll();
		for(Task task : tasks) {
		}
//		taskRepository.save(new Task(null, "Pause", new Date(20-6-2023), "Pour se reposer", "Fini", null));
//		taskRepository.save(new Task(null, "Entities", new Date(20-6-2023), "Créer les entités", "Fini", null));
//		taskRepository.save(new Task(null, "Pagination", new Date(20-6-2023), "Mettre en place la pagination", "A faire", null));
//		taskRepository.save(new Task(null, "Connexion BDD", new Date(20-6-2023), "Connecter la BDD", "En cours", null));
//		taskRepository.save(new Task(null, "Tests unitaires", new Date(21-6-2023), "Tester l'appli", "A faire", null));
//		taskRepository.save(new Task(null, "Activer Spring security", new Date(22-6-2023), "Mettre en place Spring security pour sécuriser l'appli", "Bloqué", null));
//		taskRepository.save(new Task(null, "Formation JSA", new Date(22-12-2023), "Mise à niveau programmation", "En cours", null));
//		taskRepository.save(new Task(null, "Passer à l'hôpital", new Date(20-6-2023), "Rendre visite à mamie", "Fini", null));
//		taskRepository.save(new Task(null, "Nourrir le chat", new Date(30-6-2023), "Pour éviter qu'il miaule tout le temps...", "A faire", null));
//		taskRepository.save(new Task(null, "Laver la chemise", new Date(24-6-2023), "Car il y a une tâche dessus", "A faire", null));
//		taskRepository.save(new Task(null, "Anglais", new Date(25-9-2023), "Reprendre la présentation + s'entraîner à l'oral", "En cours", null));
//		taskRepository.save(new Task(null, "Examen à présenter", new Date(22-6-2023), "A présenter de A à Z, rendre le dossier qui va avec", "En cours", null));
//		taskRepository.save(new Task(null, "Push sur git", new Date(22-06-2023), "Sauvegarder le projet", "En cours", null));
	}
}
