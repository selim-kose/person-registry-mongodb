package se.selimkose.personregistrymongodb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import se.selimkose.personregistrymongodb.dao.PersonRepository;
import se.selimkose.personregistrymongodb.entity.Person;
import se.selimkose.personregistrymongodb.exception.PersonNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {

    PersonRepository personRepository;

    public List<Person> findAllPersons() {
        return (List<Person>) personRepository.findAll();
    }
    public Person addPerson(Person person) {
        var id = UUID.randomUUID().toString();
        Person personToAdd = person;
        personToAdd.setId(id);
        return personRepository.save(personToAdd);
    }
    public Person findPersonById(String id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> new PersonNotFoundException(id));
    }
    public Person getPersonByName(String name) {
        Optional<Person> person = personRepository.findByFirstName(name);
        return person.orElseThrow(() -> new NullPointerException());
    }
    public Person updatePerson(String id, Person newPerson) {
        Optional<Person> previousPerson = personRepository.findById(id);

        if(previousPerson.isPresent()) {
          Person previousPersonUnwrapped = previousPerson.get();
          previousPersonUnwrapped.setFirstName(newPerson.getFirstName());
          previousPersonUnwrapped.setLastName(newPerson.getLastName());
          previousPersonUnwrapped.setAge(newPerson.getAge());

          return personRepository.save(previousPersonUnwrapped);
        }
        return null;
    }

    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }


    public Person getPersonByAge(Integer age) {
        return personRepository.getPersonByAge(age);
    }
}
