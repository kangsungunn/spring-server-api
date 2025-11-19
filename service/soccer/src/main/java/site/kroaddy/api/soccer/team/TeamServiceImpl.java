package site.kroaddy.api.soccer.team;

import java.util.List;

import org.springframework.stereotype.Service;

import site.kroaddy.api.common.domain.Messenger;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Messenger save(TeamModel team) {

        return teamRepository.save(team);
    }

    @Override
    public Messenger saveAll(List<TeamModel> teams) {

        return teamRepository.saveAll(teams);
    }

    @Override
    public Messenger update(TeamModel team) {

        return teamRepository.save(team);
    }

    @Override
    public Messenger delete(String id) {

        return teamRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {

        return teamRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        
        return teamRepository.findAll();
    }
 
}
