package org.sparta.spring_project.service;

import org.sparta.spring_project.dto.MemoRequestDto;
import org.sparta.spring_project.dto.MemoResponseDto;
import org.sparta.spring_project.entitiy.Memo;
import org.sparta.spring_project.repository.Memorepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MemoService {

    private final Memorepository memoRepository;



    public MemoService(JdbcTemplate jdbcTemplate) {
        this.memoRepository = new Memorepository(jdbcTemplate);
    }


    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // DB 저장

        Memo saveMemo =  memoRepository.save(memo);
        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {

        //db 조회

        return memoRepository.findAll();

        // DB 조회

    }

    public Long updateMemo(Long id,MemoRequestDto requestDto) {



        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id);
        if(memo != null) {
            // memo 내용 수정
            memoRepository.update(id, requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }


    public Long deleteService(Long id) {

        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id);
        if(memo != null) {

            memoRepository.delete(id);
            // memo 삭제
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }






}
