package com.acme.hotels.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
@Builder
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    private String id;
    private String uuid;
    private String type;
    private String name;
    private Long created;
    private Long modified;
    private String address1;
    private String airportCode;
    private Integer amenityMask;
    private String city;
    private Integer confidenceRating;
    private String countryCode;
    private String deepLink;
    private Integer highRate;
    private Integer hotelId;
    private Boolean hotelInDestination;
    private Integer hotelRating;
    private Location location;
    private String locationDescription;
    private Integer lowRate;
    private Metadata metadata;
    private Integer postalCode;
    private Integer propertyCategory;
    private Double proximityDistance;
    private String proximityUnit;
    private String rateCurrencyCode;
    private String shortDescription;
    private String stateProvinceCode;
    private String thumbNailUrl;
    private Double tripAdvisorRating;
    private String tripAdvisorRatingUrl;
}
