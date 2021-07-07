package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) { //essa anotação serve para avisar que o post será feito por uma requisição http
        return personService.createPerson(personDTO);
    }

    //chamando uma lista com todas as pessoas
    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}") //para nao dar conflito com o outro GET, esse pega uma pessoa específica
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

}
