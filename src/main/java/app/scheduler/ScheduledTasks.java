package app.scheduler;


import app.entities.Review;
import app.services.implementations.ReviewService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    public final ReviewService service;

    @Autowired
    public ScheduledTasks(ReviewService reviewService){
        this.service = reviewService;
    }

    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithFixedRate() {
        service.deleteAllNoUser();
        logger.info("Reviews with no user were deleted");
    }

}
