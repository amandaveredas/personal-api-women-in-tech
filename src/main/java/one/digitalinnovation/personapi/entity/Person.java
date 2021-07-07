package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data //getters e setters
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) //CPF único, não aceita duplicata
    private String cpf;

    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String city;

    private String professionalExperience;

    private String academicFormation;

    private String skills;

    //estratégia de inserção com  cascade
    //perfomance de busca com fectch
    @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}) //uma pessoa pode ter vários telefones
    private List<Phone> phones;
}
