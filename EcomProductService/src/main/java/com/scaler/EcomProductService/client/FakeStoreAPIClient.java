package com.scaler.EcomProductService.client;

import com.scaler.EcomProductService.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
    * Wrapper on FakeStoreProduct APIs
 */
@Component
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreAPIURL;
//    Field Injection
    @Value("${fakestore.api.path.product}")
    private String getFakeStoreAPIPathProduct;

//    Constructor Injection  Use this for Best Practices
    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreAPIURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createProductURL = fakeStoreAPIURL + getFakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        String getProductByUrlId = fakeStoreAPIURL + getFakeStoreAPIPathProduct +"/"+ id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(getProductByUrlId, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProducts = fakeStoreAPIURL + getFakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProducts, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }
    public void deleteProduct(int id) {
        String productDeleteURL = fakeStoreAPIURL + getFakeStoreAPIPathProduct+ "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);

    }
}
