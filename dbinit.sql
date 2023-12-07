use brojop2;

set foreign_key_checks = 0;
drop table if exists Users;
drop table if exists Post;
drop table if exists Visibility;
drop table if exists LikePost;

create Table Users (
userID int not null auto_increment,
username varchar(255) not null,
password varchar(255) not null,

primary key (userID),
unique key (username)
);

insert into Users (username, password) values ("Alice", "Alice123");
insert into Users (username, password) values ("Bob", "Bob123");
insert into Users (username, password) values ("Crystal", "Crystal123");
insert into Users (username, password) values ("David", "David123");

create Table Post (
postID int not null auto_increment,
postText varchar(255) not null,
postTime timestamp default current_timestamp,
username varchar(255) not null,

primary key (postID),
foreign key (username) references Users(username)
);

insert into Post (username, postText, postTime) values ("Alice", "Project deadline Extended?", "2023-10-12 19:00:00");
insert into Post (username, postText, postTime) values ("Bob", "Yep", "2023-10-12 19:01:00");
insert into Post (username, postText, postTime) values ("David", "Fall break", "2023-10-16 09:00:00");
insert into Post (username, postText, postTime) values ("Alice", "Lab due tonight?", "2023-10-27 23:30:00");
insert into Post (username, postText, postTime) values ("Crystal", "No, it's due next week", "2023-10-27 23:35:00");

create Table Visibility (
visibilityID int auto_increment,
userID int,
visibleUserID int,

primary key (visibilityID),
foreign key (userID) references Users(userID),
foreign key (visibleUserID) references Users(userID)
);

insert into Visibility (userID, visibleUserID) Values 
	((select userID from Users where username = "Alice"), (select userID from Users where username = "Bob")),
    ((select userID from Users where username = "Alice"), (select userID from Users where username = "Crystal")),
    ((select userID from Users where username = "Bob"), (select userID from Users where username = "Alice")),
    ((select userID from Users where username = "Bob"), (select userID from Users where username = "Crystal")),
    ((select userID from Users where username = "Crystal"), (select userID from Users where username = "Alice"));
    

create Table LikePost (
userID int not null auto_increment,

foreign key (userID) references Users(userID)
)