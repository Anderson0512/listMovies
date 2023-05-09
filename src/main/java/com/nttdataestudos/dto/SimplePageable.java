package com.nttdataestudos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class SimplePageable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_moreElements")
    private Boolean moreElements;

    public SimplePageable() {
        this.moreElements = Boolean.FALSE;
    }

    public Boolean isMoreElements() {
        return this.moreElements;
    }

    public void setMoreElements(Boolean moreElements) {
        this.moreElements = moreElements;
    }
}
