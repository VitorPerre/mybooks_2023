package br.com.jlgregorio.mybooks.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Tag(name = "CategoryDTO", description = "Category Representation")
public class CategoryDTO {

    private int id;
    private String name;

}
