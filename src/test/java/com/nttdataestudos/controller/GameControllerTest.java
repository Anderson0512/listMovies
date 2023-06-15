package com.nttdataestudos.controller;

import com.nttdataestudos.entities.Game;
import com.nttdataestudos.model.dto.GameDTO;
import com.nttdataestudos.model.dto.GameRequestDTO;
import com.nttdataestudos.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameControllerTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        GameDTO gameDTO = new GameDTO();
        // ... set up the gameDTO with test data

        when(gameService.findAll()).thenReturn(gameDTO);

        // Act
        GameDTO result = gameController.findAll();

        // Assert
        assertEquals(gameDTO, result);
    }

    @Test
    void testFindById() throws Exception {
        // Arrange
        Long gameId = 1L;
        Game game = new Game();
        // ... set up the game with test data

        when(gameService.findById(gameId)).thenReturn(game);

        // Act
        Game result = gameController.findById(gameId);

        // Assert
        assertEquals(game, result);
    }

    @Test
    void testCreate() {
        // Arrange
        GameRequestDTO gameRequestDTO = new GameRequestDTO();
        // ... set up the gameRequestDTO with test data

        Game createdGame = new Game();
        // ... set up the createdGame with test data

        when(gameService.create(gameRequestDTO)).thenReturn(createdGame);

        // Act
        Game result = gameController.create(gameRequestDTO);

        // Assert
        assertEquals(createdGame, result);
    }

    @Test
    void testGetById() {
        // Arrange
        ResponseEntity<Void> expectedResponseEntity = ResponseEntity.ok().build();

        // Act
        CompletableFuture<ResponseEntity<Void>> result = gameController.getById();

        // Assert
        assertEquals(expectedResponseEntity, result.join());
    }
}
