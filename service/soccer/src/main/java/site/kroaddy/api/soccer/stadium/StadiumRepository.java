package site.kroaddy.api.soccer.stadium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long>, StadiumRepositoryCustom {
    
    // 검색 메서드: stadiumName에서 keyword 포함 검색
    java.util.List<Stadium> findByStadiumNameContainingIgnoreCase(String keyword);

}
