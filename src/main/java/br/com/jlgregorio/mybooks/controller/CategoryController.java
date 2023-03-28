package br.com.jlgregorio.mybooks.controller;

import br.com.jlgregorio.mybooks.model.CategoryModel;
import br.com.jlgregorio.mybooks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public CategoryModel create(@RequestBody CategoryModel model){
        return service.create(model);
    }

    @GetMapping("/{id}")
    public CategoryModel findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping
    public List<CategoryModel> findAll(){
        return service.findAll();
    }

}
