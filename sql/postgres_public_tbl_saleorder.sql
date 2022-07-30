create table tbl_saleorder
(
    id           bigserial not null
        constraint tbl_saleorder_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    code         varchar(255),
    total        numeric(19, 2),
    customer_id  bigint
        constraint uk_sudwpckys27ukl3fo2hjbivgp
            unique
        constraint fklidhckawmg8vnb5fqoi7pqxs
            references tbl_customer,
    user_id      bigint
        constraint fkbiu8ui4krw8j3gtn97w3rdq7v
            references tbl_users
);

alter table tbl_saleorder
    owner to postgres;

