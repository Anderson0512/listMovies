package com.nttdataestudos.model.mapper;

import com.nttdataestudos.model.dto.GameListResponseDTO;
import com.nttdataestudos.model.dto.GameMinDTO;
import com.nttdataestudos.projections.GameMinProjection;

import java.util.ArrayList;
import java.util.List;

public class GameListResponseMapper {
    private final GameListResponseDTO responseDTO = new GameListResponseDTO();

    public GameListResponseMapper(List<GameMinProjection> gameList){

        List<GameMinDTO> minDTOList = new ArrayList<>();
        for (GameMinProjection projection : gameList){
            GameMinDTO minDTO = new GameMinDTO();
            minDTO.setId(projection.getId());
            minDTO.setTitle(projection.getTitle());
            minDTO.setYear(projection.getYear());
            minDTO.setImgUrl(projection.getImgUrl());
            minDTO.setShortDescription(projection.getShortDescription());
            minDTOList.add(minDTO);
        }
        responseDTO.setContent(minDTOList);
    }
    public GameListResponseDTO getResponseDTO() {
        return responseDTO;
    }
}
