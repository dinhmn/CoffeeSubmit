create table tbl_contact
(
    id           bigserial not null
        constraint tbl_contact_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    email        varchar(255),
    message      varchar(255),
    name         varchar(255)
);

alter table tbl_contact
    owner to postgres;

