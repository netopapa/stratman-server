package com.virtualmenu.controller;

import com.virtualmenu.DTO.CookingRequestDTO;
import com.virtualmenu.mapper.CookingRequestMapper;
import com.virtualmenu.model.CookingRequest;
import com.virtualmenu.service.CookingRequestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cooking-requests")
@RestController
public class CookingRequestController extends RESTController<CookingRequest, Long, CookingRequestDTO> {

    private static final CookingRequestMapper cookingRequestMapper = new CookingRequestMapper();
    private CookingRequestService cookingRequestService;

    public CookingRequestController(CookingRequestService cookingRequestService) {
        super(cookingRequestService, cookingRequestMapper);
        this.cookingRequestService = cookingRequestService;
    }

}
