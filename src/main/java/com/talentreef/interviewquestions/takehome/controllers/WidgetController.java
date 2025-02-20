package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.request.WidgetRequestDTO;
import com.talentreef.interviewquestions.takehome.response.WidgetResponseDTO;
import com.talentreef.interviewquestions.takehome.services.WidgetServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = "/v1/widgets")
public class WidgetController {
  private final WidgetServiceImpl service;

    public WidgetController(WidgetServiceImpl service) {
        this.service = service;
    }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WidgetResponseDTO create(@Valid @RequestBody WidgetRequestDTO dto) {
    return service.createWidget(dto);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<WidgetResponseDTO> getAll() {
    return service.getAllWidgets();
  }

  @GetMapping("/{name}")
  public WidgetResponseDTO getByName(@PathVariable String name) {
    return service.getWidgetByName(name);
  }

  @PutMapping("/{id}")
  public WidgetResponseDTO update(@PathVariable Long id, @Valid @RequestBody WidgetRequestDTO dto) {
    return service.updateWidget(id, dto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteWidget(id);
  }

}
