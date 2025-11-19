package site.kroaddy.api.soccer.stadium;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.kroaddy.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumService stadiumService;

    @PostMapping("")
    public Messenger save(StadiumModel stadium) {
        return stadiumService.save(stadium);
    }

    @PostMapping("/all")
    public Messenger saveAll(List<StadiumModel> stadiums) {
        return stadiumService.saveAll(stadiums);
    }

    @PutMapping("/{id}")
    public Messenger update(StadiumModel stadium) {
        return stadiumService.update(stadium);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(String id) {
        return stadiumService.delete(id);
    }

    @GetMapping("/{id}")
    public Messenger findById(String id) {
        return stadiumService.findById(id);
    }

    @GetMapping("/all")
    public Messenger findAll() {
        return stadiumService.findAll();
    }
}
