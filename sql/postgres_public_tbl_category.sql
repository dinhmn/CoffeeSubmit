create table tbl_category
(
    id              bigserial not null
        constraint tbl_category_pkey
            primary key,
    created_by      integer,
    created_date    timestamp,
    status          boolean,
    updated_by      integer,
    updated_date    timestamp,
    categories_name varchar(255),
    description     varchar(255),
    seo             varchar(255),
    title           varchar(255)
);

alter table tbl_category
    owner to postgres;

