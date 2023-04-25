package br.com.fiap.upperBank.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.upperBank.controller.ClienteController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cpf;

    
    @NotBlank
    private String nome;

    @NotNull
    private Calendar dataNascimento;

    @ManyToMany
    private List<Conta> contas;

    public EntityModel<Cliente> toEntityModel(){
        return EntityModel.of(
            this, 
            linkTo(methodOn(ClienteController.class).show(id)).withSelfRel(),
            linkTo(methodOn(ClienteController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(ClienteController.class).index(null, Pageable.unpaged())).withRel("all")
        );
    }
}   