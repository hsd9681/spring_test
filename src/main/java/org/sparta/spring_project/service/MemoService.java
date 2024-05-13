package org.sparta.spring_project.service;

import org.sparta.spring_project.dto.MemoRequestDto;
import org.sparta.spring_project.dto.MemoResponseDto;
import org.sparta.spring_project.entitiy.Memo;
import org.sparta.spring_project.repository.Memorepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    private final Memorepository memoRepository;

//생성자가 1개 이면 오토와이어 생략가능
    public MemoService(Memorepository memoRepository) {
        //1. bean 이름으로 가져오기
        //Memorepository memoRepository = (Memorepository) context.getBean("memorepository");

        //2. bean 클래스 형식으로 가져오기
        //Memorepository memoRepository = context.getBean(Memorepository.class);
        this.memoRepository = memoRepository;
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
