package com.example.reactant.controller;

import com.example.reactant.dto.request.DiaryRequestDTO;
import com.example.reactant.dto.response.DiaryResponseDTO;
import com.example.reactant.dto.response.ResponseDTO;
import com.example.reactant.dto.response.ResponseEnum;
import com.example.reactant.entity.Diary;
import com.example.reactant.service.MainService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
