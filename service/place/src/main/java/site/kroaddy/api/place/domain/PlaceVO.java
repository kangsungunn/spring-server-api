package site.kroaddy.api.place.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaceVO {
    

    private Long id;
    private String placeName;
    private String addressRoad;
    private String addressJibun;
    private String latitude;
    private String longitude;
    private String description;
    private String phoneNumber;

}
