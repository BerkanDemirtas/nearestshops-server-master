/**
 * Build By SALMAN EL FADILI
 **/
package com.nearbyshops.services;

import com.nearbyshops.models.Shop;
import com.nearbyshops.repositories.ShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
public class ShopServices {

    private static final Logger logger = LoggerFactory.getLogger(ShopServices.class);
    @Autowired
    ShopRepository shopRepository;

    public List<Shop> allShops() {
        List<Shop> shops = shopRepository.findAll();
        logger.info("Find all "+shops.size()+" shops");
        return shops;
    }

    public List<Shop> nearestShops(double lat, double lon, double distance) {
        // Because the shops list should be displayed without preferred or disliked ones we'll clear shops list before return to response
        // Get all nearest shops
        List<Shop> allShops = shopRepository.findByLocationNear(new Point(lon,lat), new Distance(distance, Metrics.KILOMETERS));

        logger.info("Find "+allShops.size()+" shops within "+distance+"KM distance");
        return allShops;
    }




}
