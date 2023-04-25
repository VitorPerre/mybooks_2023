package br.com.jlgregorio.mybooks.service;

import br.com.jlgregorio.mybooks.dto.AuthorDTO;
import br.com.jlgregorio.mybooks.exception.ResourceNotFoundException;
import br.com.jlgregorio.mybooks.mapper.CustomModelMapper;
import br.com.jlgregorio.mybooks.model.AuthorModel;
import br.com.jlgregorio.mybooks.model.CategoryModel;
import br.com.jlgregorio.mybooks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public AuthorDTO findById(int id){
        AuthorModel model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado!"));
        return CustomModelMapper.parseObject(model, AuthorDTO.class);
    }

    public List<AuthorDTO> findAll(){
        return CustomModelMapper.parseObjectList(repository.findAll(), AuthorDTO.class);
    }

    public AuthorDTO create(AuthorDTO dto){
        AuthorModel model = CustomModelMapper.parseObject(dto, AuthorModel.class);
        return CustomModelMapper.parseObject(repository.save(model), AuthorDTO.class);
    }

    public AuthorDTO update(AuthorDTO dto){
        var authorFound = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Não encontrado!"));
        var updated = CustomModelMapper.parseObject(dto, AuthorModel.class);
        return CustomModelMapper.parseObject(repository.save(updated), AuthorDTO.class);
    }

    public void delete(int id){
        var authorFound = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado!"));
        repository.delete(authorFound);
    }





}
