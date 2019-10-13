package com.virtualmenu.controller;

import com.virtualmenu.DTO.CenarioDTO;
import com.virtualmenu.DTO.DashboardDTO;
import com.virtualmenu.mapper.CenarioMapper;
import com.virtualmenu.model.Cenario;
import com.virtualmenu.service.CenarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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

    @GetMapping("periodo/{period}")
    public ResponseEntity<CenarioDTO> getByPeriodo(@PathVariable String period) {
        Cenario model = this.cenarioService.getByPeriod(LocalDate.parse(period));
        return ResponseEntity.ok(cenarioMapper.convertToDTO(model));
    }

}
