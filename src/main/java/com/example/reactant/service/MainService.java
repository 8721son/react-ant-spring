package com.example.reactant.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reactant.dto.request.DiaryRequestDTO;
import com.example.reactant.dto.request.DiaryUpdateRequestDTO;
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

    public List<DiaryResponseDTO> getDiary(){
        List<Diary> list = diaryRepository.findAll();
        List<DiaryResponseDTO> dto = list.stream()
                                        .map(Diary::toDTO)
                                        .toList();
        return dto;
    }

    public DiaryResponseDTO getDiaryById(int id){
        Diary diary = diaryRepository.findById(id);
        return diary.toDTO();
    }

    @Transactional
    public DiaryResponseDTO update(int id, DiaryUpdateRequestDTO diaryUpdateRequestDTO){
        Diary diary = diaryRepository.findById(id);
        diary.setTitle(diaryUpdateRequestDTO.getTitle());
        diary.setContent(diaryUpdateRequestDTO.getContent());

        return diary.toDTO();
    }

    @Transactional
    public void delete(int id){
        diaryRepository.deleteById(id);
    }
}
