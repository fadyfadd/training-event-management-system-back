package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.EventDTO;
import com.training.training_event_management_system_back.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface EventMapper {

//    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDTO toDTO(Event event);


    Event toEntity(EventDTO dto);

    List<EventDTO> toDTOList(List<Event> eventList);
    Set<Event> toEntitySet(Set<EventDTO> dtoSet);
}
