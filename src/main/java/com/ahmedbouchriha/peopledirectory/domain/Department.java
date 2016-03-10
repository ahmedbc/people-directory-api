package com.ahmedbouchriha.peopledirectory.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Department implements Serializable{

   
	private static final long serialVersionUID = -9213223295513438293L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false)
    private String name;
    

	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name="ref_company")
	private Company company;

    
    @OneToMany(mappedBy="department", cascade=CascadeType.REMOVE)
	private Set<Employee> employees = new HashSet<>();

   
    public Department() {
		super();
	}
    
    public Department(long id, String name) {
    	this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
		this.id = id;
	}
    
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
