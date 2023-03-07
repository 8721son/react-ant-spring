package com.example.reactant.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reactant.dto.request.DiaryRequestDTO;
import com.example.reactant.dto.response.DiaryResponseDTO;
import com.example.reactant.entity.Diary;
import com.example.reactant.repository.DiaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {
    //쿼리문을 써야되면 repository
    //비즈니스로직 다 수행
    // 컨트롤러로 돌려줌
    private final DiaryRepository diaryRepository;

    public DiaryResponseDTO save(DiaryRequestDTO diaryRequestDTO){
        Diary diary = Diary.builder()
        .title(diaryRequestDTO.getTitle())
        .content(diaryRequestDTO.getContent())
        .date(diaryRequestDTO.getDate())
        .build();
        Diary savedDiary = diaryRepository.save(diary);
        return savedDiary.toDTO();
    }
}
