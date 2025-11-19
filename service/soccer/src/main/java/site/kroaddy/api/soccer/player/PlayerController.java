package site.kroaddy.api.soccer.player;

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
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/all")
    public Messenger saveAll(List<PlayerModel> players) {
        return playerService.saveAll(players);
    }

    @PostMapping("")
    public Messenger save(PlayerModel player) {
        return playerService.save(player);
    }

    @PutMapping("/{id}")
    public Messenger update(PlayerModel player) {
        return playerService.update(player);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(String id) {
        return playerService.delete(id);
    }

    @GetMapping("/{id}")
    public Messenger findById(String id) {
        return playerService.findById(id);
    }

    @GetMapping("/all")
    public Messenger findAll() {
        return playerService.findAll();
    }
}
