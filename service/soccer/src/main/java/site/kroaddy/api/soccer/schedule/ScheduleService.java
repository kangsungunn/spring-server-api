package site.kroaddy.api.soccer.schedule;

import java.util.List;

import site.kroaddy.api.common.domain.Messenger;

public interface ScheduleService {

    Messenger save(ScheduleModel schedule);
    Messenger saveAll(List<ScheduleModel> schedules);
    Messenger update(ScheduleModel schedule);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();

    }

