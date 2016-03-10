package com.ahmedbouchriha.peopledirectory.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Company implements Serializable{


	private static final long serialVersionUID = 3972960616368591759L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(mappedBy="company", cascade=CascadeType.REMOVE)
	private Set<Department> departments = new HashSet<>(); 

    public Company() {
    	super();
	}

	public Company(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }        

    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public Set<Department> getdepartments() {
		return departments;
	}

	public void setdepartments(Set<Department> departments) {
		departments = departments;
	}

	public void setId(long id) {
		this.id = id;
	}
}
