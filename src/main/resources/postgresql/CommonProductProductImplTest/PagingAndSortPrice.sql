insert into tbl_products (id, created_by, created_date, status, updated_by, updated_date, details_description, price,
                          price_sale, quantity, seo, short_description, title, category_id)
values (1, 1, '2022/05/22 12:37:43', true, 1, '2022/05/22 12:37:43', 'product1', 12000, 10000, 37, 'product-1',
        'product1', 'product1', 2),
       (2, 4, '2022/05/23 12:37:43', false, 1, '2022/05/23 12:37:43', 'product2', 16000, 10000, 37, 'product-2',
        'product2', 'product2', 1),
       (3, 2, '2022/05/24 12:37:43', false, 1, '2022/05/24 12:37:43', 'product3', 13000, 10000, 37, 'product-3',
        'product3', 'product3', 3),
       (4, 2, '2022/05/25 12:37:43', true, 1, '2022/05/25 12:37:43', 'product4', 22000, 10000, 37, 'product-4',
        'product4', 'product4', 3),
       (5, 3, '2022/05/26 12:37:43', false, 1, '2022/05/26 12:37:43', 'product5', 45000, 10000, 37, 'product-5',
        'product5', 'product5', 2),
       (6, 4, '2022/05/28 12:37:43', true, 1, '2022/05/28 12:37:43', 'product6', 10000, 10000, 37, 'product-6',
        'product6', 'product6', 3);

select * from tbl_products

