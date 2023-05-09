package com.nttdataEstudos.nttEstudos.controller;

import com.nttdataEstudos.nttEstudos.dto.GameMinDTO;
import com.nttdataEstudos.nttEstudos.entities.Game;
import com.nttdataEstudos.nttEstudos.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @GetMapping()
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }
}
