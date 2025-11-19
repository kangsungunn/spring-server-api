package site.kroaddy.api.soccer.schedule;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.kroaddy.api.common.domain.Messenger;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Messenger save(ScheduleModel schedule) {
        Schedule entity = toEntity(schedule);
        Schedule saved = scheduleRepository.save(entity);
        return Messenger.builder()
                .code(200)
                .message("Schedule saved successfully")
                .data(toModel(saved))
                .build();
    }

    @Override
    public Messenger saveAll(List<ScheduleModel> schedules) {
        List<Schedule> entities = schedules.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        List<Schedule> saved = scheduleRepository.saveAll(entities);
        return Messenger.builder()
                .code(200)
                .message("Schedules saved successfully")
                .data(saved.stream().map(this::toModel).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Messenger update(ScheduleModel schedule) {
        if (schedule.getId() == null) {
            return Messenger.builder()
                    .code(400)
                    .message("Schedule ID is required for update")
                    .build();
        }
        Schedule entity = scheduleRepository.findById(schedule.getId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        updateEntity(entity, schedule);
        Schedule updated = scheduleRepository.save(entity);
        return Messenger.builder()
                .code(200)
                .message("Schedule updated successfully")
                .data(toModel(updated))
                .build();
    }

    @Override
    public Messenger delete(String id) {
        try {
            Long scheduleId = Long.parseLong(id);
            scheduleRepository.deleteById(scheduleId);
            return Messenger.builder()
                    .code(200)
                    .message("Schedule deleted successfully")
                    .build();
        } catch (NumberFormatException e) {
            return Messenger.builder()
                    .code(400)
                    .message("Invalid schedule ID format")
                    .build();
        }
    }

    @Override
    public Messenger findById(String id) {
        try {
            Long scheduleId = Long.parseLong(id);
            Schedule schedule = scheduleRepository.findById(scheduleId)
                    .orElse(null);
            if (schedule == null) {
                return Messenger.builder()
                        .code(404)
                        .message("Schedule not found")
                        .build();
            }
            return Messenger.builder()
                    .code(200)
                    .message("Schedule found")
                    .data(toModel(schedule))
                    .build();
        } catch (NumberFormatException e) {
            return Messenger.builder()
                    .code(400)
                    .message("Invalid schedule ID format")
                    .build();
        }
    }

    @Override
    public Messenger findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return Messenger.builder()
                .code(200)
                .message("Schedules retrieved successfully")
                .data(schedules.stream().map(this::toModel).collect(Collectors.toList()))
                .build();
    }

    private Schedule toEntity(ScheduleModel model) {
        return Schedule.builder()
                .id(model.getId())
                .stadiumUk(model.getStadiumId())
                .scheDate(model.getScheDate())
                .gubun(model.getGubun())
                .homeTeamUk(model.getHometeamId())
                .awayTeamUk(model.getAwayteamId())
                .homeScore(model.getHomeScore())
                .awayScore(model.getAwayScore())
                .build();
    }

    private ScheduleModel toModel(Schedule entity) {
        return ScheduleModel.builder()
                .id(entity.getId())
                .stadiumId(entity.getStadiumUk())
                .scheDate(entity.getScheDate())
                .gubun(entity.getGubun())
                .hometeamId(entity.getHomeTeamUk())
                .awayteamId(entity.getAwayTeamUk())
                .homeScore(entity.getHomeScore())
                .awayScore(entity.getAwayScore())
                .build();
    }

    private void updateEntity(Schedule entity, ScheduleModel model) {
        if (model.getStadiumId() != null) entity.setStadiumUk(model.getStadiumId());
        if (model.getScheDate() != null) entity.setScheDate(model.getScheDate());
        if (model.getGubun() != null) entity.setGubun(model.getGubun());
        if (model.getHometeamId() != null) entity.setHomeTeamUk(model.getHometeamId());
        if (model.getAwayteamId() != null) entity.setAwayTeamUk(model.getAwayteamId());
        if (model.getHomeScore() != null) entity.setHomeScore(model.getHomeScore());
        if (model.getAwayScore() != null) entity.setAwayScore(model.getAwayScore());
    }
}
