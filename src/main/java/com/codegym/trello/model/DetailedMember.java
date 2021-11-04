package com.codegym.trello.model;

public interface DetailedMember {
    Long getId();
    boolean getCanEdit();
    Long getBoardId();
    Long getUserId();
    String getUsername();
    String getNickname();
    String getImage();
}
