package com.orange.TP_web;

import java.util.Collection;

public interface Annuaire {

	public void addPerson (Person p);
	public Collection <Person> findByName (String name);
	public Collection <Person> getAll ();
	public void deleteFromId(int id);
	public Person getFromId(int id);
	
}
