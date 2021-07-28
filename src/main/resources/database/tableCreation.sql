create table CarOwner(
	id int primary key not null,
	name char(50) not null,
	age int not null,
	address char(50) not null,
	contact_number char(50) not null,
	license_number char(50) not null
);
create table Car (
	id int primary key not null, 
	brand char(50) not null, 
	model char(50) not null, 
	reg_number char(50) not null, 
	owner_id int not null,
	foreign key(owner_id) references CarOwner(id)
);
insert into CarOwner values(1, "John", 21, "London", "0771124455", "1452789AE");
insert into CarOwner values(2, "Kamal", 22, "Colombo", "0775571324", "9273549HJ");
insert into CarOwner values(3, "Peter", 25, "Newyork", "0771234575", "0143526RY");
insert into CarOwner values(4, "Ravi", 31, "Chennai", "0774568213", "4632157SL");
insert into CarOwner values(5, "Anushka", 40, "Nagpur", "0714265899", "2104583CW");
insert into CarOwner values(6, "Khan", 35, "Kerala", "0752458699", "1024538RE");
insert into CarOwner values(7, "Priyanka", 29, "Mumbai", "0782451325", "2034987WP");
insert into CarOwner values(8, "Isuri", 20, "Matara", "0771298542", "9264823BX");
insert into CarOwner values(9, "Supun", 43, "Galle", "0754128862", "5585231PS");
insert into CarOwner values(10, "Thihari", 39, "Kandy", "0771256432", "7124208US");
insert into Car values(101, "Toyota", "Aqua", "GH5634", 3);
insert into Car values(102, "Toyota", "Yaris", "BD7253", 6);
insert into Car values(103, "Toyota", "Corolla", "ME2745", 9);
insert into Car values(104, "Toyota", "Axios", "NE9465", 5);
insert into Car values(105, "Suzuki", "Swift", "HG6512", 9);
insert into Car values(106, "Suzuki", "Alto", "EW0123", 7);
insert into Car values(107, "Suzuki", "Alto", "CS6523", 1);
insert into Car values(108, "Suzuki", "Aqua", "FS8563", 4);
insert into Car values(109, "Suzuki", "Aqua", "FE8723", 7);
insert into Car values(110, "Audi", "A8", "JW9830", 3);
insert into Car values(111, "Audi", "Q3", "BH4562", 10);
insert into Car values(112, "Audi", "Aqua", "BA7613", 2);
insert into Car values(113, "Toyota", "Prius", "LW9824", 8);
insert into Car values(114, "Toyota", "Avalon", "BF3409", 5);
insert into Car values(115, "Toyota", "Aqua", "JQ7613", 3);