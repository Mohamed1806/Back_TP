package com.orange.TP_web;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
		List<Person> findByName(String name);
		List<Person> findAll();
		Person findById(int id);
	}