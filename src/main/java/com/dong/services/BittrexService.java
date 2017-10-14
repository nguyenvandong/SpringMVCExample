package com.dong.services;

import java.util.List;

/**
 * Created by DONG on 10/5/2017.
 */
public interface BittrexService {
    <T> List<T> getDataFromAPI(String uri, Class<T> objectType) throws Exception;
}
