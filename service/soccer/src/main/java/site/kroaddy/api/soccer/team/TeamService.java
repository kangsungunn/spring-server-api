package site.kroaddy.api.soccer.team;

import java.util.List;

import site.kroaddy.api.common.domain.Messenger;

public interface TeamService {

    Messenger save(TeamModel team);
    Messenger saveAll(List<TeamModel> teams);
    Messenger update(TeamModel team);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();

    

}
