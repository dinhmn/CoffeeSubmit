create table tbl_saleorder_products
(
    id                bigserial not null
        constraint tbl_saleorder_products_pkey
            primary key,
    created_by        integer,
    created_date      timestamp,
    status            boolean,
    updated_by        integer,
    updated_date      timestamp,
    price             numeric(19, 2),
    quantity          bigint,
    title             varchar(255),
    product_id        bigint
        constraint fknyfdau9vc46jkiwvrgj1ns85v
            references tbl_products,
    product_entity_id bigint
        constraint uk_1n4gqg4s1s7d8avwgjx4u0rrp
            unique
        constraint fk949brd4vdjyun0v8j5h01ls6d
            references tbl_products,
    sale_order_id     bigint
        constraint fkglovdpnme4dban48a3wbglprr
            references tbl_saleorder
);

alter table tbl_saleorder_products
    owner to postgres;

