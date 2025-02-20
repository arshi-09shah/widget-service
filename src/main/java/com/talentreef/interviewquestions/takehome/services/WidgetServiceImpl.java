package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.mapper.WidgetMapper;
import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.request.WidgetRequestDTO;
import com.talentreef.interviewquestions.takehome.response.WidgetResponseDTO;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import com.talentreef.interviewquestions.takehome.services.impl.WidgetService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WidgetServiceImpl implements WidgetService {
    private final WidgetRepository repository;
    private final WidgetMapper widgetMapper;


    public WidgetServiceImpl(WidgetRepository repository, WidgetMapper widgetMapper) {
        this.repository = repository;
        this.widgetMapper = widgetMapper;
    }

    @Override
    public WidgetResponseDTO createWidget(WidgetRequestDTO dto) {
        if (repository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Widget with this name already exists");
        }

        Widget widget = widgetMapper.toEntity(dto);
        repository.save(widget);

        return new WidgetResponseDTO(widget.getId(), widget.getName(), widget.getDescription(), widget.getPrice());
    }

    @Override
    public List<WidgetResponseDTO> getAllWidgets() {
        return repository.findAll().stream()
                .map(widgetMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public WidgetResponseDTO getWidgetByName(String name) {
        Widget widget = repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Widget not found"));
        return widgetMapper.toResponse(widget);
    }

    @Override
    public WidgetResponseDTO updateWidget(Long id, WidgetRequestDTO dto) {
        Widget widget = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Widget not found"));

        widget.setDescription(dto.getDescription());
        widget.setPrice(dto.getPrice());

        Widget updatedWidget = repository.save(widget);
        return widgetMapper.toResponse(updatedWidget);
    }

    @Override
    public void deleteWidget(Long  id) {
        Widget widget = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Widget not found"));
        repository.delete(widget);
    }


}
