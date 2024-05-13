package org.sparta.spring_project.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.spring_project.dto.MemoRequestDto;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}