package com.orange.TP_web;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnuaireService implements Annuaire{

@Autowired	
PersonRepository pr;

// Map<Integer, Person> tableau= new HashMap<Integer, Person>();

public AnnuaireService() {

//tableau.put(1, new Person("Doctor","0606060606",1,"Who","toto@hotmail.fr"));
//tableau.put(2, new Person("James","0606060606",2,"Bond","tata@hotmail.fr"));
//tableau.put(3, new Person("Emmanuel","0606060606",3,"Macron","titi@hotmail.fr"));
}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		//tableau.put(e.getId(), e);
		
		pr.save(p);
	}

	@Override
	public Collection <Person> findByName(String name) {
		// TODO Auto-generated method stub
		//return tableau.values().stream().filter( e -> e.getNom().equals(nom)).collect(Collectors.toList());
		return pr.findByName(name);
	}
	
	@Override
	public Person getFromId(int id) {
		
		return pr.findById(id);
	}

	@Override
	public Collection <Person> getAll() {
		// TODO Auto-generated method stub
		//return new ArrayList<Person>(tableau.values());
		return pr.findAll();
	}

	@Override
    public void deleteFromId(int id) {
        //if(tableau.remove(id) != null) return true;
        //return false;
		pr.deleteById(id);	
	}
	
	@Override
	public String toString() {
		return "AnnuaireService" + getAll() + "";
	}

}
