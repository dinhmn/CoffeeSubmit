create table tbl_subscribe
(
    id           bigserial not null
        constraint tbl_subscribe_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    email        varchar(255)
);

alter table tbl_subscribe
    owner to postgres;

