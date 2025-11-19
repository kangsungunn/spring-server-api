package site.kroaddy.api.place.service;

import java.util.List;

import site.kroaddy.api.common.domain.Messenger;
import site.kroaddy.api.place.domain.PlaceDTO;

public interface PlaceService {

    Messenger save(PlaceDTO places);
    Messenger saveAll(List<PlaceDTO> places);
    Messenger update(PlaceDTO places);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();



}
