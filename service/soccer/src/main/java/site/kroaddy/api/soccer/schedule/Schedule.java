package site.kroaddy.api.soccer.schedule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.kroaddy.api.soccer.stadium.Stadium;

@Data
@Entity
@Table(name = "schedules")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stadiumUk;
    private String scheDate;
    private String gubun;
    private String homeTeamUk;
    private String awayTeamUk;
    private String homeScore;
    private String awayScore;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

}
