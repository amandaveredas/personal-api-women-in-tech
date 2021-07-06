package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController //
@RequestMapping("/api/v1/people") //caminho de acesso principal da API
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//forçando a me retornar o código 201 quando for criado um usuário
    public MessageResponseDTO createPerson(@RequestBody Person person) { //essa anotação serve para avisar que o post será feito por uma requisição http
        return personService.createPerson(person);
    }


}
