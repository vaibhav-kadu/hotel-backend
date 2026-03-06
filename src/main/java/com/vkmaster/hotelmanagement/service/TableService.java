package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.TableDTO;
import com.vkmaster.hotelmanagement.entity.TableEntity;
import com.vkmaster.hotelmanagement.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private  final TableRepository tableRepository;

    public TableService(TableRepository tableRepository){
        this.tableRepository=tableRepository;
    }

    public TableEntity createTable(TableDTO dto){

        TableEntity table = new TableEntity();

        table.setTableNumber(dto.getTableNumber());
        table.setCapacity(dto.getCapacity());
        table.setStatus("AVAILABLE");

        return tableRepository.save(table);
    }

    public List<TableEntity> getAllTables(){
        return tableRepository.findAll();
    }

}
