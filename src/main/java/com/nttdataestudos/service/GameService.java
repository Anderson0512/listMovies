package com.nttdataestudos.service;

import com.nttdataestudos.model.dto.GameDTO;
import com.nttdataestudos.model.dto.GameListResponseDTO;
import com.nttdataestudos.model.dto.GameMinDTO;
import com.nttdataestudos.model.dto.GameRequestDTO;
import com.nttdataestudos.entities.Game;
import com.nttdataestudos.model.mapper.GameListResponseMapper;
import com.nttdataestudos.projections.GameMinProjection;
import com.nttdataestudos.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public GameDTO findAll(){
        var games = gameRepository.findAll();
        var list =  games.stream().map(GameMinDTO::new).toList();
        var content = new GameDTO();
        content.setContent(list);
        return content;
    }

    @Transactional(readOnly = true)
    public Game findById(Long id) throws Exception {
        return gameRepository.findById(id).orElseThrow(() -> new Exception("Id informado não existe"));
    }

    public Game create(GameRequestDTO game){
        var newGame = new Game();
        newGame.setTitle(game.getTitle());
        newGame.setYear(Integer.valueOf(game.getYear()));
        newGame.setGenre(game.getGenre());
        newGame.setPlatforms(game.getPlatforms());
        newGame.setScore(Double.valueOf(game.getScore()));
        newGame.setImgUrl(game.getImgUrl());
        newGame.setShortDescription(game.getShortDescription());
        newGame.setLongDescription(game.getLongDescription());
        return gameRepository.save(newGame);
    }

    @Transactional(readOnly = true)
    public GameListResponseDTO findByList(Long listId){
        List<GameMinProjection> gameList = gameRepository.searchByList(listId);
        return new GameListResponseMapper(gameList).getResponseDTO();
    }
}
