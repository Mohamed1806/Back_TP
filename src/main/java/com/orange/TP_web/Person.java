package com.orange.TP_web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Person {
@Id 
@GeneratedValue
int id;
private String name;
private String phone;
//private int id;

private String surname;
private String city;

public Person() {
};

public Person(int id, String name, String surname, String phone, String city) {
	super();
	this.name = name;
	this.phone = phone;
	this.id = id;
	this.surname = surname;
	this.city = city;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getSurname() {
	return surname;
}


public void setSurname(String surname) {
	this.surname = surname;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


@Override
public String toString() {
	return " Prenom=" + name + ", tel=" + phone + ", Id=" + getId() + ", Nom=" + getSurname()+ ", Ville=" + getCity() + "]";
		}
		
	}

