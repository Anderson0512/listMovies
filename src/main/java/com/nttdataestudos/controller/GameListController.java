package com.nttdataestudos.controller;

import com.nttdataestudos.model.dto.GameListDTO;
import com.nttdataestudos.model.dto.GameListResponseDTO;
import com.nttdataestudos.service.GameListService;
import com.nttdataestudos.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gamelist")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping()
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public GameListResponseDTO findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }
}
