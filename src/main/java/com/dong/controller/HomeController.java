package com.dong.controller;

import com.dong.dao.BittrexServiceImpl;
import com.dong.model.MarketSummaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private BittrexServiceImpl bittrexService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model) {

        String uri = "https://bittrex.com/api/v1.1/public/getmarketsummary?market=usdt-zec";
        List<MarketSummaries> result = new ArrayList<MarketSummaries>();
        try {
            result = (List<MarketSummaries>) bittrexService.getDataFromAPI(uri, MarketSummaries.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView test = new ModelAndView("home");
        test.addObject("lists", result);

        return test;

    }

}
