create table tbl_customer
(
    id           bigserial not null
        constraint tbl_customer_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    address      varchar(255),
    age          varchar(255),
    email        varchar(255),
    name         varchar(255),
    phone        varchar(255)
);

alter table tbl_customer
    owner to postgres;

