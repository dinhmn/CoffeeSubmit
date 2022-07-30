create table tbl_product_images
(
    id           bigserial not null
        constraint tbl_product_images_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    data         oid,
    file_name    varchar(255),
    file_type    varchar(255),
    updated_by   integer,
    updated_date timestamp,
    product_id   bigint
        constraint fkep0t8akj7epqe1jhlsu25xduy
            references tbl_products
);

alter table tbl_product_images
    owner to postgres;

