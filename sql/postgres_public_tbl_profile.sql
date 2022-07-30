create table tbl_profile
(
    id           bigserial not null
        constraint tbl_profile_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    address      varchar(255),
    age          varchar(255),
    birthday     varchar(255),
    data         oid,
    name         varchar(255),
    phone_number varchar(255),
    user_id      bigint
        constraint fk637exc6y7ex8eaurjr7eymof3
            references tbl_users,
    users_id     bigint
        constraint uk_nug87dtpejps2h3akd17tn6ha
            unique
        constraint fkpqqgg5p6hb9c0893xk943vwvi
            references tbl_users
);

alter table tbl_profile
    owner to postgres;

