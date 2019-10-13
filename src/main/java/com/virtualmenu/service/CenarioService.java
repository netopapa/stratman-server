package com.virtualmenu.service;

import com.virtualmenu.DTO.ChartDTO;
import com.virtualmenu.DTO.DashboardDTO;
import com.virtualmenu.model.Cenario;
import com.virtualmenu.model.Item;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.CenarioRepository;
import com.virtualmenu.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CenarioService extends GenericService<Cenario, Long> {

    private CenarioRepository cenarioRepository;

    private ItemService itemService;

    @Autowired
    public CenarioService(
            BaseRepository<Cenario, Long> repository,
            ItemService itemService,
            CenarioRepository cenarioRepository
    ) {
        super(repository);
        this.cenarioRepository = cenarioRepository;
        this.itemService = itemService;
    }

    private ChartDTO getChartByCenario(Cenario cenario) {
        List<Item> items = itemService.getByCenarioId(cenario.getId());

        if (items.size() < 1) {
            return null;
        }

        ChartDTO chart = new ChartDTO();

        chart.setLabels(items.stream().map(Item::getName).collect(Collectors.toList()));
        chart.setSeries(items.stream().map(Item::getValue).collect(Collectors.toList()));

        return chart;
    }

    public DashboardDTO getDashContent() {
        List<Cenario> cenarios = cenarioRepository.findAll();

        if (cenarios.size() < 1) {
            return null;
        }

        DashboardDTO dto = new DashboardDTO();
        List<ChartDTO> charts = cenarios.stream().map(cenario -> this.getChartByCenario(cenario)).collect(Collectors.toList());
        dto.setCurrentCenario(this.getChartByCenario(cenarios.get(0)));
        dto.setHistoric(charts.subList(1, charts.size()));

        return dto;
    }

}