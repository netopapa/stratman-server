package com.virtualmenu.controller;

import com.virtualmenu.mapper.GenericMapper;
import com.virtualmenu.model.BaseModel;
import com.virtualmenu.service.GenericService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public abstract class RESTController<E extends BaseModel, ID extends Serializable, D> {
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private Logger logger;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private GenericService<E, ID> service;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private GenericMapper<E, D> mapper;

    public RESTController(GenericService<E, ID> service, GenericMapper<E, D> mapper) {
        setService(service);
        setMapper(mapper);
        setLogger(LoggerFactory.getLogger(getClass()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<D> findById(@PathVariable ID id) {
        E resource = service.getNotNull(id);
        return ResponseEntity.ok().body(mapper.convertToDTO(resource));
    }

    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        List<D> all = mapper.convertToListDTO(service.getAll());
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody D dto) {
        E entity = mapper.convertToEntity(dto);
        entity = service.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.convertToDTO(entity));
    }

    @PutMapping
    public ResponseEntity<D> update(@Valid @RequestBody D dto) {
        E entity = mapper.convertToEntity(dto);
        entity = service.update(entity);
        return ResponseEntity.ok(mapper.convertToDTO(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable ID id) {
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }
}
