CONNECT demo / AS SYSDBA
CREATE USER BANK IDENTIFIED BY "bank"
DEFAULT TABLESPACE USERS;
GRANT ALL PRIVILEGES TO bank;
CONNECT bank/bank
create table customers(
NUM varchar(10) constraint MEMBER_ID_NN not null,
NAME varchar(50),
PIN varchar(4),
EMAIL varchar(100),
constraint Customer_PK primary key(NUM));
desc customers;
INSERT INTO customers VALUES (12345, 'Alireza', 1236,'kasragholami47@yahoo.com');
INSERT INTO customers VALUES (12346, 'Zahara', 8954,'zahra.soltani@gamil.com');
INSERT INTO customers VALUES (12347, 'Emie', 4521,'Emmmie@gmail.com');
INSERT INTO customers VALUES (12348, 'valery', 8723,'valery.cohan@yahoo.com');
commit;
column NUM format a10;
column NAME format a20;
column PIN format a4;
column EMAIL format a30;
select * from customers;

