package site.kroaddy.api.soccer.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.kroaddy.api.soccer.common.Messenger;
import site.kroaddy.api.soccer.player.Player;
import site.kroaddy.api.soccer.player.PlayerModel;
import site.kroaddy.api.soccer.player.PlayerRepository;
import site.kroaddy.api.soccer.schedule.Schedule;
import site.kroaddy.api.soccer.schedule.ScheduleModel;
import site.kroaddy.api.soccer.schedule.ScheduleRepository;
import site.kroaddy.api.soccer.stadium.Stadium;
import site.kroaddy.api.soccer.stadium.StadiumModel;
import site.kroaddy.api.soccer.stadium.StadiumRepository;
import site.kroaddy.api.soccer.team.Team;
import site.kroaddy.api.soccer.team.TeamJpaRepository;
import site.kroaddy.api.soccer.team.TeamModel;

/**
 * 통합 검색 서비스 구현체
 */
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final PlayerRepository playerRepository;
    private final TeamJpaRepository teamJpaRepository;
    private final StadiumRepository stadiumRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public Messenger search(String type, String keyword) {
        if (type == null || keyword == null || keyword.trim().isEmpty()) {
            return Messenger.builder()
                    .code(400)
                    .message("type과 keyword 파라미터가 필요합니다.")
                    .build();
        }

        String lowerKeyword = keyword.toLowerCase().trim();

        switch (type.toLowerCase()) {
            case "player":
                return searchPlayers(lowerKeyword);
            case "team":
                return searchTeams(lowerKeyword);
            case "stadium":
                return searchStadiums(lowerKeyword);
            case "schedule":
                return searchSchedules(lowerKeyword);
            default:
                return Messenger.builder()
                        .code(400)
                        .message("지원하지 않는 검색 타입입니다. (player, team, stadium, schedule 중 하나를 선택하세요)")
                        .build();
        }
    }

    /**
     * Player 검색: playerName, ePlayerName, nickname에서 검색
     */
    private Messenger searchPlayers(String keyword) {
        Set<Player> results = new HashSet<>();
        
        // playerName으로 검색
        results.addAll(playerRepository.findByPlayerNameContainingIgnoreCase(keyword));
        
        // ePlayerName으로 검색
        results.addAll(playerRepository.findByEPlayerNameContainingIgnoreCase(keyword));
        
        // nickname으로 검색
        results.addAll(playerRepository.findByNicknameContainingIgnoreCase(keyword));

        List<PlayerModel> playerModels = results.stream()
                .map(this::toPlayerModel)
                .collect(Collectors.toList());

        return Messenger.builder()
                .code(200)
                .message("Player 검색 완료: " + playerModels.size() + "건")
                .data(playerModels)
                .build();
    }

    /**
     * Team 검색: teamName, eTeamName에서 검색
     */
    private Messenger searchTeams(String keyword) {
        Set<Team> results = new HashSet<>();
        
        // teamName으로 검색
        results.addAll(teamJpaRepository.findByTeamNameContainingIgnoreCase(keyword));
        
        // eTeamName으로 검색
        results.addAll(teamJpaRepository.findByETeamNameContainingIgnoreCase(keyword));

        List<TeamModel> teamModels = results.stream()
                .map(this::toTeamModel)
                .collect(Collectors.toList());

        return Messenger.builder()
                .code(200)
                .message("Team 검색 완료: " + teamModels.size() + "건")
                .data(teamModels)
                .build();
    }

    /**
     * Stadium 검색: stadiumName에서 검색
     */
    private Messenger searchStadiums(String keyword) {
        List<Stadium> results = stadiumRepository.findByStadiumNameContainingIgnoreCase(keyword);

        List<StadiumModel> stadiumModels = results.stream()
                .map(this::toStadiumModel)
                .collect(Collectors.toList());

        return Messenger.builder()
                .code(200)
                .message("Stadium 검색 완료: " + stadiumModels.size() + "건")
                .data(stadiumModels)
                .build();
    }

    /**
     * Schedule 검색: homeTeamUk, awayTeamUk, scheDate에서 검색
     */
    private Messenger searchSchedules(String keyword) {
        Set<Schedule> results = new HashSet<>();
        
        // homeTeamUk으로 검색
        results.addAll(scheduleRepository.findByHomeTeamUkContainingIgnoreCase(keyword));
        
        // awayTeamUk으로 검색
        results.addAll(scheduleRepository.findByAwayTeamUkContainingIgnoreCase(keyword));
        
        // scheDate로 검색
        results.addAll(scheduleRepository.findByScheDateContaining(keyword));

        List<ScheduleModel> scheduleModels = results.stream()
                .map(this::toScheduleModel)
                .collect(Collectors.toList());

        return Messenger.builder()
                .code(200)
                .message("Schedule 검색 완료: " + scheduleModels.size() + "건")
                .data(scheduleModels)
                .build();
    }

    // Entity to Model 변환 메서드들
    private PlayerModel toPlayerModel(Player entity) {
        return PlayerModel.builder()
                .id(entity.getId())
                .playerId(entity.getPlayerUk())
                .playerName(entity.getPlayerName())
                .ePlayerName(entity.getEPlayerName())
                .nickname(entity.getNickname())
                .joinYyyy(entity.getJoinYyyy())
                .position(entity.getPosition())
                .backNo(entity.getBackNo())
                .nation(entity.getNation())
                .birthDate(entity.getBirthDate())
                .solar(entity.getSolar())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .teamId(entity.getTeamUk())
                .build();
    }

    private TeamModel toTeamModel(Team entity) {
        return TeamModel.builder()
                .id(entity.getId())
                .teamId(entity.getTeamUk())
                .regionName(entity.getRegionName())
                .teamName(entity.getTeamName())
                .eTeamName(entity.getETeamName())
                .origYyyy(entity.getOrigYyyy())
                .zipCode1(entity.getZipCode1())
                .zipCode2(entity.getZipCode2())
                .address(entity.getAddress())
                .ddd(entity.getDdd())
                .tel(entity.getTel())
                .fax(entity.getFax())
                .homepage(entity.getHomepage())
                .owner(entity.getOwner())
                .stadiumId(entity.getStadiumUk())
                .build();
    }

    private StadiumModel toStadiumModel(Stadium entity) {
        return StadiumModel.builder()
                .id(entity.getId())
                .stadiumId(entity.getStadiumUk())
                .stadiumName(entity.getStadiumName())
                .hometeamId(entity.getHomeTeamUk())
                .seatCount(entity.getSeatCount())
                .address(entity.getAddress())
                .ddd(entity.getDdd())
                .tel(entity.getTel())
                .build();
    }

    private ScheduleModel toScheduleModel(Schedule entity) {
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
}

