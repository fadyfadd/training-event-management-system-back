package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.EventDto;
import com.training.training_event_management_system_back.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDto toDTO(Event event);


    Event toEntity(EventDto dto);

    List<EventDto> toDTOList(List<Event> eventList);
    Set<Event> toEntitySet(Set<EventDto> dtoSet);
}
