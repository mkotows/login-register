
insert into users(username, password, enabled)values('admin','$2a$10$WaEoJRkZXi4R44CMP0URMufyHo37swupsSMzYJ/icyjcAaLnof.HK',true);
insert into authorities(username,authority)values('admin','ROLE_ADMIN');

-- insert into users(username, password, enabled)values('employee','{noop}employee',true);
-- insert into authorities(username,authority)values('employee','ROLE_USER');

-- insert into employee(name)values('pierwszy');