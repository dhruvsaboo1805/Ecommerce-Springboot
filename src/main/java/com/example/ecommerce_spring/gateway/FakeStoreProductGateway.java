package com.example.ecommerce_spring.gateway;

import com.example.ecommerce_spring.dto.FakeStoreProductDTO;
import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.gateway.api.IFakeStoreProductAPI;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final IFakeStoreProductAPI fakeStoreProductApi;
    public FakeStoreProductGateway(IFakeStoreProductAPI fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        FakeStoreProductDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
//        System.out.println(response);
        if (response == null) {
            throw new Exception("Product not found");
        }

        return response.getProducts();
    }
}
