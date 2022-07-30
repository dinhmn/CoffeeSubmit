create table tbl_article
(
    id           bigserial not null
        constraint tbl_article_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    description  varchar(255),
    title        varchar(255)
);

alter table tbl_article
    owner to postgres;

