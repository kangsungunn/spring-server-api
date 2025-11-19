package site.kroaddy.api.soccer.team;

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
@RequestMapping("/teams")
public class TeamController {
    
    private final TeamService teamService;


    @PostMapping("/all")
    public Messenger saveAll(List<TeamModel> teams) {
        return teamService.saveAll(teams);
    }

    @PostMapping("")
    public Messenger save(TeamModel team) {
        return teamService.save(team);
    }

    @PutMapping("/{id}")
    public Messenger update(TeamModel team) {
        return teamService.update(team);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(String id) {
        return teamService.delete(id);
    }

    @GetMapping("/{id}")
    public Messenger findById(String id) {
        return teamService.findById(id);
    }

    @GetMapping("/all")
    public Messenger findAll() {
        return teamService.findAll();
    }
}
