package com.nttdataestudos.controller;

import com.nttdataestudos.model.dto.GameDTO;
import com.nttdataestudos.model.dto.GameRequestDTO;
import com.nttdataestudos.entities.Game;
import com.nttdataestudos.service.GameService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/games")
@RateLimiter(name = "config_tps_limiter")
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
    public Game create(@RequestBody GameRequestDTO gameRequestDTO){
        return gameService.create(gameRequestDTO);
    }

    @TimeLimiter(name = "time_limit")
    public CompletableFuture<ResponseEntity<Void>> getById() {

        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok().build());
    }
}
