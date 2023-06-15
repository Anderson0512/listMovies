package com.nttdataestudos.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class GameListResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_pageable")
    private SimplePageable pageable = new SimplePageable();

    @JsonProperty("_content")
    private transient List<GameMinDTO> content;
}
