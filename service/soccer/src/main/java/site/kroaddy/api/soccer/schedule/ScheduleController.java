package site.kroaddy.api.soccer.schedule;

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
@RequestMapping("/schedules")
public class ScheduleController {
    
    private final ScheduleService scheduleService;


    @PostMapping("/all")
    public Messenger saveAll(List<ScheduleModel> schedules) {
        return scheduleService.saveAll(schedules);
    }

    @PostMapping("")
    public Messenger save(ScheduleModel schedule) {
        return scheduleService.save(schedule);
    }

    @PutMapping("/{id}")
    public Messenger update(ScheduleModel schedule) {
        return scheduleService.update(schedule);
    }

    @DeleteMapping("/{id}")
    public Messenger delete(String id) {
        return scheduleService.delete(id);
    }

    @GetMapping("/{id}")
    public Messenger findById(String id) {
        return scheduleService.findById(id);
    }

    @GetMapping("/all")
    public Messenger findAll() {
        return scheduleService.findAll();
    }
}
