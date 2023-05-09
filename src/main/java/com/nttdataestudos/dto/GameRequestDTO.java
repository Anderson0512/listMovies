package com.nttdataestudos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRequestDTO {
    private String title;
    private String year;
    private String genre;
    private String platforms;
    private String score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;
}
