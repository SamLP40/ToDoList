package fr.fms.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Task;
import fr.fms.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}