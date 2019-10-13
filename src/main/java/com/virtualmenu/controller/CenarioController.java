package com.virtualmenu.controller;

import com.virtualmenu.DTO.CenarioDTO;
import com.virtualmenu.DTO.DashboardDTO;
import com.virtualmenu.DTO.ItemDTO;
import com.virtualmenu.mapper.CenarioMapper;
import com.virtualmenu.mapper.ItemMapper;
import com.virtualmenu.model.Cenario;
import com.virtualmenu.model.Item;
import com.virtualmenu.service.CenarioService;
import com.virtualmenu.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cenarios")
@RestController
public class CenarioController extends RESTController<Cenario, Long, CenarioDTO> {

    private static final CenarioMapper cenarioMapper = new CenarioMapper();
    private CenarioService cenarioService;

    public CenarioController(CenarioService cenarioService) {
        super(cenarioService, cenarioMapper);
        this.cenarioService = cenarioService;
    }

    @GetMapping("dashboard/")
    public ResponseEntity<DashboardDTO> getDashContent() {
        DashboardDTO dto = this.cenarioService.getDashContent();
        return ResponseEntity.ok(dto);
    }

}
