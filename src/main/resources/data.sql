
insert into users(username, password, enabled)values('admin','{noop}admin',true);
insert into authorities(username,authority)values('admin','ROLE_ADMIN');

insert into users(username, password, enabled)values('employee','{noop}employee',true);
insert into authorities(username,authority)values('employee','ROLE_USER');

insert into employee(name)values('pierwszy');