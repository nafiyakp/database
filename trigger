mysql> select * from phonebook;
    -> //
+--------+-----------+
| pname  | mobilno   |
+--------+-----------+
| kavya  | 123344444 |
| anagha | 123890    |
+--------+-----------+
2 rows in set (0.00 sec)

mysql> select * from delphonebook;
    -> //
+-------+----------+--------------+
| pname | mobileno | modifieddate |
+-------+----------+--------------+
| ajisa | 88890    | 2024-07-10   |
+-------+----------+--------------+
1 row in set (0.00 sec)

mysql> DELIMITER //
mysql> create trigger triggers after update on phonebook for each row
    -> begin
    -> insert into delphonebook (pname,mobileno,modifieddate) values(old.pname,old.mobilno,sysdate());
    -> end
    -> //
mysql> create trigger triggerss after update on phonebook for each row
    ->  begin
    -> insert into delphonebook (pname,mobileno,modifieddate) values(old.pname,old.mobilno,sysdate());
    ->  end
    ->  //
Query OK, 0 rows affected (0.02 sec)

mysql> update phonebook set name="femin" where name="kavya";
    -> //
ERROR 1054 (42S22): Unknown column 'name' in 'where clause'
mysql> update phonebook set pname="femin" where pname="kavya";
    -> //
Query OK, 1 row affected (0.04 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from phonebook;
    -> //
+--------+-----------+
| pname  | mobilno   |
+--------+-----------+
| femin  | 123344444 |
| anagha | 123890    |
+--------+-----------+
2 rows in set (0.00 sec)
