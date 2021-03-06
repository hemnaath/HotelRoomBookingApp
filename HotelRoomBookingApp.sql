create table guest_details(
id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 101 primary key,
firstname varchar2(100) not null,
lastname varchar2(100) not null,
email varchar2(100) unique,   
password varchar2(100) not null,
mobile number(10) not null
);

create table room_details
(
room_number int primary key,
status varchar2(100) default 'vacant',
category varchar2(100),
location varchar2(100),
price number(10)
);

insert into room_details(room_number,category,location,price) values(1000,'premium','chennai',8000);
insert into room_details(room_number,category,location,price) values(1001,'premium','chennai',8000);
insert into room_details(room_number,category,location,price) values(1002,'luxury','chennai',6000);
insert into room_details(room_number,category,location,price) values(1003,'luxury','chennai',6000);
insert into room_details(room_number,category,location,price) values(1004,'standard','chennai',4000);
insert into room_details(room_number,category,location,price) values(1005,'standard','chennai',4000);
insert into room_details(room_number,category,location,price) values(1006,'budget','chennai',2000);
insert into room_details(room_number,category,location,price) values(1007,'budget','chennai',2000);

create table wedding_hall_details
(
wedding_hall_number int primary key,
status varchar2(100) default 'vacant',
category varchar2(100),
location varchar2(100),
price number(10)
);

insert into wedding_hall_details(wedding_hall_number,category,location,price) values(2000,'premium','chennai',100000);
insert into wedding_hall_details(wedding_hall_number,category,location,price) values(2001,'luxury','chennai',80000);
insert into wedding_hall_details(wedding_hall_number,category,location,price) values(2002,'standard','chennai',60000);
insert into wedding_hall_details(wedding_hall_number,category,location,price) values(2003,'budget','chennai',40000);

create table meeting_hall_details
(
meeting_hall_number int primary key,
status varchar2(100) default 'vacant',
category varchar2(100),
location varchar2(100),
price number(10)
);

insert into meeting_hall_details(meeting_hall_number,category,location,price) values(3000,'premium','chennai',4000);
insert into meeting_hall_details(meeting_hall_number,category,location,price) values(3001,'luxury','chennai',3000);
insert into meeting_hall_details(meeting_hall_number,category,location,price) values(3002,'standard','chennai',2000);
insert into meeting_hall_details(meeting_hall_number,category,location,price) values(3003,'budget','chennai',1000);

create table room_transaction
(
room_number int,
check_in date,
check_out date,
category varchar2(100),
location varchar2(100),
guest_id int,
foreign key (guest_id) references guest_details(id)
);

create table wedding_hall_transaction
(
wedding_hall_number int,
check_in date,
check_out date,
category varchar2(100),
location varchar2(100),
guest_id int,
foreign key (guest_id) references guest_details(id)
);

create table meeting_hall_transaction
(
meeting_hall_number int,
check_in date,
check_out date,
category varchar2(100),
location varchar2(100),
guest_id int,
foreign key (guest_id) references guest_details(id)
);

create table payment_details(
id int primary key,
card_number number(16),
guest_id int,
foreign key (guest_id) references guest_details (id)
);

desc hotel_payments;

create table admin
(
id int GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
email varchar2(100) unique,
password varchar2(100) not null
);

insert into admin(email,password) values('admin@tstays.com','web123');



select * from guest_details;
select * from room_details;
select * from wedding_hall_details;
select * from meeting_hall_details;
select * from room_transaction;
select * from wedding_hall_transaction;
select * from meeting_hall_transaction;
select * from admin;
select * from payment;

truncate table room_transaction;
truncate table wedding_hall_transaction;
truncate table meeting_hall_transaction;


commit;


