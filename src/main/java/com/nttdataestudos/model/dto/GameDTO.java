package com.nttdataestudos.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
public class GameDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_pageable")
    private SimplePageable pageable = new SimplePageable();

    @JsonProperty("_content")
    private List<GameMinDTO> content;
}
