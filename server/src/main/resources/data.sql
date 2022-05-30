insert into app_user(id, user_name, first_name,last_name,status) values(nextval('app_user_id_seq'),'max', 'max', 'verstappen',true);

insert into app_user(id, user_name, first_name,last_name,status) values(nextval('app_user_id_seq'),'charles', 'charles', 'leclerc',true);

insert into app_user(id, user_name, first_name,last_name,status) values(nextval('app_user_id_seq'),'kimi', 'kimi', 'raikonnen',true);




insert into configuration(id, key, value, version, status)values(nextval('configuration_id_seq'), 'SYSTEM.SERVICE.NUMBER', '2', 1, true);

insert into configuration(id, key, value, version, status)values(nextval('configuration_id_seq'), 'SYSTEM.SERVICE.NAMES', 'APP,DB', 1, true);

insert into configuration(id, key, value, version, status)values(nextval('configuration_id_seq'), 'SYSTEM.STARTUP.DB.INSERT', 'TRUE', 1, true);





insert into device(id,user_name , reg_no, status)values(nextval('device_id_seq'), 'tesla_model_S', 'TSLA 001', true);

insert into device(id,user_name , reg_no, status)values(nextval('device_id_seq'), 'tesla_model_Y', 'TSLA 002', true);

insert into device(id,user_name , reg_no, status)values(nextval('device_id_seq'), 'volkswagen_id_4', 'VWID 04', true);

insert into device(id,user_name , reg_no, status)values(nextval('device_id_seq'), 'bmw_i3', 'BMWI 03', true);

insert into device(id,user_name , reg_no, status)values(nextval('device_id_seq'), 'porsche_taycan', 'PRSH 001', true);


