package com.irfan.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.irfan.product.dao.ProductDAO;
import com.irfan.product.entity.Product;
import com.irfan.product.service.ProductService;
import com.irfan.product.service.impl.ProductServiceImpl;

@SpringBootTest
class ProductServiceApplicationTests {

	@TestConfiguration
	static class ProductServiceTestContextConfiguration {
		@Bean
		public ProductService productServTest() {
			return new ProductServiceImpl();
		}
	}

	@Autowired
	ProductService productServTest;

	@MockBean
	private ProductDAO productDao;

	@Test
	void contextLoads() {
		Product prod = new Product();
		prod.setId(1);
		prod.setProductNo(100001);
		prod.setName("Monitor");

		Mockito.when(productDao.findByProductNo(prod.getProductNo())).thenReturn(prod);

		Product product = productDao.findByProductNo(100001);

		assertThat(product.getName()).isEqualTo("Monitor");
	}

}
