create table tbl_product_image
(
    id           bigserial not null
        constraint tbl_product_image_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    data         oid,
    file_name    varchar(255),
    file_type    varchar(255),
    updated_by   integer,
    updated_date timestamp,
    product_id   bigint
        constraint fki3x0x0mhaeomhbbpa7a51jvhn
            references tbl_products
);

alter table tbl_product_image
    owner to postgres;

