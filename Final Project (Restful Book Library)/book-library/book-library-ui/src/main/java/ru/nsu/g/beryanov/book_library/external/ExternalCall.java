package ru.nsu.g.beryanov.book_library.external;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExternalCall {
    private static final HttpHeaders headers;
    private final RestTemplate restTemplate = new RestTemplate();

    static {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public <T> T postCall(String json, String url, Class<T> clazz) {
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        return restTemplate.postForObject(url, request, clazz);
    }

    public <T> T getCall(String url, Class<T> clazz) {
        return restTemplate.getForObject(url, clazz);
    }
}
