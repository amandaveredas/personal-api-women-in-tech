package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //extendo essa interface ele já faz toda a parte de conexão com banco de dados


}
