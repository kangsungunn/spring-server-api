package site.kroaddy.api.soccer.player;

import java.util.List;

import site.kroaddy.api.common.domain.Messenger;

public interface PlayerService {
    
    Messenger save(PlayerModel player);
    Messenger saveAll(List<PlayerModel> players);
    Messenger update(PlayerModel player);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();

}
