package com.example.reactant.dto.response;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    SAVE_SUCCESS(200,"저장에 성공했습니다."),
    SELECT_SUCCESS(200,"조회에 성공했습니다."),
    UPDATE_SUCCESS(200,"수정에 성공했습니다."),
    DELETE_SUCCESS(200,"삭제에 성공했습니다."),
    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
