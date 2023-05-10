package com.nttdataestudos.controller;

import com.nttdataestudos.dto.GameDTO;
import com.nttdataestudos.dto.GameRequestDTO;
import com.nttdataestudos.entities.Game;
import com.nttdataestudos.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @GetMapping()
    public GameDTO findAll(){
        return gameService.findAll();
    }
    @GetMapping("/{id}")
    public Game findById(@PathVariable Long id) throws Exception {
        return gameService.findById(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Game crate(@RequestBody GameRequestDTO gameRequestDTO){
        return gameService.create(gameRequestDTO);
    }
}
