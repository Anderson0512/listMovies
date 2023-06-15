package com.nttdataestudos.model.mapper;

import com.nttdataestudos.model.dto.GameListResponseDTO;
import com.nttdataestudos.model.dto.GameMinDTO;
import com.nttdataestudos.projections.GameMinProjection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GameListResponseMapperTest {

    @Test
    void testGameListResponseMapper() {
        // Arrange
        List<GameMinProjection> gameList = new ArrayList<>();
        // ... set up gameList with test data

        // Create a sample GameMinProjection object for testing
        GameMinProjection projection = new GameMinProjection() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getTitle() {
                return "Sample Game";
            }

            @Override
            public Integer getYear() {
                return 2021;
            }

            @Override
            public String getImgUrl() {
                return "https://example.com/image.jpg";
            }

            @Override
            public String getShortDescription() {
                return "This is a sample game.";
            }

            @Override
            public Integer getPosition() {
                return 0;
            }
        };

        gameList.add(projection);

        // Create the expected GameMinDTO object for comparison
        GameMinDTO expectedMinDTO = new GameMinDTO();
        expectedMinDTO.setId(1L);
        expectedMinDTO.setTitle("Sample Game");
        expectedMinDTO.setYear(2021);
        expectedMinDTO.setImgUrl("https://example.com/image.jpg");
        expectedMinDTO.setShortDescription("This is a sample game.");

        // Act
        GameListResponseMapper responseMapper = new GameListResponseMapper(gameList);
        GameListResponseDTO responseDTO = responseMapper.getResponseDTO();

        // Assert
        assertEquals(1, responseDTO.getContent().size());
        for (GameMinDTO gm : responseDTO.getContent()){
            assertEquals(gm, responseDTO.getContent().get(0));
        }
    }
}
