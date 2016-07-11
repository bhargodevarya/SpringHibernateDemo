package com.example.service;

import com.example.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by hadoop on 7/7/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductService productService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetProductsByBrand() {
        Product product = new Product("Xiomi latest phone", 11999,"redmi note3","xiomi");
        List<Product> productList = productService
                .getProductsForBrand("Productfindbrand");
        Assert.assertEquals(1,productList.size());
        Assert.assertEquals(product, productList.get(0));
    }

}
