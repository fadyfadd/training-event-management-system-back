package com.training.training_event_management_system_back.mappers;

import com.training.training_event_management_system_back.dto.AdminDto;
import com.training.training_event_management_system_back.entities.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AdminMapper {
//    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDto toDTO(Admin admin);
    Admin toEntity(AdminDto adminDto);

    List<AdminDto> toDTOList (List<Admin> admins);

}


