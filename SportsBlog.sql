drop database if exists Sports;
create database Sports;

use Sports;


create table Users(
UserID int primary key auto_increment,
`name` varchar(50) not null,
username varchar(50) not null
);

create table Tags(
tagID int primary key auto_increment,
tagName varchar(30)
);

create table Category(
categoryID int primary key auto_increment,
categoryName varchar(30),
tagID int not null,
foreign key (tagID) references Tags(tagID)
);

create table BlogPost(
BlogPostID int primary key auto_increment,
`title` varchar(30) not null,
Post text,
Date date,
deleted date,
UserID int not null,
categoryID int not null,
foreign key (UserID) references Users(UserID),
foreign key (categoryID) references Category(categoryID)

);

create table Roles(
RoleID int primary key auto_increment,
roleName varchar(50) not null
);

create table UserRole(
UserID int not null,
 RoleID int not null,
primary key(UserID, RoleID),
foreign key (UserID) references Users(UserID),
foreign key (RoleID) references Roles(RoleID));


create table BlogPostTag(
tagID int not null,
BlogPostID int not null,
primary key(tagID, BlogPostID),
foreign key (tagID) references Tags(tagID),
foreign key (BlogPostID) references BlogPost(BlogPostID));


