package site.kroaddy.api.soccer.team;

import java.util.List;

import site.kroaddy.api.soccer.player.Player;
import site.kroaddy.api.soccer.stadium.Stadium;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamUk; // team_id
    private String regionName; // region_name
    private String teamName; // team_name
    private String eTeamName; // e_team_name
    private String origYyyy; // orig_yyyy
    private String zipCode1; // zip_code1
    private String zipCode2; // zip_code2
    private String address; // address
    private String ddd; // ddd
    private String tel; // tel
    private String fax; // fax
    private String homepage; // homepage
    private String owner; // owner
    private String stadiumUk; // stadium_id

    // 1:1 관계
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    // 1:N 관계
    @OneToMany(mappedBy = "team")
    private List<Player> players;

}
