package com.alcides.apptasks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.alcides.apptasks.core.AuditModel;

@Entity
@Table(name = "users")
public class User extends AuditModel{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "seq_users")
    @SequenceGenerator(
            name = "seq_users",
            sequenceName = "seq_users",
            initialValue = 1000
    )
    private Long id;
	
	@Size(min = 0, max = 100)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
