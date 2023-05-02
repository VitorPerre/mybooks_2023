package br.com.jlgregorio.mybooks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorDTO extends RepresentationModel<AuthorDTO> {

    private int id;
    private String name;

    private String gender;

}
