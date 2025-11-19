package site.kroaddy.api.place.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "places")
public class Place {
    
    @Id private long id;
    private String placeName;
    private String addressRoad;
    private String addressJibun;
    private String latitude;
    private String longitude;
    private String description;
    private String phoneNumber;
    
}
