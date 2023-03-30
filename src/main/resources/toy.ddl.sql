create table toy
(
    toy_id serial not null,
    what VARCHAR(32) not null,
    color VARCHAR(32) not null,
    PRIMARY KEY (toy_id)
);