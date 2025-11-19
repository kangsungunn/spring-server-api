package site.kroaddy.api.place.service;

import java.util.List;

import org.springframework.stereotype.Service;

import site.kroaddy.api.common.domain.Messenger;
import site.kroaddy.api.place.domain.PlaceDTO;
import site.kroaddy.api.place.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    
    @Override
    public Messenger save(PlaceDTO places) {

        return placeRepository.save(places);
    }

    @Override
    public Messenger saveAll(List<PlaceDTO> places) {

        return placeRepository.saveAll(places);

    }

    @Override
    public Messenger update(PlaceDTO places) {

        return placeRepository.save(places);
    }

    @Override
    public Messenger delete(String id) {

        return placeRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {

        return placeRepository.findById(id);

    }

    @Override
    public Messenger findAll() {

        return placeRepository.findAll();
    }

}
