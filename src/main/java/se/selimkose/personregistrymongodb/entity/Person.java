package se.selimkose.personregistrymongodb.entity;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "person")
@Data
public class Person {
    @Id
    String id;
    @NotBlank
    @NonNull
    @NotEmpty
    String firstName;
    @NotBlank
    @NonNull
    @NotEmpty
    String lastName;
    @Max(120)
    @Min(1)
    String age;
}
