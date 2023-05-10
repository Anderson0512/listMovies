package com.nttdataestudos.controller;

import com.nttdataestudos.dto.GameDTO;
import com.nttdataestudos.dto.GameListDTO;
import com.nttdataestudos.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gamelist")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping()
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }
}
