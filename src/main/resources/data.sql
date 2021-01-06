DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  product_no int NOT NULL,
  name VARCHAR(100) NOT NULL,
  qty int DEFAULT NULL,
  price DECIMAL(19,4) NOT NULL,
  created_date DATETIME DEFAULT NOT NULL,
  modified_date DATETIME DEFAULT NOT NULL
);

INSERT INTO product (product_no, name, qty, price, created_date, modified_date) VALUES
  (100001, 'Layar Monitor', 10, 1000.5, '2020-12-24 00:00:00', '2020-12-24 04:03:00'),
  (100002, 'Keyboard', 10, 500, '2020-12-24 00:00:00', '2020-12-24 04:03:00');