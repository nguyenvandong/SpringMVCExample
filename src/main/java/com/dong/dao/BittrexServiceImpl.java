package com.dong.dao;

import com.dong.constant.Constants;
import com.dong.services.BittrexService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by DONG on 9/27/2017.
 */
@Component
public class BittrexServiceImpl implements BittrexService {

    public <T> List<T> getDataFromAPI(String uri, Class<T> objectType) throws Exception {

        List<T> temp = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
                    MappingJackson2HttpMessageConverter();
            mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_OCTET_STREAM));
            restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add(Constants.USER_AGENT, Constants.USER_AGENT_VALUE);
            HttpEntity<String> entity = new HttpEntity<String>(Constants.PARAMETERS, headers);

            ResponseEntity<Map> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);

            String statusCode = result.getStatusCode().toString();
            if (Constants.HTTP_STATUS_200.equals(statusCode)) {
                Map<String, Object> body = result.getBody();
                String success = body.get(Constants.SUCCESS).toString();
                if (Constants.SUCCESS_TRUE_VALUE.equals(success)) {
                    ObjectMapper mapper = new ObjectMapper();
                    JavaType type = mapper.getTypeFactory().constructParametricType(List.class, objectType);
                    temp = mapper.convertValue(body.get("result"), type);
                }
            }
            return temp;
        } catch (Exception e) {
            throw e;
        }
    }

}
