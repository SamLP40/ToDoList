package fr.fms.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Le-porcherS
 * @Date 22-06-2023
 *   Table Task (BDD) : la date doit correspondre à une tâche future, et les attributs doivent être constitués 
 *   d'au moins 1 caractère.

 */
@Entity
@NoArgsConstructor @AllArgsConstructor @Data @ToString
public class Task implements Serializable {

	private static final long serialVersionUID= 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy") @Future
	public Date dateTask;
	@NotNull
	private String description;
	@NotBlank
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
}
