create table tbl_reviews
(
    id           bigserial not null
        constraint tbl_reviews_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    comment      varchar(255),
    email        varchar(255),
    name         varchar(255),
    product_id   bigint
        constraint fk7byy3k4kp0fg9ha8mynfw4q0b
            references tbl_products
);

alter table tbl_reviews
    owner to postgres;

