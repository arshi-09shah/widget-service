package com.talentreef.interviewquestions.takehome.mapper;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.request.WidgetRequestDTO;
import com.talentreef.interviewquestions.takehome.response.WidgetResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WidgetMapper {
    WidgetMapper INSTANCE = Mappers.getMapper(WidgetMapper.class);

    // Convert DTO to Entity
    Widget toEntity(WidgetRequestDTO request);

    // Convert Entity to Response DTO
    WidgetResponseDTO toResponse(Widget widget);
}
