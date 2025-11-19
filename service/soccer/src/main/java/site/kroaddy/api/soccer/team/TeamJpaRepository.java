package site.kroaddy.api.soccer.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Team 엔티티를 위한 JPA Repository
 * 기존 TeamRepository는 일반 클래스이므로, 검색 기능을 위해 별도로 생성
 */
@Repository
public interface TeamJpaRepository extends JpaRepository<Team, Long> {
    
    // 검색 메서드: teamName, eTeamName에서 keyword 포함 검색
    List<Team> findByTeamNameContainingIgnoreCase(String keyword);
    List<Team> findByETeamNameContainingIgnoreCase(String keyword);

}

