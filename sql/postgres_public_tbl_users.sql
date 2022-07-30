create table tbl_users
(
    id           bigserial not null
        constraint tbl_users_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    confirm      varchar(255),
    email        varchar(255),
    enable       boolean   not null,
    password     varchar(255),
    username     varchar(255)
);

alter table tbl_users
    owner to postgres;

