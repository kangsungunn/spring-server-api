package site.kroaddy.api.soccer.stadium;

import java.util.List;

import site.kroaddy.api.soccer.schedule.Schedule;
import site.kroaddy.api.soccer.team.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "stadiums")
@AllArgsConstructor
@NoArgsConstructor
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stadiumUk;
    private String homeTeamUk;
    private String stadiumName;

    private String seatCount;
    private String address;
    private String ddd;
    private String tel;

    // 한 경기장에서 한 팀만 소속될 수 있음
    @OneToMany(mappedBy = "stadium")
    private List<Team> teams;

    // 한 경기장에서 여러 경기가 열릴 수 있음
    @OneToMany(mappedBy = "stadium")
    private List<Schedule> schedules;

}
