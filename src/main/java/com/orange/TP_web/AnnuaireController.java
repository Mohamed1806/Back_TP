package com.orange.TP_web;


import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class AnnuaireController {

	@Autowired
	Annuaire ds;

	@GetMapping("/entree")
	@CrossOrigin(origins = "*")
	public Collection<Person> getAll() {
		return ds.getAll();
	}

	@PostMapping("/entree")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> add(@RequestBody Person newPerson) {
		if (ds.getFromId(newPerson.getId()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Personne déjà existante");
		}
		ds.addPerson(newPerson);
		// return ResponseEntity.status(HttpStatus.OK).body(ds.getFromId(id));
		return ResponseEntity.status(HttpStatus.CREATED).body("http://localhost:8080/entree/"+newPerson.getId());
	}
	
	
	
	@GetMapping("/entree/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> getOne(@PathVariable int id) {
		if (ds.getFromId(id) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de personne trouvée avec cet ID");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ds.getFromId(id));
	}

	@DeleteMapping("/entree/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> removeOne(@PathVariable int id) {
		if (ds.getFromId(id) == null) {
			return new ResponseEntity<>("Personne non trouvée", HttpStatus.NOT_FOUND);
		}
		ds.deleteFromId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("L'ID : "+ id +" est maintenant supprimé");
	}

	@PutMapping("/entree")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> remplace(@RequestBody Person updatedPerson) {
		if (ds.getFromId(updatedPerson.getId()) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Personne non trouvée");
		}
		ds.addPerson(updatedPerson);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("http://localhost:8080/entree/"+ updatedPerson.getId());
	}
}





//public class AnnuaireController {


//static AnnuaireService ds = new AnnuaireService();

/*@GetMapping("/annuaire")
public String recherche(Model model, @RequestParam (name="name", required=false,defaultValue="*") String name) {
	if (name.equals("*")) 
	model.addAttribute("entries", ds.getAll());
	else model.addAttribute("entries", ds.findByName(name));
	return "annuaire";
			}

@GetMapping("/annuaire/ajouter")
public String ajouterEntree() {
	return "/annuaire/ajouter";
}

@PostMapping("/annuaire/ajouter")

public String add(@RequestParam String name, @RequestParam String surname, @RequestParam String phone,
		@RequestParam String city) {

	// public String add(Person p) {
	Person p = new Person(12,name,surname,phone,city);
	ds.addPerson(p);
	return "redirect:/annuaire";
}

@GetMapping("/annuaire/supprimer/{id}")
public String supprime(Model model, @PathVariable int id) {
	ds.deleteFromId(id);
	model.addAttribute("entries", ds.getAll());
	return "redirect:/annuaire";
}

@GetMapping("/annuaire/modifier/{id}")
public String modifierEntree(Model model, @PathVariable int id) {
	model.addAttribute("entry", ds.getFromId(id));
	return "/modifier";
	}

@PostMapping("/annuaire/modifier/{id}")
public String modifierEntree(@PathVariable int id, @RequestParam String name, @RequestParam String surname,@RequestParam String phone, @RequestParam String city) {
Person p1 = new Person(id,name,surname,phone,city);
ds.addPerson(p1);
return "redirect:/annuaire";
}*/


