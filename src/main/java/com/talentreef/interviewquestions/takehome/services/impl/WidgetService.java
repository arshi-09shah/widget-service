package com.talentreef.interviewquestions.takehome.services.impl;

import com.talentreef.interviewquestions.takehome.request.WidgetRequestDTO;
import com.talentreef.interviewquestions.takehome.response.WidgetResponseDTO;

import java.util.List;

public interface WidgetService {
    WidgetResponseDTO createWidget(WidgetRequestDTO dto);
    List<WidgetResponseDTO> getAllWidgets();
    WidgetResponseDTO getWidgetByName(String name);
    WidgetResponseDTO updateWidget(Long id, WidgetRequestDTO dto);
    void deleteWidget(Long id);
}
