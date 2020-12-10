use pilaster;

create table Task
(
	Taskid int not null
		primary key,
	Text text not null
);

create table Ticket
(
	id int not null
		primary key,
	Title varchar(500) not null,
	description text not null
);

