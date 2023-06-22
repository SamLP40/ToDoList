package fr.fms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Task;

@Repository 
public interface TaskRepository extends JpaRepository<Task, Long> {
	Page<Task> findByNameContains(String keyword, Pageable pageable);
//	Page<Task> findByCategoryId(Long idCat, Pageable pageable);
	
}