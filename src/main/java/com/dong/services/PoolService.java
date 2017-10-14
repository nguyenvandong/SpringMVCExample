package com.dong.services;

/**
 * Created by DONG on 10/5/2017.
 */
public interface PoolService {
    <T> T getDataFromAPI(String minerID, Class<T> objectType) throws Exception;
}
