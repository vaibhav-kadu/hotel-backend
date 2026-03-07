package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.MenuItemDTO;
import com.vkmaster.hotelmanagement.entity.MenuItem;
import com.vkmaster.hotelmanagement.repository.MenuRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class MenuService {

    private  final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository=menuRepository;
    }

    public MenuItem createMenuItem(MenuItemDTO dto){

        MenuItem item = new MenuItem();

        item.setName(dto.getName());
        item.setCategory(dto.getCategory());
        item.setPrice(dto.getPrice());
        item.setAvailable(true);

        return menuRepository.save(item);
    }

    public List<MenuItem> getMenu(){
        return  menuRepository.findAll();
    }
}
