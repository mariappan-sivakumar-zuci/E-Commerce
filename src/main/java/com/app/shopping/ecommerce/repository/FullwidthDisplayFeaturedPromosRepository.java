package com.app.shopping.ecommerce.repository;

import com.app.shopping.ecommerce.entity.FullwidthDisplayFeaturedPromos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FullwidthDisplayFeaturedPromosRepository extends JpaRepository<FullwidthDisplayFeaturedPromos,Long> {
    @Query("SELECT promo FROM FullwidthDisplayFeaturedPromos promo " +
            "WHERE :searchDate BETWEEN promo.startingDate AND promo.endingDate")
    List<FullwidthDisplayFeaturedPromos> findPromosByDate(@Param("searchDate") Date searchDate);
}
