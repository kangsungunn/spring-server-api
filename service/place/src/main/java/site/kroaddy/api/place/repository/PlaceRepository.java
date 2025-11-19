package site.kroaddy.api.place.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.kroaddy.api.common.domain.Messenger;
import site.kroaddy.api.place.domain.PlaceDTO;


@Repository
public class PlaceRepository {

    // 장소 데이터 저장
    public Messenger saveAll(List<PlaceDTO> places) {

        return Messenger.builder()
                .code(200)
                .message("장소가 여러개 등록되었습니다.")
                .build();
    }

    public Messenger save(PlaceDTO places) {

        return Messenger.builder()
                .code(200)
                .message("장소가 등록되었습니다.")
                .build();
    }

    public Messenger update(PlaceDTO places) {

        return Messenger.builder()
                .code(200)
                .message("장소가 수정되었습니다.")
                .build();
    }

    public Messenger delete(String id) {

        return Messenger.builder()
                .code(200)
                .message("장소가 삭제되었습니다.")
                .build();
    }

    public Messenger findById(String id) {

        return Messenger.builder()
                .code(200)
                .message("장소가 조회되었습니다.")
                .build();
    }

    public Messenger findAll() {

        return Messenger.builder()
                .code(200)
                .message("장소가 조회되었습니다.")
                .build();
    }

}
