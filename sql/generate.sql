create table if not exists tbl_article
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

create table if not exists tbl_category
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

create table if not exists tbl_contact
(
    id           bigserial not null
        constraint tbl_contact_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    email        varchar(255),
    message      varchar(255),
    name         varchar(255)
);

alter table tbl_contact
    owner to postgres;

create table if not exists tbl_customer
(
    id           bigserial not null
        constraint tbl_customer_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    address      varchar(255),
    age          varchar(255),
    email        varchar(255),
    name         varchar(255),
    phone        varchar(255)
);

alter table tbl_customer
    owner to postgres;

create table if not exists tbl_products
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

create table if not exists tbl_product_image
(
    id           bigserial not null
        constraint tbl_product_image_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    data         oid,
    file_name    varchar(255),
    file_type    varchar(255),
    updated_by   integer,
    updated_date timestamp,
    product_id   bigint
        constraint fki3x0x0mhaeomhbbpa7a51jvhn
            references tbl_products
);

alter table tbl_product_image
    owner to postgres;

create table if not exists tbl_product_images
(
    id           bigserial not null
        constraint tbl_product_images_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    data         oid,
    file_name    varchar(255),
    file_type    varchar(255),
    updated_by   integer,
    updated_date timestamp,
    product_id   bigint
        constraint fkep0t8akj7epqe1jhlsu25xduy
            references tbl_products
);

alter table tbl_product_images
    owner to postgres;

create table if not exists tbl_reviews
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

create table if not exists tbl_subscribe
(
    id           bigserial not null
        constraint tbl_subscribe_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    email        varchar(255)
);

alter table tbl_subscribe
    owner to postgres;

create table if not exists tbl_users
(
    id           bigserial not null
        constraint tbl_users_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    confirm      varchar(255),
    email        varchar(255),
    enable       boolean   not null,
    password     varchar(255),
    username     varchar(255)
);

alter table tbl_users
    owner to postgres;

create table if not exists tbl_avatar
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

create table if not exists tbl_password_reset
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

create table if not exists tbl_profile
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

create table if not exists tbl_saleorder
(
    id           bigserial not null
        constraint tbl_saleorder_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    code         varchar(255),
    total        numeric(19, 2),
    customer_id  bigint
        constraint uk_sudwpckys27ukl3fo2hjbivgp
            unique
        constraint fklidhckawmg8vnb5fqoi7pqxs
            references tbl_customer,
    user_id      bigint
        constraint fkbiu8ui4krw8j3gtn97w3rdq7v
            references tbl_users
);

alter table tbl_saleorder
    owner to postgres;

create table if not exists tbl_delivery
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

create table if not exists tbl_payment
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

create table if not exists tbl_saleorder_products
(
    id                bigserial not null
        constraint tbl_saleorder_products_pkey
            primary key,
    created_by        integer,
    created_date      timestamp,
    status            boolean,
    updated_by        integer,
    updated_date      timestamp,
    price             numeric(19, 2),
    quantity          bigint,
    title             varchar(255),
    product_id        bigint
        constraint fknyfdau9vc46jkiwvrgj1ns85v
            references tbl_products,
    product_entity_id bigint
        constraint uk_1n4gqg4s1s7d8avwgjx4u0rrp
            unique
        constraint fk949brd4vdjyun0v8j5h01ls6d
            references tbl_products,
    sale_order_id     bigint
        constraint fkglovdpnme4dban48a3wbglprr
            references tbl_saleorder
);

alter table tbl_saleorder_products
    owner to postgres;

create table if not exists tbl_users_roles
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

create table if not exists tbl_role
(
    id           bigserial not null
        constraint tbl_role_pkey
            primary key,
    created_by   integer,
    created_date timestamp,
    status       boolean,
    updated_by   integer,
    updated_date timestamp,
    name         varchar(255),
    desc      text
);

alter table tbl_role
    owner to postgres;
