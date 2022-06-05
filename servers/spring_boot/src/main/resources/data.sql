insert into setup(id, name, option_value,use_case,version,status)
values(nextval('setup_id_seq'),'Server', 'Spring Boot', 'Runtime Dependency injection + JPA support',1,1);

insert into setup(id, name, option_value,use_case,version,status)
values(nextval('setup_id_seq'),'FrontEnd', 'ReactJS', 'ComponentBased + Community Support',1,1);

insert into setup(id, name, option_value,use_case,version,status)
values(nextval('setup_id_seq'),'Database', 'PostgreSQL', 'OpenSource + Community Support',1,1);

insert into setup(id, name, option_value,use_case,version,status)
values(nextval('setup_id_seq'),'CI/CD', 'Github Actions', 'Collaboration with other + No additional setup',1,1);

insert into setup(id, name, option_value,use_case,version,status)
values(nextval('setup_id_seq'),'Container', 'Docker', 'Community Support',1,1);

insert into setup(id, name, option_value,use_case,version,status)
values(nextval('setup_id_seq'),'Cloud Provider', 'AWS', 'Coverage',1,1);


insert into configuration(id, key, value, version, status)
values(nextval('configuration_id_seq'), 'SYSTEM.SERVICE.NUMBER', '2', 1, 1);

insert into configuration(id, key, value, version, status)
values(nextval('configuration_id_seq'), 'SYSTEM.SERVICE.NAMES', 'APP,DB', 1, 1);

insert into configuration(id, key, value, version, status)
values(nextval('configuration_id_seq'), 'SYSTEM.STARTUP.DB.INSERT', 'TRUE', 1, 1);
