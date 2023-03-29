package br.com.jlgregorio.mybooks.controller;

import br.com.jlgregorio.mybooks.dto.CategoryDTO;
import br.com.jlgregorio.mybooks.model.CategoryModel;
import br.com.jlgregorio.mybooks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping
    public List<CategoryDTO> findAll(){
        return service.findAll();
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


}
