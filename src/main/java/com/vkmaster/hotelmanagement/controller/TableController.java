package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.TableDTO;
import com.vkmaster.hotelmanagement.entity.TableEntity;
import com.vkmaster.hotelmanagement.service.TableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService){
        this.tableService=tableService;
    }

    @PostMapping
    public TableEntity createTable(@RequestBody TableDTO dto){
        return tableService.createTable(dto);
    }

    @GetMapping
    public List<TableEntity> getTables(){
        return tableService.getAllTables();
    }
}
