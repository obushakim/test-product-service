package com.irfan.product.service;

import java.util.List;

import com.irfan.product.entity.Product;

public interface ProductService {

	public Product getProduct(int id);

	public List<Product> getProducts();

	public Product getProductByProductNo(int productNo);

	public int updateProduct(Product product);

	public int deleteProduct(int id);

}
