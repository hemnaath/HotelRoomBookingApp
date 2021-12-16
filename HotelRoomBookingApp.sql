--
create table guest_details(
id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 101 primary key,
firstname varchar2(100) not null,
lastname varchar2(100) not null,
email varchar2(100) unique,   
password varchar2(100) not null,
mobile number(10) not null
);

select * from guest;
truncate table guest;
drop table guest;
--
--/*--
create table reservation_details(
id int primary key,
check_in varchar2(100) not null,
chech_out varchar2(100) not null,
made_by varchar2(100) not null,
booking varchar2(100) not null,
category varchar2(100) NOT null,
location varchar2(100) not null,
guest_id int not null,
foreign key (guest_id) references guest (id)
);
--
--/*--
create table room_details(
id int primary key,
total_rooms int not null,
availible int not null,
reservation_details_id int not null,
foreign key (reservation_details_id) references reservation_details (id)
);

--
--/*--
create table occupied_rooms(
id int primary key,
check_in varchar2(100) not null,
check_out varchar2(100) not null,
room_number int not null,
room_id int not null,
reservation_details_id int not null,
foreign key (room_id) references room (id),
foreign key (reservation_details_id) references reservation (id)
);

--
create table wedding_hall_details(
id int primary key,
total_wedding_halls int not null,
availible int not null,
reservation_details_id int not null,
foreign key (reservation_details_id) references reservation_details (id)
);

--
create table occupied_wedding_hall(
id int primary key,
check_in varchar2(100) not null,
check_out varchar2(100) not null,
wedding_hall_number int not null,
wedding_hall_id int not null,
reservation_details_id int not null,
foreign key (wedding_hall_id) references wedding_hall (id),
foreign key (reservation_details_id) references reservation_details (id)
);

--
create table meeting_hall_details(
id int primary key,
total_meeting_halls int,
availbility int,
reservation_details_id int not null,
foreign key (reservation_details_id) references reservation_details (id)
);

--
create table occupied_meeting_halls(
id int primary key,
check_in varchar2(100),
check_out varchar2(100),
meeting_hall_number int,
meeting_hall_id int,
reservation_details_id int,
foreign key (meeting_hall_id) references meeting_hall (id),
foreign key (reservation_details_id) references reservation_details (id)
);

--
create table payment(
id int primary key,
mode_of_payment varchar2(100),
date_of_pay varchar2(100),
guest_id int,
foreign key (guest_id) references guest (id)
);

--
create table hoteladmin(
id int GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
email varchar2(100) unique,
password varchar2(100) not null
);

select * from hoteladmin;
insert into hoteladmin(email,password) values('admin@tstays.com','web123');

insert into admin values(1,'admin@tstays.com','web123');