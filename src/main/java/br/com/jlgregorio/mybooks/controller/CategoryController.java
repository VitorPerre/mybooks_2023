package br.com.jlgregorio.mybooks.controller;
import br.com.jlgregorio.mybooks.dto.CategoryDTO;
import br.com.jlgregorio.mybooks.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
@Tag(name = "Categories", description = "Endpoint to manipulate categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Persists a new Category in database", tags = {"Categories"}, responses = {
            @ApiResponse( description = "Success!", responseCode = "200", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDTO.class))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = { @Content }),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = { @Content }),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = { @Content }),

    })
    public CategoryDTO create(@RequestBody CategoryDTO dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") int id){
        CategoryDTO dto = service.findById(id);
        //..HATEOAS
        buildSelfLink(dto);
        return dto;
    }

    @GetMapping
    public CollectionModel<CategoryDTO> findAll(){
        CollectionModel<CategoryDTO> categories = CollectionModel.of(service.findAll());
        for (CategoryDTO category : categories) {
            buildSelfLink(category);
        }
        buildCollectionLink(categories);
        return categories;
    }

    @PutMapping
    public CategoryDTO update(@RequestBody CategoryDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    //..build the self link, according to HATEOAS concept
    public void buildSelfLink(CategoryDTO dto){
        dto.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                                this.getClass()
                        ).findById(dto.getId())
                ).withSelfRel()
        );
    }

    public void buildCollectionLink(CollectionModel<CategoryDTO> categories){
        categories.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).findAll()
                ).withRel(IanaLinkRelations.COLLECTION)
        );
    }


}
