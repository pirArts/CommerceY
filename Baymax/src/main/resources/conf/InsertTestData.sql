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