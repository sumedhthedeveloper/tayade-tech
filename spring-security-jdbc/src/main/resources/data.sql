INSERT INTO USERS(username,password,enabled) VALUES ('user','pass',true);

INSERT INTO USERS(username,password,enabled) VALUES ('admin','pass',true);

INSERT INTO AUTHORITIES(username,authority) VALUES ('user','ROLE_USER');

INSERT INTO AUTHORITIES(username,authority) VALUES ('admin','ROLE_ADMIN');