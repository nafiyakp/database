mysql> use embloyee
Database changed
mysql> select * from embloyee
    -> select * from embloyee;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'select * from embloyee' at line 2
mysql> use sample;
Database changed
mysql> select * from embloyee;
ERROR 1146 (42S02): Table 'sample.embloyee' doesn't exist
mysql> use embloyee;
Database changed
mysql> select * from embloyee;
ERROR 1146 (42S02): Table 'embloyee.embloyee' doesn't exist
mysql> use samples;
Database changed
mysql> select * from embloyee;
+------+---------+------------+------------------+------------------+
| SSN  | name    | department | project_name     | project_location |
+------+---------+------------+------------------+------------------+
| 111A | najiya  | sales      | vechicle control | kochi            |
| 111L | nafiya  | marketing  | solar ststem     | Delhi            |
| 111C | ajisa   | HR         | devolopment      | banglore         |
| 111D | akash   | finance    | AI               | kollam           |
| 111E | hari    | research   | huamn welfare    | kozhikode        |
| 111f | fida    | finance    | medical system   | delhi            |
| 111o | fazin   | finance    | devolopment      | calicut          |
| 111z | meera   | trading    | auto atlas       | kannur           |
| 111g | sareena | finance    | system control   | hyderabad        |
| 111f | hariz   | sales      | devolopment      | chennai          |
+------+---------+------------+------------------+------------------+
10 rows in set (0.01 sec)

mysql> select * from embloyee where department='finance' and project_location='kollam';
+------+-------+------------+--------------+------------------+
| SSN  | name  | department | project_name | project_location |
+------+-------+------------+--------------+------------------+
| 111D | akash | finance    | AI           | kollam           |
+------+-------+------------+--------------+------------------+
1 row in set (0.00 sec)

mysql> select * from embloyee where department='HR' or  project_name='devolopment';
+------+-------+------------+--------------+------------------+
| SSN  | name  | department | project_name | project_location |
+------+-------+------------+--------------+------------------+
| 111C | ajisa | HR         | devolopment  | banglore         |
| 111o | fazin | finance    | devolopment  | calicut          |
| 111f | hariz | sales      | devolopment  | chennai          |
+------+-------+------------+--------------+------------------+
3 rows in set (0.00 sec)

