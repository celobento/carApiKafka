package com.analytics.data.message;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.service.PostAnalyticsService;
import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(CarPostDTO carPost) {
        LOG.info("ANALYTICS-DATA Receiving Car Post: {}", carPost );
        postAnalyticsService.saveDataAnalytics(carPost);
    }
}
