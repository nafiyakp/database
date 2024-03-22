Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 7
Server version: 5.7.37-log MySQL Community Server (GPL)

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use samples;
Database changed
mysql> select * from embloyee;
+------+---------+------------+------------------+------------------+-----------+
| SSN  | name    | department | project_name     | project_location | salary    |
+------+---------+------------+------------------+------------------+-----------+
| 111A | najiya  | sales      | vechicle control | kochi            |  70000.00 |
| 111C | ajisa   | HR         | devolopment      | banglore         | 670000.00 |
| 111D | akash   | finance    | AI               | kollam           |  70000.00 |
| 111E | hari    | research   | huamn welfare    | kozhikode        | 480000.00 |
| 111f | fida    | finance    | medical system   | delhi            |  70000.00 |
| 111g | sareena | finance    | system control   | hyderabad        |  30000.00 |
| 111k | hariz   | sales      | devolopment      | chennai          |  70000.00 |
| 111L | nafiya  | marketing  | solar ststem     | Delhi            |  90000.00 |
| 111o | fazin   | finance    | devolopment      | calicut          |  50000.00 |
| 111z | meera   | trading    | auto atlas       | kannur           |  60000.00 |
+------+---------+------------+------------------+------------------+-----------+
10 rows in set (0.11 sec)

mysql> select * from department;
+------+------------+---------------+
| SSN  | dept_name  | dept_location |
+------+------------+---------------+
| 111  | sales      | calicut       |
| 112  | production | mumbai        |
| 113  | HR         | kollam        |
| 114  | marketing  | banglore      |
| 115  | sales      | kochi         |
| 116  | trading    | goa           |
| 117  | finance    | chennai       |
| 118  | sales      | thrissur      |
| 119  | research   | kannur        |
| 120  | trading    | thrissur      |
+------+------------+---------------+
10 rows in set (0.04 sec)

