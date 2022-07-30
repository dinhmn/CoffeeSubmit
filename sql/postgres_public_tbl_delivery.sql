create table tbl_delivery
(
    id            bigserial not null
        constraint tbl_delivery_pkey
            primary key,
    created_by    integer,
    created_date  timestamp,
    status        boolean,
    updated_by    integer,
    updated_date  timestamp,
    delivery      varchar(255),
    sale_order_id bigint
        constraint uk_kjrhqrduui7d5f39xn44i2ch
            unique
        constraint fkhqqrynm4ht1wbefcmuisp2hcu
            references tbl_saleorder
);

alter table tbl_delivery
    owner to postgres;

