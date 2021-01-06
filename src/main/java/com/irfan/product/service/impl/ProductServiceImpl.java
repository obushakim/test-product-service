package com.irfan.product.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfan.product.dao.ProductDAO;
import com.irfan.product.entity.Product;
import com.irfan.product.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDAO productDAO;

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product product = productDAO.findById(id);

		return product;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.findAll();

		return products;
	}

	@Override
	public Product getProductByProductNo(int productNo) {
		// TODO Auto-generated method stub
		Product product = new Product();

		try {
			product = productDAO.findByProductNo(productNo);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
		}

		return product;
	}

	@Override
	public int updateProduct(Product params) {
		try {
			Product product = productDAO.findByProductNo(params.getProductNo());

			int subtractedQty = product.getQty() - params.getQty();

			productDAO.updateProduct(subtractedQty, params.getProductNo());

			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return 0;
		}
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		int isDeleted = productDAO.deleteProduct(id);

		return isDeleted;
	}
}
