   package site.kroaddy.api.place.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.kroaddy.api.common.domain.Messenger;
import site.kroaddy.api.place.domain.PlaceDTO;
import site.kroaddy.api.place.service.PlaceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;


    @PostMapping("/all")
    public Messenger saveAll(List<PlaceDTO> places) {
        return placeService.saveAll(places);
    }

    @PostMapping("")
    public Messenger save(PlaceDTO place) {
        return placeService.save(place);
    }

    @PutMapping("/{id}")
    public Messenger update(PlaceDTO place) {
        return placeService.update(place);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(String id) {
        return placeService.delete(id);
    }

    @GetMapping("/{id}")
    public Messenger findById(String id) {
        return placeService.findById(id);
    }

    @GetMapping("/all")
    public Messenger findAll() {
        return placeService.findAll();
    }
}
