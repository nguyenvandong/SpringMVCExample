package com.dong.dao;

import com.dong.constant.Constants;
import com.dong.services.PoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DONG on 9/27/2017.
 */
@Component
public class PoolServiceImpl implements PoolService {

    private static final String uri = "https://api-zcash.flypool.org/miner/{miner}/currentStats";

    public <T> T getDataFromAPI(String minerID, Class<T> objectType) throws Exception {

        T temp = null;
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("miner", minerID);

            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
                    MappingJackson2HttpMessageConverter();
            mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_OCTET_STREAM));
            restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("user-agent", Constants.USER_AGENT);
            HttpEntity<String> entity = new HttpEntity<String>(Constants.PARAMETERS, headers);

            ResponseEntity<Map> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class, param);

            String statusCode = result.getStatusCode().toString();
            if (Constants.HTTP_STATUS_200.equals(statusCode)) {
                Map<String, Object> body = result.getBody();
                String status = body.get(Constants.STATUS).toString();
                if (Constants.STATUS_OK.equals(status)) {
                    ObjectMapper mapper = new ObjectMapper();
                    Map<String, Object> strObj = (Map<String, Object>) body.get("data");
                    temp = mapper.convertValue(strObj, objectType);
                }
            }
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }

}
