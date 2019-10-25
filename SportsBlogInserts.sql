insert into users(userId, username, password, enabled)
values(1,"admin", "password", true),
(2,"user", "password", true);
insert into roles(roleid, role)
values(1, "ROLE_ADMIN"), (2, "ROLE_USER");
insert into userrole(userid, roleid)
values(1,1), (1,2), (2,2); 

-- giving admin as a user and a admin
-- we are inserting unencoded passwords in the database
-- starting with two roles

UPDATE users SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE userid = 1;
UPDATE users SET password = '$2a$10$S8nFUMB8YIEioeWyap24/ucX.dC6v9tXCbpHjJVQUkrXlrH1VLaAS' WHERE userid = 2;