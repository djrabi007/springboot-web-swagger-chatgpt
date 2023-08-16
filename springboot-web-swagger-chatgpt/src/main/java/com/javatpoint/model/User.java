package com.javatpoint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User 
{  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
String name;  
String email;  
public String getName() 
{  
return name;  
}  
public void setName(String name) 
{  
this.name = name;  
}  
public String getEmail() 
{  
return email;  
}  
public void setEmail(String email) 
{  
this.email = email;  
}  
}  