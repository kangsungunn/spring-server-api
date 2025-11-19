package site.kroaddy.api.place.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PlaceDTO {

   
    private Long id;
    private String placeName;
    private String addressRoad;
    private String addressJibun;
    private String latitude;
    private String longitude;
    private String description;
    private String phoneNumber;

}
