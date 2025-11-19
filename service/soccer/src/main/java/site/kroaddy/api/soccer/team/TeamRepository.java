package site.kroaddy.api.soccer.team;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.kroaddy.api.common.domain.Messenger;

@Repository
public class TeamRepository {
    
     // 선수 데이터 저장
     public Messenger saveAll(List<TeamModel> teams) {

        return Messenger.builder()
                .code(200)
                .message("팀이 여러개 등록되었습니다.")
                .build();
    }

    public Messenger save(TeamModel team) {

        return Messenger.builder()
                .code(200)
                .message("팀이 등록되었습니다.")
                .build();
    }

    public Messenger update(TeamModel team) {

        return Messenger.builder()
                .code(200)
                .message("팀이 수정되었습니다.")
                .build();
    }

    public Messenger delete(String id) {

        return Messenger.builder()
                .code(200)
                .message("팀이 삭제되었습니다.")
                .build();
    }

    public Messenger findById(String id) {

        return Messenger.builder()
                .code(200)
                .message("팀이 조회되었습니다.")
                .build();
    }

    public Messenger findAll() {

        return Messenger.builder()
                .code(200)
                .message("팀이 조회되었습니다.")
                .build();
    }
    
}
