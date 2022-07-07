create table setup(
id  serial  primary key,
type_name varchar(255),
option_value varchar(255),
use_case varchar(255),
status int,
version int);

create table configuration(
id serial primary key,
key varchar(255),
status int,
value varchar(255),
version int);
