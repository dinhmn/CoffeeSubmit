create table tbl_roles
(
    id           bigserial not null
        constraint tbl_roles_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    name         varchar(255),
    "desc"       varchar(255)
);

alter table tbl_roles
    owner to postgres;

