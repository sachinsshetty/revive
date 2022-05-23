CREATE SEQUENCE driver_id_seq INCREMENT 1 START 1;

insert into driver(id, user_name, first_name,last_name,status) values(nextval('driver_id_seq'),'max', 'max', 'verstappen',true);

insert into driver(id, user_name, first_name,last_name,status) values(nextval('driver_id_seq'),'charles', 'charles', 'leclerc',true);


insert into driver(id, user_name, first_name,last_name,status) values(nextval('driver_id_seq'),'kimi', 'kimi', 'raikonnen',true);

CREATE SEQUENCE configuration_id_seq INCREMENT 1 START 1;

insert into configuration(id, key, value, version, status)values(nextval('configuration_id_seq'), 'SERVICE.NUMBER', '2', 1, true);

insert into configuration(id, key, value, version, status)values(nextval('configuration_id_seq'), 'SERVICE.NAMES', 'APP,DB', 1, true);

insert into configuration(id, key, value, version, status)values(nextval('configuration_id_seq'), 'STARTUP.DB.INSERT', 'TRUE', 1, true);



CREATE SEQUENCE stall_id_seq INCREMENT 1 START 1;

insert into stall(id, user_name, latitude, longitude)values(nextval('stall_id_seq'), 'tesla lot 1', 09.11, 19.19);

insert into stall(id, user_name, latitude, longitude)values(nextval('stall_id_seq'), 'electrify lot 1', 31.01, 19.98);

insert into stall(id, user_name, latitude, longitude)values(nextval('stall_id_seq'), 'BMW lot 1', 19.07, 19.69);

insert into stall(id, user_name, latitude, longitude)values(nextval('stall_id_seq'), 'Mercedes lot 1', 22.12, 19.61);


CREATE SEQUENCE vehicle_id_seq INCREMENT 1 START 1;

insert into vehicle(id,user_name , reg_no, status)values(nextval('vehicle_id_seq'), 'tesla_model_S', 'TSLA 001', true);

insert into vehicle(id,user_name , reg_no, status)values(nextval('vehicle_id_seq'), 'tesla_model_Y', 'TSLA 002', true);

insert into vehicle(id,user_name , reg_no, status)values(nextval('vehicle_id_seq'), 'volkswagen_id_4', 'VWID 04', true);

insert into vehicle(id,user_name , reg_no, status)values(nextval('vehicle_id_seq'), 'bmw_i3', 'BMWI 03', true);

insert into vehicle(id,user_name , reg_no, status)values(nextval('vehicle_id_seq'), 'porsche_taycan', 'PRSH 001', true);


CREATE SEQUENCE payment_id_seq INCREMENT 1 START 1;


insert into payment(id, user_name, gateway, balance )values(nextval('payment_id_seq'), 'paypal','paypal', 99.99);
insert into payment(id, user_name, gateway, balance )values(nextval('payment_id_seq'), 'commerzbank', 'commerzbank', 99.99);

insert into payment(id, user_name, gateway, balance )values(nextval('payment_id_seq'), 'sparkasse', 'sparkasse', 99.99);

insert into payment(id, user_name, gateway, balance )values(nextval('payment_id_seq'), 'deutsche_bank', 'deutsche_bank',99.99);
 
	
