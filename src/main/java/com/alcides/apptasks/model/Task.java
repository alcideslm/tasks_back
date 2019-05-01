package com.alcides.apptasks.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.alcides.apptasks.core.AuditModel;

@Entity
@Table(name = "tasks")
public class Task extends AuditModel{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "seq_tasks")
    @SequenceGenerator(
            name = "seq_tasks",
            sequenceName = "seq_tasks",
            initialValue = 1000
    )
    private Long id;
	
	@Size(min = 0, max = 100)
	private String titulo;
	
	@Size(min = 0, max = 10000)
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
