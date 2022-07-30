create table tbl_password_reset
(
    id             bigserial not null
        constraint tbl_password_reset_pkey
            primary key,
    created_by     integer,
    created_date   timestamp,
    status         boolean,
    updated_by     integer,
    updated_date   timestamp,
    password_reset varchar(255),
    users_id       bigint
        constraint uk_7pdae9dmfbulhob3uxjvcii9j
            unique
        constraint fkml4cjxf8yhvv9105cjg0wm3nh
            references tbl_users
);

alter table tbl_password_reset
    owner to postgres;

