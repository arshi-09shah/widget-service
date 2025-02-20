package com.talentreef.interviewquestions.takehome.mapper;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.request.WidgetRequestDTO;
import com.talentreef.interviewquestions.takehome.response.WidgetResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-20T16:25:19+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class WidgetMapperImpl implements WidgetMapper {

    @Override
    public Widget toEntity(WidgetRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        Widget widget = new Widget();

        widget.setId( request.getId() );
        widget.setName( request.getName() );
        widget.setDescription( request.getDescription() );
        widget.setPrice( request.getPrice() );

        return widget;
    }

    @Override
    public WidgetResponseDTO toResponse(Widget widget) {
        if ( widget == null ) {
            return null;
        }

        WidgetResponseDTO widgetResponseDTO = new WidgetResponseDTO();

        widgetResponseDTO.setId( widget.getId() );
        widgetResponseDTO.setName( widget.getName() );
        widgetResponseDTO.setDescription( widget.getDescription() );
        widgetResponseDTO.setPrice( widget.getPrice() );

        return widgetResponseDTO;
    }
}
