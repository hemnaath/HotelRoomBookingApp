--
create table guest_details(
id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 101 primary key,
firstname varchar2(100) not null,
lastname varchar2(100) not null,
email varchar2(100) unique,   
password varchar2(100) not null,
mobile number(10) not null
);

select * from guest_details;
truncate table guest;
drop table guest;

-----------------------------------------------------------
create table reservation_details(
id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1001 primary key,
check_in date not null,
check_out date not null,
made_by varchar2(100) not null,
booking varchar2(100) not null,
category varchar2(100) NOT null,
location varchar2(100) not null,
guest_id int not null,
foreign key (guest_id) references guest_details (id)
);

drop table reservation_details CASCADE CONSTRAINTS;
select * from reservation_details;
truncate table reservation_details;

-------------------------------------------------------------------





--


--
create table payment(
id int primary key,
mode_of_payment varchar2(100),
date_of_pay varchar2(100),
guest_id int,
foreign key (guest_id) references guest (id)
);

--

-----------------------------------------------------------------------
create table hoteladmin(
id int GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
email varchar2(100) unique,
password varchar2(100) not null
);



select * from hoteladmin;
insert into hoteladmin(email,password) values('admin@tstays.com','web123');

insert into admin values(1,'admin@tstays.com','web123');

