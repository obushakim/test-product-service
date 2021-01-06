package com.irfan.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "PRODUCT_NO", nullable = false)
	private int productNo;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "qty", nullable = false)
	private int qty;

	@Column(name = "price", nullable = false)
	private double price;
}