mysql> alter table department add primary key(SSN);
Query OK, 0 rows affected (0.68 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc department;
+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| SSN           | varchar(10) | NO   | PRI | NULL    |       |
| dept_name     | varchar(20) | YES  |     | NULL    |       |
| dept_location | varchar(30) | YES  |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+
3 rows in set (0.13 sec)
mysql> create table orders(order_id varchar(10),order_name varchar(20),customer_id varchar(10),customer_name varchar(20),order_date date,primary key(order_id));
Query OK, 0 rows affected (0.41 sec)
mysql> insert into orders  values("101","11A","neha",'2023/12/1');
Query OK, 1 row affected (0.05 sec)

mysql> insert into orders  values("102","11B","najisa",'2024/11/20');
Query OK, 1 row affected (0.04 sec)

mysql> insert into orders  values("102","11B","hari",'2022/11/20');
ERROR 1062 (23000): Duplicate entry '102' for key 'PRIMARY'
mysql> insert into orders  values("103","11B","hari",'2022/11/20');
Query OK, 1 row affected (0.04 sec)

mysql> insert into orders  values("104","11C","hariZ",'2021/14/18');
ERROR 1292 (22007): Incorrect date value: '2021/14/18' for column 'order_date' at row 1
mysql> insert into orders  values("104","11C","hariZ",'2021/7/18');
Query OK, 1 row affected (0.04 sec)

mysql> insert into orders  values("104","11D","anagha",'2020/17/16');;
ERROR 1292 (22007): Incorrect date value: '2020/17/16' for column 'order_date' at row 1
ERROR:
No query specified

mysql> insert into orders  values("104","11D","anagha",'2020/6/16');;
ERROR 1062 (23000): Duplicate entry '104' for key 'PRIMARY'
ERROR:
No query specified

mysql> update orders set order_id='104' where name='hariZ';
ERROR 1054 (42S22): Unknown column 'name' in 'where clause'
mysql> update orders set order_id='104' where customer_name='hariZ';
Query OK, 0 rows affected (0.00 sec)
Rows matched: 1  Changed: 0  Warnings: 0

mysql> update orders set order_id='103' where customer_name='hariZ';
ERROR 1062 (23000): Duplicate entry '103' for key 'PRIMARY'
mysql> insert into orders  values("104","11D","anagha",'2020/6/16');;
ERROR 1062 (23000): Duplicate entry '104' for key 'PRIMARY'
ERROR:
No query specified

mysql> insert into orders  values("105","11E","ajisa",'2020/4/16');
Query OK, 1 row affected (0.03 sec)

mysql> insert into orders  values("106","11F","anu",'2020/5/03');
Query OK, 1 row affected (0.06 sec)

mysql> select * from orders;
+----------+-------------+---------------+------------+
| order_id | customer_id | customer_name | order_date |
+----------+-------------+---------------+------------+
| 101      | 11A         | neha          | 2023-12-01 |
| 102      | 11B         | najisa        | 2024-11-20 |
| 103      | 11B         | hari          | 2022-11-20 |
| 104      | 11C         | hariZ         | 2021-07-18 |
| 105      | 11E         | ajisa         | 2020-04-16 |
| 106      | 11F         | anu           | 2020-05-03 |
+----------+-------------+---------------+------------+
6 rows in set (0.00 sec)

mysql> update orders set customer_id='11C' where customer_name='hari';
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update orders set customer_id='11D' ,customer_name='hariz' where ordr_id=104 ;
ERROR 1054 (42S22): Unknown column 'ordr_id' in 'where clause'
mysql> update orders set customer_id='11D' ,customer_name='hariz' where order_id=104 ;
Query OK, 1 row affected (0.07 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from orders;
+----------+-------------+---------------+------------+
| order_id | customer_id | customer_name | order_date |
+----------+-------------+---------------+------------+
| 101      | 11A         | neha          | 2023-12-01 |
| 102      | 11B         | najisa        | 2024-11-20 |
| 103      | 11C         | hari          | 2022-11-20 |
| 104      | 11D         | hariz         | 2021-07-18 |
| 105      | 11E         | ajisa         | 2020-04-16 |
| 106      | 11F         | anu           | 2020-05-03 |
+----------+-------------+---------------+------------+
6 rows in set (0.00 sec)

mysql> create table product (product_id varchar(10),product_name varchar(10),order_id varchar(10));
Query OK, 0 rows affected (0.32 sec)

mysql> insert into product values("111","watch","102");
Query OK, 1 row affected (0.03 sec)

mysql> insert into product values("112","ring","103");
Query OK, 1 row affected (0.04 sec)

mysql> insert into product values("113","cloths","104");
Query OK, 1 row affected (0.06 sec)

mysql> insert into product values("114","clock","104");
Query OK, 1 row affected (0.03 sec)

mysql> insert into product values("115","calculator","105");
Query OK, 1 row affected (0.05 sec)

mysql> select * from product;
+------------+--------------+----------+
| product_id | product_name | order_id |
+------------+--------------+----------+
| 111        | watch        | 102      |
| 112        | ring         | 103      |
| 113        | cloths       | 104      |
| 114        | clock        | 104      |
| 115        | calculator   | 105      |
+------------+--------------+----------+
5 rows in set (0.00 sec)

mysql> update  product set order_id="106" where product_name="calculator";
Query OK, 1 row affected (0.06 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update  product set order_id="105" where product_name="clock";
Query OK, 1 row affected (0.03 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from product;
+------------+--------------+----------+
| product_id | product_name | order_id |
+------------+--------------+----------+
| 111        | watch        | 102      |
| 112        | ring         | 103      |
| 113        | cloths       | 104      |
| 114        | clock        | 105      |
| 115        | calculator   | 106      |
+------------+--------------+----------+
5 rows in set (0.00 sec)

mysql>

mysql> select orders.order_id,orders.customer_id,orders.customer_name,orders.order_date,product.product_id,product.product_name,product.order_id  from  orders  join product orders.order_id=product.order_id
    -> select orders.order_id,orders.customer_id,orders.customer_name,orders.order_date,product.product_id,product.product_name,product.order_id  from  orders  join product orders.order_id=product.order_id;
ERROR 1066 (42000): Not unique table/alias: 'orders'
mysql> select * from product;
+------------+--------------+----------+
| product_id | product_name | order_id |
+------------+--------------+----------+
| 111        | watch        | 101      |
| 112        | ring         | 102      |
| 113        | cloths       | 103      |
| 114        | clock        | 104      |
| 115        | calculator   | 105      |
+------------+--------------+----------+
5 rows in set (0.00 sec)

mysql> insert into product values("116","earings","106");
Query OK, 1 row affected (0.04 sec)

mysql> select * from product;
+------------+--------------+----------+
| product_id | product_name | order_id |
+------------+--------------+----------+
| 111        | watch        | 101      |
| 112        | ring         | 102      |
| 113        | cloths       | 103      |
| 114        | clock        | 104      |
| 115        | calculator   | 105      |
| 116        | earings      | 106      |
+------------+--------------+----------+
6 rows in set (0.00 sec)

mysql> select orders.order_id,orders.customer_id,orders.customer_name,orders.order_date,product.product_id,product.product_name,product.order_id  from  orders  join product orders.order_id=product.order_id;
ERROR 1066 (42000): Not unique table/alias: 'orders'
mysql> select orders.order_id,orders.customer_id,orders.customer_name,orders.order_date,product.product_id,product.product_name,product.order_id  from  orders  join product orders.order_id=product.order_id;

