package com.nttdataestudos.service;

import com.nttdataestudos.dto.GameDTO;
import com.nttdataestudos.dto.GameMinDTO;
import com.nttdataestudos.dto.GameRequestDTO;
import com.nttdataestudos.entities.Game;
import com.nttdataestudos.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameDTO findAll(){
        var games = gameRepository.findAll();
        var list =  games.stream().map(GameMinDTO::new).toList();
        var content = new GameDTO();
        content.setContent(list);
        return content;
    }
    public Game findById(Long id){
        return gameRepository.findById(id).orElseThrow();
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
}
