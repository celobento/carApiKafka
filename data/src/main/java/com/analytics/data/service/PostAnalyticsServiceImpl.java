package com.analytics.data.service;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.entity.BrandAnalyticsEntity;
import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarModelPriceEntity;
import com.analytics.data.repository.BrandAnalyticsRepository;
import com.analytics.data.repository.CarModelAnalyticsRepository;
import com.analytics.data.repository.CarPriceAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl {

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getBrand());
        saveCarModelPriceAnalytics(carPostDTO.getBrand(), carPostDTO.getPrice());
    }

    private void saveCarModelPriceAnalytics(String model, Double price) {

        CarModelPriceEntity carModelAnalyticsEntity = new CarModelPriceEntity();
        carModelAnalyticsEntity.setModel(model);
        carModelAnalyticsEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carModelAnalyticsEntity);

    }

    private void saveCarModelAnalytics(String model) {

        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            CarModelAnalyticsEntity carModelAnalytics = new CarModelAnalyticsEntity();
            carModelAnalytics.setModel(model);
            carModelAnalytics.setPosts(1l);
            carModelAnalyticsRepository.save(carModelAnalytics);

        });
    }

    private void saveBrandAnalytics(String brand) {

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1l);
            brandAnalyticsRepository.save(brandAnalyticsEntity);

        });
    }

}
