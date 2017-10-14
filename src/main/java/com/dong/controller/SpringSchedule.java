package com.dong.controller;

import com.dong.dao.BittrexServiceImpl;
import com.dong.dao.EmailServiceImpl;
import com.dong.dao.PoolServiceImpl;
import com.dong.model.MarketSummaries;
import com.dong.model.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DONG on 10/3/2017.
 */
@Configuration
@EnableScheduling
public class SpringSchedule {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final String MINER_ID = "t1f6R6CbTCqWdjL3ztse89wbKoZ7SxgzEjg";
    private static final String URI_ZEC = "https://bittrex.com/api/v1.1/public/getmarketsummary?market=usdt-zec";
    private static Double MIN_ZEC = 220.0;

    @Autowired
    public EmailServiceImpl emailService;

    @Autowired
    PoolServiceImpl poolService;

    @Autowired
    BittrexServiceImpl bittrexService;

    @Scheduled(fixedDelay = 180000)
    public void scheduleFixedDelayTask() {
        Statistics statistics = null;
        try {
            statistics = poolService.getDataFromAPI(MINER_ID, Statistics.class);
            if (statistics != null) {
                int activeWorker = Integer.parseInt(statistics.getActiveWorkers());
                if (activeWorker <= 0) {
                    emailService.sendSimpleMessage("nvd.it.neu@gmail.com", "Trau chet", "Kiem tra trau ngay");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 180000)
    public void bittrexCheckZec() {
        List<MarketSummaries> result = new ArrayList<MarketSummaries>();
        try {
            result = bittrexService.getDataFromAPI(URI_ZEC, MarketSummaries.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!result.isEmpty()) {
            for (MarketSummaries temp : result) {
                if (Double.parseDouble(temp.getLast()) <= MIN_ZEC) {
                    emailService.sendSimpleMessage("nvd.it.neu@gmail.com", "Zec xuong gia", temp.getLast());
                }
            }
        }
    }
}
