USE `baymax`;

INSERT INTO `identity.USER`(DEVICE_ID, NAME, PASSWORD) VALUES ('aaaaa','Hao Yan','Hao Yan');

INSERT INTO product_category (name) VALUES ('java');
INSERT INTO product_category (name) VALUES ('c#');

INSERT INTO product (name, price, description, product_category_id) VALUES ('java maven', 200.0, 'java web dev', 1);
INSERT INTO product (name, price, description, product_category_id) VALUES ('java spring', 200.0, 'java web dev', 1);
INSERT INTO product (name, price, description, product_category_id) VALUES ('java mybatis', 200.0, 'java web dev', 1);
INSERT INTO product (name, price, description, product_category_id) VALUES ('java mvc', 200.0, 'java web dev', 1);
INSERT INTO product (name, price, description, product_category_id) VALUES ('java tomcat', 200.0, 'java web dev', 1);
INSERT INTO product (name, price, description, product_category_id) VALUES ('java struts', 200.0, 'java web dev', 1);
INSERT INTO product (name, price, description, product_category_id) VALUES ('java JDBC', 200.0, 'java web dev', 1);

INSERT INTO product (name, price, description, product_category_id) VALUES ('c# asp', 200.0, 'c# web dev', 2);
INSERT INTO product (name, price, description, product_category_id) VALUES ('c# asp.net', 200.0, 'c# web dev', 2);
INSERT INTO product (name, price, description, product_category_id) VALUES ('c# MVC', 200.0, 'c# web dev', 2);
INSERT INTO product (name, price, description, product_category_id) VALUES ('c# Razor', 200.0, 'c# web dev', 2);
INSERT INTO product (name, price, description, product_category_id) VALUES ('c# spark', 200.0, 'c# web dev', 2);
INSERT INTO product (name, price, description, product_category_id) VALUES ('c# .NET', 200.0, 'c# web dev', 2);
INSERT INTO product (name, price, description, product_category_id) VALUES ('c# WPF', 200.0, 'c# web dev', 2);

INSERT INTO customer_type (name) VALUES ('Admin');
INSERT INTO customer_type (name) VALUES ('Guest');

INSERT INTO customer (email, password, nickname,phone,address,gender,wechat_openid, customer_type_id) VALUES ('yhao880514@hotmail.com', '1', 'Hao', '111', 'streetA', 'M', '123456', 1);
INSERT INTO customer (email, password, nickname,phone,address,gender,wechat_openid, customer_type_id) VALUES ('yhao880514@gmail.com', '1', 'Hao', '111', 'streetA', 'M', '123456', 1);

INSERT INTO customer (email, password, nickname,phone,address,gender,wechat_openid, customer_type_id) VALUES ('yhao880514@126.com', '1', 'Yan', '111', 'streetA', 'M', '123456', 2);
INSERT INTO customer (email, password, nickname,phone,address,gender,wechat_openid, customer_type_id) VALUES ('yhao880514@163.com', '1', 'Yan', '111', 'streetA', 'M', '123456', 2);

INSERT INTO basket(amount, create_time, customer_id) VALUES(0, '2015-01-01', 1);

INSERT INTO basket_item(basket_id, product_id, quantity) VALUES (1,  1, 10);
INSERT INTO basket_item(basket_id, product_id, quantity) VALUES (1,  2, 3);
INSERT INTO basket_item(basket_id, product_id, quantity) VALUES (1,  3, 3);
INSERT INTO basket_item(basket_id, product_id, quantity) VALUES (1,  4, 3);
INSERT INTO basket_item(basket_id, product_id, quantity) VALUES (1,  5, 3);
INSERT INTO basket_item(basket_id, product_id, quantity) VALUES (1,  6, 3);

INSERT INTO order_state(name) VALUES ("opened");
INSERT INTO order_state(name) VALUES ("closed");

INSERT INTO payment_type(name) VALUES ("wechat");
INSERT INTO payment_type(name) VALUES ("paypal");
INSERT INTO payment_type(name) VALUES ("alipay");

INSERT INTO `order`(amount, create_time, payment_time, payment_result, customer_id, order_state_id, payment_type_id) VALUES (0,  '2015-01-01',  '2015-01-01', 0,  1,  1,  1);

INSERT INTO order_item(order_id, product_id, quantity) VALUES (1 ,1, 10);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (1 ,2, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (1 ,3, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (1 ,4, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (1 ,5, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (1 ,6, 3);

INSERT INTO `order`(amount, create_time, payment_time, payment_result, customer_id, order_state_id, payment_type_id) VALUES (0,  '2015-01-01',  '2015-01-01', 0,  1,  2,  2);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (2 ,1, 10);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (2 ,2, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (2 ,3, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (2 ,4, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (2 ,5, 3);
INSERT INTO order_item(order_id, product_id, quantity) VALUES (2 ,6, 3);