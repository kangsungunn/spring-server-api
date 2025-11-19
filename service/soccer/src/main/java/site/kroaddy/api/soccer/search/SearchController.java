package site.kroaddy.api.soccer.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.kroaddy.api.soccer.common.Messenger;

/**
 * 통합 검색 컨트롤러
 * /search 엔드포인트 제공
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    /**
     * 통합 검색 API
     * @param type 검색 타입 (player, team, stadium, schedule)
     * @param keyword 검색 키워드
     * @return Messenger 객체 (검색 결과 포함)
     */
    @GetMapping("")
    public Messenger search(
            @RequestParam("type") String type,
            @RequestParam("keyword") String keyword) {
        return searchService.search(type, keyword);
    }
}

