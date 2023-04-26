package br.com.jlgregorio.mybooks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDTO {

    private int id;

    private String title;

    private AuthorDTO author;

    private CategoryDTO category;


}
