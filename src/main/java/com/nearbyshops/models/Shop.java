/**
 * Build By SALMAN EL FADILI
 **/
package com.nearbyshops.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("resturants")
public class Shop {

    @Id
    private String id;
    private String name;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    public Shop(String id, String name, GeoJsonPoint location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
