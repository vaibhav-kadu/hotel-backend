package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.MenuItemDTO;
import com.vkmaster.hotelmanagement.entity.MenuItemEntity;
import com.vkmaster.hotelmanagement.service.MenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService=menuService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public MenuItemEntity createMenuItem(@RequestBody MenuItemDTO dto){

        return menuService.createMenuItem(dto);
    }

    @GetMapping
    public List<MenuItemEntity> getMenu(){
        return menuService.getMenu();
    }
}
