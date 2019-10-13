package com.virtualmenu.service;

import com.virtualmenu.model.Cenario;
import com.virtualmenu.model.Item;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.CenarioRepository;
import com.virtualmenu.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenarioService extends GenericService<Cenario, Long> {

    private CenarioRepository cenarioRepository;

    @Autowired
    public CenarioService(
            BaseRepository<Cenario, Long> repository,
            CenarioRepository cenarioRepository
    ) {
        super(repository);
        this.cenarioRepository = cenarioRepository;
    }

}