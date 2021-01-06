package com.irfan.product.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irfan.product.entity.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
	public Product findById(int id);

	@Query(value = "SELECT * FROM product WHERE product_no = ?1", nativeQuery = true)
	public Product findByProductNo(int productNo);

	@Query(value = "SELECT * FROM product", nativeQuery = true)
	public List<Product> findAll();

	@Transactional
	@Modifying
	@Query(value = "UPDATE product SET qty = :qty WHERE product_no = :productNo", nativeQuery = true)
	public void updateProduct(@Param("qty") int qty, @Param("productNo") int productNo);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM product WHERE id = ?1", nativeQuery = true)
	public int deleteProduct(int id);
}
