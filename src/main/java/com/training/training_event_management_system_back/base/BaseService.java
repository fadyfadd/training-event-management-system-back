package com.training.training_event_management_system_back.base;

import java.util.List;
import java.util.Optional;

public interface BaseService <D, ID>{
    D create(D dto);
    Optional<D>getById(D id);
    List<D> getAll();

}
