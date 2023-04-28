package se.selimkose.personregistrymongodb.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.selimkose.personregistrymongodb.entity.Person;
import se.selimkose.personregistrymongodb.service.PersonService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class PersonController {

    PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAllPersons(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        return new ResponseEntity<>(personService.findPersonById(id), HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String name) {
        return new ResponseEntity<>(personService.getPersonByName(name), HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Person> getPersonByAge(@PathVariable Integer age) {
        return new ResponseEntity<>(personService.getPersonByAge(age), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(id,person), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePersonById(@PathVariable Integer id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

