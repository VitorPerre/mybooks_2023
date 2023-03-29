package br.com.jlgregorio.mybooks.service;

import br.com.jlgregorio.mybooks.exception.ResourceNotFoundException;
import br.com.jlgregorio.mybooks.model.CategoryModel;
import br.com.jlgregorio.mybooks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryModel create(CategoryModel model){
        return repository.save(model);
    }

    public CategoryModel findById(int id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
    }

    public List<CategoryModel> findAll(){
        return repository.findAll();
    }

    public CategoryModel update(CategoryModel model){
        var categoryFound = repository.findById(model.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado!"));
        categoryFound.setName(model.getName());
        return repository.save(categoryFound);
    }

    public void delete(int id){
        var categoryFound = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado!"));
        repository.delete(categoryFound);
    }


}
