DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  product_no int NOT NULL,
  name VARCHAR(100) NOT NULL,
  qty int DEFAULT NULL,
  price DECIMAL(19,4) NOT NULL
);

INSERT INTO product (product_no, name, qty, price) VALUES
  (100001, 'Layar Monitor', 10, 1000.5),
  (100002, 'Keyboard', 10, 500);