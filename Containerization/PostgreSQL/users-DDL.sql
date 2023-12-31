CREATE TABLE if not exists users (
  user_id serial PRIMARY KEY,
  name varchar (100) NOT NULL,
  email varchar (100) NOT NULL,
  mobile_number varchar (20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar (50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by varchar (50)  NULL
);

CREATE TABLE IF NOT EXISTS user_address (
  address_id serial PRIMARY KEY,
  user_id int NOT NULL REFERENCES users (user_id),
  address varchar (100) NOT NULL,
  address2 varchar (200) NOT NULL,
  district varchar (200) NOT NULL,
  city varchar (20) NOT NULL,
  state varchar (20) NOT NULL,
  postal_code varchar (20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar (50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by varchar (50)  NULL
);

CREATE TABLE IF NOT EXISTS user_payment (
  payment_id serial PRIMARY KEY,
  user_id int NOT NULL REFERENCES users (user_id),
  payment_type varchar (100) NOT NULL,
  provider varchar (200) NOT NULL,
  account_number varchar(200) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar (50) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by varchar (50)  NULL
);


INSERT INTO "users" ("name", "email", "mobile_number","created_by") 
	VALUES ('Ahmad Gohar', 'mail@host.com', '1234567890','SYSTEM_USER');
INSERT INTO "user_payment" ("user_id", "payment_type", "provider", "account_number", "created_by") 
	VALUES (1,'CC','BofA','123-321-456','SYSTEM_USER');
INSERT INTO "user_address" ("user_id", "address", "address2", "district", "city", "state", "postal_code", "created_by") 
	VALUES (1,'address line1', 'address line 2', 'Carol Stream', 'Dupage', 'IL', 12345,'SYSTEM_USER');
INSERT INTO "user_address" ("user_id", "address", "address2", "district", "city", "state", "postal_code", "created_by") 
	VALUES (1,'address line21', 'address line 22', 'Carol Stream2', 'Dupage2', 'IL', 54321,'SYSTEM_USER');

INSERT INTO "users" ("name", "email", "mobile_number","created_by") 
	VALUES ('Sara Adam', 'sara@gmail.com', '9876543210','SYSTEM_USER');
INSERT INTO "user_payment" ("user_id", "payment_type", "provider", "account_number", "created_by") 
	VALUES (2,'DC','CITI','111-222-3333','SYSTEM_USER');
INSERT INTO "user_address" ("user_id", "address", "address2", "district", "city", "state", "postal_code", "created_by") 
	VALUES (2,'address 201', 'address 202', 'Anaheim', 'Los Angeles', 'CA', 54321,'SYSTEM_USER');

select * from users;
select * from user_payment;
select * from user_address;

