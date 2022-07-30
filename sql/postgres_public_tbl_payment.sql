create table tbl_payment
(
    id            bigserial not null
        constraint tbl_payment_pkey
            primary key,
    created_by    integer,
    created_date  timestamp,
    status        boolean,
    updated_by    integer,
    updated_date  timestamp,
    form_payment  varchar(255),
    sale_order_id bigint
        constraint uk_dry8akf043trsc7k6pbavijac
            unique
        constraint fklx2slr0vaxlt5fo03hju09ytt
            references tbl_saleorder
);

alter table tbl_payment
    owner to postgres;

