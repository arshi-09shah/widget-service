package com.talentreef.interviewquestions.takehome.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WidgetResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
