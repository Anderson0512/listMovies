package com.nttdataestudos.service;

import com.nttdataestudos.model.dto.GameListDTO;
import com.nttdataestudos.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;


    @Autowired
    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        var games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }
}
