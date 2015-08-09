# CommerceY
Our New project 

1. mysql -u root -p
2. in mysql console
	2.1 source PathToCommerceY/CommerceY/Baymax/src/main/resources/conf/CreateDataBaseAndTable.sql;
	2.2 source PathToCommerceY/CommerceY/Baymax/src/main/resources/conf/InsertTestData.sql;
	2.3 quit;
3. cd PathToCommerceY/CommerceY/Baymax
1. mvn package -e -X
2. mvn tomcat7:run -e -X
3. http://localhost:8080/baymax/heartbeat
4. http://localhost:8080/baymax/catalog, http://localhost:8080/baymax/cart, http://localhost:8080/baymax/order
