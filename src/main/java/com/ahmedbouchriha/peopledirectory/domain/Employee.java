package com.ahmedbouchriha.peopledirectory.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee implements Serializable{

    
	private static final long serialVersionUID = -7167728272321117135L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "email", nullable = false)
    private String email;
    
    @NotNull
    @Size(max = 25)
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "location", nullable = false)
    private String location;
    
    @NotNull
    @Size(max = 64)
    @Column(name = "title", nullable = false)
    private String title;
    
    @Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
    
    @ManyToOne(fetch = FetchType.LAZY,  cascade={CascadeType.MERGE})
	@JoinColumn(name="ref_department")
	private Department department;

    
    public Employee() {
		super();
	}

    public Employee(String name, String email, String phone, String location, String title, Date startDate, Date endDate) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@JsonIgnore
	public Department getdepartment() {
		return department;
	}

	public void setdepartment(Department department) {
		this.department = department;
	}

	public long getId() {
		return id;
	}
}
