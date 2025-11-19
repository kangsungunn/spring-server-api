package site.kroaddy.api.soccer.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, PlayerRepositoryCustom {

    // 검색 메서드: playerName, ePlayerName, nickname에서 keyword 포함 검색
    java.util.List<Player> findByPlayerNameContainingIgnoreCase(String keyword);
    java.util.List<Player> findByEPlayerNameContainingIgnoreCase(String keyword);
    java.util.List<Player> findByNicknameContainingIgnoreCase(String keyword);

}
