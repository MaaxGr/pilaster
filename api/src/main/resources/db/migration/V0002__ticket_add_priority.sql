
set autocommit = off;
start transaction;

alter table Ticket add column Priority varchar(35);
alter table Ticket rename column id to ID;
alter table Ticket rename column description to Description;

commit;