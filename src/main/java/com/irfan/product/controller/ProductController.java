package com.irfan.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfan.product.entity.Product;
import com.irfan.product.service.ProductService;

@RestController
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	@GetMapping("/")
	public String index() {

		return "Product API";
	}

	@GetMapping(value = "/products")
	public Product getProductByProductNo(@RequestParam int productNo) {
		Product product = productService.getProductByProductNo(productNo);

		return product;
	}

	@GetMapping(value = "/products/all")
	public List<Product> getProducts() {
		List<Product> products = productService.getProducts();

		LOGGER.info(products.toString());

		return products;
	}

	@PutMapping(value = "/products")
	public int updateProduct(@RequestBody Product request) {
		int isUpdated = productService.updateProduct(request);

		String msg = isUpdated > 0 ? "updated" : "not updated";
		LOGGER.info("product is " + msg);

		return isUpdated;
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		int isDeleted = productService.deleteProduct(id);

		String msg = isDeleted > 0 ? "successfully deleted" : "unable to delete";

		return msg;
	}
}
