package se.selimkose.personregistrymongodb.exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String personId){
        super("The person with student id: '" + personId + " does not exist in our records");
    }

}
