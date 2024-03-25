mysql: [Warning] C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe: ignoring option '--no-beep' due to invalid value ''.
Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 12
Server version: 8.0.19 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use EMPLOYEE;
Database changed
mysql> SHOW TABLES;
+--------------------+
| Tables_in_employee |
+--------------------+
| department         |
| employee           |
| orders             |
| products           |
+--------------------+
4 rows in set (0.32 sec)

mysql> DESC DEPARTMENT;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| DID       | varchar(30) | YES  |     | NULL    |       |
| DNAME     | varchar(30) | YES  |     | NULL    |       |
| DLOCATION | varchar(30) | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
3 rows in set (0.16 sec)

mysql> DESC ORDERS;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| orderid      | varchar(10) | YES  |     | NULL    |       |
| ordername    | varchar(30) | YES  |     | NULL    |       |
| costumerid   | varchar(10) | YES  |     | NULL    |       |
| costumername | varchar(30) | YES  |     | NULL    |       |
| oredrdate    | date        | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> DESC PRODUCTS;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| PRODUCTID   | varchar(10) | YES  |     | NULL    |       |
| PRODUCTNAME | varchar(30) | YES  |     | NULL    |       |
| ORDERID     | varchar(10) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> ALTER TABLE ORDERS ADD PRIMARY KEY(orderid);
Query OK, 0 rows affected (1.60 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> DESC ORDERS;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| orderid      | varchar(10) | NO   | PRI | NULL    |       |
| ordername    | varchar(30) | YES  |     | NULL    |       |
| costumerid   | varchar(10) | YES  |     | NULL    |       |
| costumername | varchar(30) | YES  |     | NULL    |       |
| oredrdate    | date        | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> ALTER TABLE PRODUCTS ADD PRIMARY KEY(PRODUCTID);
Query OK, 0 rows affected (0.99 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> DESC PRODUCTS;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| PRODUCTID   | varchar(10) | NO   | PRI | NULL    |       |
| PRODUCTNAME | varchar(30) | YES  |     | NULL    |       |
| ORDERID     | varchar(10) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> ALTER TABLE PRODUCTS ADD FORIEGN KEY(ORDERID),REFERENCES(ORDERS);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'KEY(ORDERID),REFERENCES(ORDERS)' at line 1
mysql> ALTER TABLE PRODUCTS ADD FORIEGN KEY(ORDERID),REFERENCES ORDERS(orderid);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'KEY(ORDERID),REFERENCES ORDERS(orderid)' at line 1
mysql> ALTER TABLE PRODUCTS ADD FOREIGN KEY(ORDERID),REFERENCES ORDERS(orderid);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ',REFERENCES ORDERS(orderid)' at line 1
mysql> ALTER TABLE PRODUCTS ADD FOREIGN KEY(ORDERID) REFERENCES ORDERS(orderid);
Query OK, 5 rows affected (1.34 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> DESC PRODUCTS;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| PRODUCTID   | varchar(10) | NO   | PRI | NULL    |       |
| PRODUCTNAME | varchar(30) | YES  |     | NULL    |       |
| ORDERID     | varchar(10) | YES  | MUL | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.orderid=PRODUCTS.PRODUCTID;
Empty set (0.00 sec)

mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.orderid=PRODUCTS.ORDERID;
+---------+-----------+-------------+
| orderid | PRODUCTID | PRODUCTNAME |
+---------+-----------+-------------+
| CAD1    | ABC1      | POWDER      |
| CAD3    | ABC2      | SUNSCREEN   |
| CAD5    | ABC3      | BAG         |
| CAD7    | ABC4      | MOISTURIZER |
| CAD9    | ABC5      | RANIYA      |
+---------+-----------+-------------+
5 rows in set (0.00 sec)

mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.primary key=PRODUCTS.foreign key;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'key=PRODUCTS.foreign key' at line 1
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'where clause'
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary key=PRODUCTS.foreign key;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'key=PRODUCTS.foreign key' at line 1
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql> SELECT *  FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql> SELECT *  FROM ORDERS  JOIN PRODUCTS ON [ORDERS.primary_key]=[PRODUCTS.foreign_key];
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '[ORDERS.primary_key]=[PRODUCTS.foreign_key]' at line 1
mysql> SELECT *  FROM [ORDERS]  JOIN [PRODUCTS] ON [ORDERS.primary_key]=[PRODUCTS.foreign_key];
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '[ORDERS]  JOIN [PRODUCTS] ON [ORDERS.primary_key]=[PRODUCTS.foreign_key]' at line 1
mysql> SELECT *  FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql>mysql: [Warning] C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe: ignoring option '--no-beep' due to invalid value ''.
Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 12
Server version: 8.0.19 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use EMPLOYEE;
Database changed
mysql> SHOW TABLES;
+--------------------+
| Tables_in_employee |
+--------------------+
| department         |
| employee           |
| orders             |
| products           |
+--------------------+
4 rows in set (0.32 sec)

mysql> DESC DEPARTMENT;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| DID       | varchar(30) | YES  |     | NULL    |       |
| DNAME     | varchar(30) | YES  |     | NULL    |       |
| DLOCATION | varchar(30) | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
3 rows in set (0.16 sec)

mysql> DESC ORDERS;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| orderid      | varchar(10) | YES  |     | NULL    |       |
| ordername    | varchar(30) | YES  |     | NULL    |       |
| costumerid   | varchar(10) | YES  |     | NULL    |       |
| costumername | varchar(30) | YES  |     | NULL    |       |
| oredrdate    | date        | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> DESC PRODUCTS;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| PRODUCTID   | varchar(10) | YES  |     | NULL    |       |
| PRODUCTNAME | varchar(30) | YES  |     | NULL    |       |
| ORDERID     | varchar(10) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> ALTER TABLE ORDERS ADD PRIMARY KEY(orderid);
Query OK, 0 rows affected (1.60 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> DESC ORDERS;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| orderid      | varchar(10) | NO   | PRI | NULL    |       |
| ordername    | varchar(30) | YES  |     | NULL    |       |
| costumerid   | varchar(10) | YES  |     | NULL    |       |
| costumername | varchar(30) | YES  |     | NULL    |       |
| oredrdate    | date        | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> ALTER TABLE PRODUCTS ADD PRIMARY KEY(PRODUCTID);
Query OK, 0 rows affected (0.99 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> DESC PRODUCTS;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| PRODUCTID   | varchar(10) | NO   | PRI | NULL    |       |
| PRODUCTNAME | varchar(30) | YES  |     | NULL    |       |
| ORDERID     | varchar(10) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> ALTER TABLE PRODUCTS ADD FORIEGN KEY(ORDERID),REFERENCES(ORDERS);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'KEY(ORDERID),REFERENCES(ORDERS)' at line 1
mysql> ALTER TABLE PRODUCTS ADD FORIEGN KEY(ORDERID),REFERENCES ORDERS(orderid);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'KEY(ORDERID),REFERENCES ORDERS(orderid)' at line 1
mysql> ALTER TABLE PRODUCTS ADD FOREIGN KEY(ORDERID),REFERENCES ORDERS(orderid);
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ',REFERENCES ORDERS(orderid)' at line 1
mysql> ALTER TABLE PRODUCTS ADD FOREIGN KEY(ORDERID) REFERENCES ORDERS(orderid);
Query OK, 5 rows affected (1.34 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> DESC PRODUCTS;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| PRODUCTID   | varchar(10) | NO   | PRI | NULL    |       |
| PRODUCTNAME | varchar(30) | YES  |     | NULL    |       |
| ORDERID     | varchar(10) | YES  | MUL | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.orderid=PRODUCTS.PRODUCTID;
Empty set (0.00 sec)

mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.orderid=PRODUCTS.ORDERID;
+---------+-----------+-------------+
| orderid | PRODUCTID | PRODUCTNAME |
+---------+-----------+-------------+
| CAD1    | ABC1      | POWDER      |
| CAD3    | ABC2      | SUNSCREEN   |
| CAD5    | ABC3      | BAG         |
| CAD7    | ABC4      | MOISTURIZER |
| CAD9    | ABC5      | RANIYA      |
+---------+-----------+-------------+
5 rows in set (0.00 sec)

mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.primary key=PRODUCTS.foreign key;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'key=PRODUCTS.foreign key' at line 1
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS WHERE ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'where clause'
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary key=PRODUCTS.foreign key;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'key=PRODUCTS.foreign key' at line 1
mysql> SELECT ORDERS.orderid,PRODUCTS.PRODUCTID,PRODUCTS.PRODUCTNAME FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql> SELECT *  FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql> SELECT *  FROM ORDERS  JOIN PRODUCTS ON [ORDERS.primary_key]=[PRODUCTS.foreign_key];
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '[ORDERS.primary_key]=[PRODUCTS.foreign_key]' at line 1
mysql> SELECT *  FROM [ORDERS]  JOIN [PRODUCTS] ON [ORDERS.primary_key]=[PRODUCTS.foreign_key];
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '[ORDERS]  JOIN [PRODUCTS] ON [ORDERS.primary_key]=[PRODUCTS.foreign_key]' at line 1
mysql> SELECT *  FROM ORDERS  JOIN PRODUCTS ON ORDERS.primary_key=PRODUCTS.foreign_key;
ERROR 1054 (42S22): Unknown column 'ORDERS.primary_key' in 'on clause'
mysql>
