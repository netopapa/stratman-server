package com.virtualmenu.service;

import com.virtualmenu.exception.NotFoundException;
import com.virtualmenu.model.BaseModel;
import com.virtualmenu.repository.BaseRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class GenericService<T extends BaseModel, I extends Serializable> {

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PRIVATE)
    private BaseRepository<T, I> repository;

    @PersistenceContext
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PRIVATE)
    private EntityManager entityManager;

    public GenericService(BaseRepository<T, I> repository) {
        this.repository = repository;
    }

    public T saveOrUpdate(T entity) {
        return repository.save(entity);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public Optional<T> get(I id) {
        return repository.findById(id);
    }

    public T getNotNull(I id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Item não encontrado!"));
    }

    public T add(T entity) {
        return this.saveOrUpdate(entity);
    }

    public T update(T entity) {
        return this.saveOrUpdate(entity);
    }

    public T saveAndFlush(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Transactional
    public void flushRefresh(T entity) {
        entityManager.flush();
        entityManager.refresh(entity);
    }

    public void remove(T entity) {
        repository.delete(entity);
    }

    public void removeById(I id) {
        repository.deleteById(id);
    }

    public boolean exists(I id) {
        return repository.existsById(id);
    }
}
