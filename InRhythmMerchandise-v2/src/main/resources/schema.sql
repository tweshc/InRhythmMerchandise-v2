create table product
(
   id integer not null,
   name varchar(255) not null,
   isElectronic BOOLEAN not null,
   price float not null,
   primary key(id)
);