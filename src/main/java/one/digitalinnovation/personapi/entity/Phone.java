package one.digitalinnovation.personapi.entity;

//evita que tenha que escrever os getters e os setters, além dos contrutores
import lombok.AllArgsConstructor;
import  lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Phone {

    @Id //definindo chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //próprio BD vai gerar os Ids de forma sequencial
    private Long id;

    @Enumerated(EnumType.STRING) //indicar que PhoneType é um enum
    @Column(nullable = false) //dado obrigatório
    private PhoneType type;

    @Column(nullable = false) //dado obrigatório
    private String number;
}
