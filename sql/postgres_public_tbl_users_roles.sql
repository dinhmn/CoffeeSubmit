create table tbl_users_roles
(
    role_id bigint not null,
    user_id bigint not null
        constraint fk9759r6hlfhyhtv3e7eppsldx9
            references tbl_users,
    constraint tbl_users_roles_pkey
        primary key (role_id, user_id)
);

alter table tbl_users_roles
    owner to postgres;

