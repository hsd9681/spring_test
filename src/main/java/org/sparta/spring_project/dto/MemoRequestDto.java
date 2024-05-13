package org.sparta.spring_project.dto;

import lombok.Getter;
import org.sparta.spring_project.entitiy.Memo;

@Getter
public class MemoRequestDto {
    private String username;
    private String contents;


}