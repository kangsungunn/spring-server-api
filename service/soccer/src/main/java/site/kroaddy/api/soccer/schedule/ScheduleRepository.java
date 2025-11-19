package site.kroaddy.api.soccer.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {
    
    // 검색 메서드: homeTeamUk, awayTeamUk, scheDate에서 keyword 포함 검색
    java.util.List<Schedule> findByHomeTeamUkContainingIgnoreCase(String keyword);
    java.util.List<Schedule> findByAwayTeamUkContainingIgnoreCase(String keyword);
    java.util.List<Schedule> findByScheDateContaining(String keyword);

}
