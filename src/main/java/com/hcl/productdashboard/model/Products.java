package com.hcl.productdashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Products {
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private Long pid;
	@Column(name="name")
	private String name;
	@Column(name="description")

	private String description;
	@Column(name="url")

	private String url;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Products(Long pid, String name, String description, String url) {
		super();
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.url = url;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", name=" + name + ", description=" + description + ", url=" + url + "]";
	}
	
}
