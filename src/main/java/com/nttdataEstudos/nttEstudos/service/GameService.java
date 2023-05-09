package com.nttdataEstudos.nttEstudos.service;

import com.nttdataEstudos.nttEstudos.dto.GameMinDTO;
import com.nttdataEstudos.nttEstudos.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        var games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
