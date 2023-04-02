create table event
(
    event_id   serial                   not null,
    event_name varchar(32)              not null,
    date_time  timestamp with time zone not null,
    capacity   int                      not null,
    primary key (event_id),
    UNIQUE (event_name)
);

create table ticket
(
    ticket_id  serial      not null,
    first_name varchar(32) not null,
    last_name  varchar(32) not null,
    event_id   int         not null,
    primary key (ticket_id),
    constraint fk_ticket_event
        foreign key (event_id)
            references event (event_id)
);