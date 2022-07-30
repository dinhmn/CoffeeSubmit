create table tbl_avatar
(
    id           bigserial not null
        constraint tbl_avatar_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    data         oid,
    file_name    varchar(255),
    file_type    varchar(255),
    updated_by   integer,
    updated_date timestamp,
    users_id     bigint
        constraint uk_k5x1pl1vfde6v03qa6ig0bbf1
            unique
        constraint fklfuneqw5wwv9p6vl8cfr8y5iy
            references tbl_users
);

alter table tbl_avatar
    owner to postgres;

