package com.nttdataestudos.controller;

import com.nttdataestudos.model.dto.GameListDTO;
import com.nttdataestudos.model.dto.GameListResponseDTO;
import com.nttdataestudos.service.GameListService;
import com.nttdataestudos.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameListControllerTest {

    @Mock
    private GameListService gameListService;

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameListController gameListController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<GameListDTO> gameListDTOList = new ArrayList<>();
        // ... add some test data to the gameListDTOList

        when(gameListService.findAll()).thenReturn(gameListDTOList);

        // Act
        List<GameListDTO> result = gameListController.findAll();

        // Assert
        assertEquals(gameListDTOList, result);
    }

    @Test
    void testFindByList() {
        // Arrange
        Long listId = 1L;
        GameListResponseDTO gameListResponseDTO = new GameListResponseDTO();
        // ... set up the gameListResponseDTO with test data

        when(gameService.findByList(listId)).thenReturn(gameListResponseDTO);

        // Act
        GameListResponseDTO result = gameListController.findByList(listId);

        // Assert
        assertNotNull(result);
    }
}
