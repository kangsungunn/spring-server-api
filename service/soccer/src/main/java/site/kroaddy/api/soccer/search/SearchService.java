package site.kroaddy.api.soccer.search;

import site.kroaddy.api.soccer.common.Messenger;

/**
 * 통합 검색 서비스 인터페이스
 * type (player, team, stadium, schedule)에 따라 검색 수행
 */
public interface SearchService {
    
    /**
     * 타입과 키워드로 검색 수행
     * @param type 검색 타입 (player, team, stadium, schedule)
     * @param keyword 검색 키워드
     * @return Messenger 객체 (검색 결과 포함)
     */
    Messenger search(String type, String keyword);
}

