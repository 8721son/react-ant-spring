package com.example.reactant.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DiaryResponseDTO {
    private int id;
    private String title;
    private String content;
    private String date;
}
