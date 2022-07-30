create table tbl_products
(
    id                  bigserial      not null
        constraint tbl_products_pkey
            primary key,
    created_by          integer,
    created_date        timestamp,
    status              boolean,
    updated_by          integer,
    updated_date        timestamp,
    details_description varchar(255),
    price               numeric(13, 2) not null,
    price_sale          numeric(13, 2),
    quantity            bigint,
    seo                 varchar(255),
    short_description   varchar(255),
    title               varchar(255),
    category_id         bigint
        constraint fkl5l3hu2fh1ixbx8ejat9df13p
            references tbl_category
);

alter table tbl_products
    owner to postgres;