mysql> alter table embloyee add salary float(10,2);
Query OK, 0 rows affected (0.58 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select * from embloyee;
+------+---------+------------+------------------+------------------+--------+
| SSN  | name    | department | project_name     | project_location | salary |
+------+---------+------------+------------------+------------------+--------+
| 111A | najiya  | sales      | vechicle control | kochi            |   NULL |
| 111L | nafiya  | marketing  | solar ststem     | Delhi            |   NULL |
| 111C | ajisa   | HR         | devolopment      | banglore         |   NULL |
| 111D | akash   | finance    | AI               | kollam           |   NULL |
| 111E | hari    | research   | huamn welfare    | kozhikode        |   NULL |
| 111f | fida    | finance    | medical system   | delhi            |   NULL |
| 111o | fazin   | finance    | devolopment      | calicut          |   NULL |
| 111z | meera   | trading    | auto atlas       | kannur           |   NULL |
| 111g | sareena | finance    | system control   | hyderabad        |   NULL |
| 111f | hariz   | sales      | devolopment      | chennai          |   NULL |
+------+---------+------------+------------------+------------------+--------+
10 rows in set (0.00 sec)

mysql> update embloyee  salary='70000' whwere SSN='111A';
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '='70000' whwere SSN='111A'' at line 1
mysql> update embloyee  salary='70000' where SSN='111A';
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '='70000' where SSN='111A'' at line 1
mysql> update embloyee  salary='70000' where SSN=111A;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '='70000' where SSN=111A' at line 1
mysql> update embloyee set  salary='70000' where SSN=111A;
ERROR 1054 (42S22): Unknown column '111A' in 'where clause'
mysql> update embloyee set  salary='70000' where SSN='111A';
Query OK, 1 row affected (0.12 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='90000' where SSN='111L';
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='670000' where SSN='111C';
Query OK, 1 row affected (0.03 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='70000' where SSN='111D';
Query OK, 1 row affected (0.11 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='480000' where SSN='111E';
Query OK, 1 row affected (0.09 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='900000' where SSN='111f';
Query OK, 2 rows affected (0.05 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> update embloyee set  salary='50000' where SSN='111o';
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='60000' where SSN='111z';
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='30000' where SSN='111g';
Query OK, 1 row affected (0.03 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update embloyee set  salary='70000' where SSN='111f';
Query OK, 2 rows affected (0.11 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> select * from embloyee;
+------+---------+------------+------------------+------------------+-----------+
| SSN  | name    | department | project_name     | project_location | salary    |
+------+---------+------------+------------------+------------------+-----------+
| 111A | najiya  | sales      | vechicle control | kochi            |  70000.00 |
| 111L | nafiya  | marketing  | solar ststem     | Delhi            |  90000.00 |
| 111C | ajisa   | HR         | devolopment      | banglore         | 670000.00 |
| 111D | akash   | finance    | AI               | kollam           |  70000.00 |
| 111E | hari    | research   | huamn welfare    | kozhikode        | 480000.00 |
| 111f | fida    | finance    | medical system   | delhi            |  70000.00 |
| 111o | fazin   | finance    | devolopment      | calicut          |  50000.00 |
| 111z | meera   | trading    | auto atlas       | kannur           |  60000.00 |
| 111g | sareena | finance    | system control   | hyderabad        |  30000.00 |
| 111f | hariz   | sales      | devolopment      | chennai          |  70000.00 |
+------+---------+------------+------------------+------------------+-----------+
10 rows in set (0.00 sec)

mysql> select  salary from embloyee where salary between 10000 and 40000;
+----------+
| salary   |
+----------+
| 30000.00 |
+----------+
1 row in set (0.00 sec)

mysql> select  department from  embloyee where department in('HR','production','finance');
+------------+
| department |
+------------+
| HR         |
| finance    |
| finance    |
| finance    |
| finance    |
+------------+
5 rows in set (0.00 sec)

mysql> select  department from  embloyee where department not in('HR','production','finance');
+------------+
| department |
+------------+
| sales      |
| marketing  |
| research   |
| trading    |
| sales      |
+------------+
5 rows in set (0.00 sec)

mysql> select * department from  embloyee where department not in('HR','production','finance');
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'department from  embloyee where department not in('HR','production','finance')' at line 1
mysql> select *  from  embloyee where department not in('HR','production','finance');
+------+--------+------------+------------------+------------------+-----------+
| SSN  | name   | department | project_name     | project_location | salary    |
+------+--------+------------+------------------+------------------+-----------+
| 111A | najiya | sales      | vechicle control | kochi            |  70000.00 |
| 111L | nafiya | marketing  | solar ststem     | Delhi            |  90000.00 |
| 111E | hari   | research   | huamn welfare    | kozhikode        | 480000.00 |
| 111z | meera  | trading    | auto atlas       | kannur           |  60000.00 |
| 111f | hariz  | sales      | devolopment      | chennai          |  70000.00 |
+------+--------+------------+------------------+------------------+-----------+
5 rows in set (0.00 sec)

mysql> select department from embloyee where  SSN='111A' group by department ordered by department;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'ordered by department' at line 1
mysql> select department from embloyee where  SSN='111A' group by department order by department;
+------------+
| department |
+------------+
| sales      |
+------------+
1 row in set (0.00 sec)

mysql> select department from embloyee where  group by department order by department;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'group by department order by department' at line 1
mysql> select  count(department) from embloyee where group by department;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'group by department' at line 1
mysql> select  count(department) from embloyee  group by department;
+-------------------+
| count(department) |
+-------------------+
|                 4 |
|                 1 |
|                 1 |
|                 1 |
|                 2 |
|                 1 |
+-------------------+
6 rows in set (0.00 sec)

mysql> select  count(department) from embloyee  group by department order by department;
+-------------------+
| count(department) |
+-------------------+
|                 4 |
|                 1 |
|                 1 |
|                 1 |
|                 2 |
|                 1 |
+-------------------+
6 rows in set (0.00 sec)

mysql> select  count(department) from embloyee   order by department;
+-------------------+
| count(department) |
+-------------------+
|                10 |
+-------------------+
1 row in set (0.00 sec)

mysql> alter table  embloyee  add primary key(SSN);
ERROR 1062 (23000): Duplicate entry '111f' for key 'PRIMARY'
mysql> update embloyee set SSN='111f' where name='hariz';
Query OK, 0 rows affected (0.05 sec)
Rows matched: 1  Changed: 0  Warnings: 0

mysql> alter table  embloyee  add primary key(SSN);
ERROR 1062 (23000): Duplicate entry '111f' for key 'PRIMARY'
mysql> update embloyee set SSN='111k' where name='hariz';
Query OK, 1 row affected (0.06 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> alter table  embloyee  add primary key(SSN);
Query OK, 0 rows affected (0.89 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc embloyee;
+------------------+-------------+------+-----+---------+-------+
| Field            | Type        | Null | Key | Default | Extra |
+------------------+-------------+------+-----+---------+-------+
| SSN              | varchar(10) | NO   | PRI | NULL    |       |
| name             | varchar(10) | YES  |     | NULL    |       |
| department       | varchar(10) | YES  |     | NULL    |       |
| project_name     | varchar(20) | YES  |     | NULL    |       |
| project_location | varchar(20) | YES  |     | NULL    |       |
| salary           | float(10,2) | YES  |     | NULL    |       |
+------------------+-------------+------+-----+---------+-------+
6 rows in set (0.05 sec)

mysql> alter table  embloyee  drop primary key;
Query OK, 10 rows affected (1.08 sec)
Records: 10  Duplicates: 0  Warnings: 0

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
10 rows in set (0.00 sec)

mysql> desc embloyee;
+------------------+-------------+------+-----+---------+-------+
| Field            | Type        | Null | Key | Default | Extra |
+------------------+-------------+------+-----+---------+-------+
| SSN              | varchar(10) | NO   |     | NULL    |       |
| name             | varchar(10) | YES  |     | NULL    |       |
| department       | varchar(10) | YES  |     | NULL    |       |
| project_name     | varchar(20) | YES  |     | NULL    |       |
| project_location | varchar(20) | YES  |     | NULL    |       |
| salary           | float(10,2) | YES  |     | NULL    |       |
+------------------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

mysql>
