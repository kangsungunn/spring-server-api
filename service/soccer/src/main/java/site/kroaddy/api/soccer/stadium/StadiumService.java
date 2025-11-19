package site.kroaddy.api.soccer.stadium;

import java.util.List;

import site.kroaddy.api.common.domain.Messenger;

public interface StadiumService {

    Messenger save(StadiumModel stadium);
    Messenger saveAll(List<StadiumModel> stadiums);
    Messenger update(StadiumModel stadium);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();
    
    


}
