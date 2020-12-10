set autocommit = off;
start transaction;

    create table User
    (
        UserID int not null
            primary key,
        Nickname varchar(35) not null,
        Firstname varchar(35) not null,
        Lastname varchar(35) not null,
        Secret varchar(35) not null
    );

    create table Project
    (
        ProjectID int not null
            primary key,
        ProjectName varchar(100) not null,
        Description text not null
    );

    create table Usergroup
    (
        GroupID int not null
            primary key,
        GroupName varchar(35) not null
    );

    create table User_Usergroup
    (
        UserID int not null,
        UsergroupID int not null,
        primary key(UserID, UsergroupID)
    );


commit;