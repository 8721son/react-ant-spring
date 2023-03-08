package com.example.reactant.controller;

import com.example.reactant.dto.request.DiaryRequestDTO;
import com.example.reactant.dto.request.DiaryUpdateRequestDTO;
import com.example.reactant.dto.response.DiaryResponseDTO;
import com.example.reactant.dto.response.ResponseDTO;
import com.example.reactant.dto.response.ResponseEnum;
import com.example.reactant.entity.Diary;
import com.example.reactant.service.MainService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping("/save")
    public HttpEntity<ResponseDTO> save(@RequestBody DiaryRequestDTO diaryRequestDTO){
        DiaryResponseDTO dto = mainService.save(diaryRequestDTO);

        return new ResponseEntity<>
            (new ResponseDTO
                (ResponseEnum.SAVE_SUCCESS, dto),HttpStatus.OK);
    } 

    @GetMapping("/")
    public HttpEntity<ResponseDTO> getDiary(){
        List<DiaryResponseDTO> dto = mainService.getDiary();

        return new ResponseEntity<>
            (new ResponseDTO
                (ResponseEnum.SELECT_SUCCESS, dto),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<ResponseDTO> getDiaryById(@PathVariable int id){
        DiaryResponseDTO dto = mainService.getDiaryById(id);

        return new ResponseEntity<>
            (new ResponseDTO
                (ResponseEnum.SELECT_SUCCESS, dto),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<ResponseDTO> updateDiary(@PathVariable int id,
                                            @RequestBody DiaryUpdateRequestDTO diaryUpdateRequestDTO){
        
        DiaryResponseDTO dto = mainService.update(id, diaryUpdateRequestDTO);
        return new ResponseEntity<>
            (new ResponseDTO
                (ResponseEnum.UPDATE_SUCCESS, dto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<ResponseDTO> deleteDiary(@PathVariable int id){
        mainService.delete(id);
        return new ResponseEntity<>
            (new ResponseDTO
                (ResponseEnum.DELETE_SUCCESS, null),HttpStatus.OK);
    }
}
