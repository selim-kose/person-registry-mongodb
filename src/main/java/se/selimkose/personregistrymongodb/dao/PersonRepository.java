package se.selimkose.personregistrymongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.selimkose.personregistrymongodb.entity.Person;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    Optional<Person> findByFirstName(String name);
    void deleteById(Integer id);
    Person getPersonByAge(Integer age);
}
