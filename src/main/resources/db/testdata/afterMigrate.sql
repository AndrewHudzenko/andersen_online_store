INSERT INTO clients (id, name, surname, phone_number, email, visible)
VALUES
    ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'John', 'Doe', '123456789', 'john@example.com', true),
    ('6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'Jane', 'Smith', '987654321', 'jane@example.com', true)
on conflict (id) do nothing;

INSERT INTO orders (id, client_id, creating_time, visible)
VALUES
    ('6ba7b815-9dad-11d1-80b4-00c04fd430c8', '6ba7b810-9dad-11d1-80b4-00c04fd430c8', '2023-01-01 12:00:00', true),
    ('6ba7b816-9dad-11d1-80b4-00c04fd430c8', '6ba7b811-9dad-11d1-80b4-00c04fd430c8', '2023-01-02 15:30:00', true)
on conflict (id) do nothing;

INSERT INTO products (id, title, category, purchase_price, retail_price, amount, visible)
VALUES
    ('6ba7b812-9dad-11d1-80b4-00c04fd430c8', 'Laptop', 'Electronics', 800.00, 1200.00, 10, true),
    ('6ba7b813-9dad-11d1-80b4-00c04fd430c8', 'Coffee Maker', 'Appliances', 50.00, 80.00, 20, true)
on conflict (id) do nothing;

INSERT INTO stock (id, visible)
VALUES
    ('6ba7b814-9dad-11d1-80b4-00c04fd430c8', true)
on conflict (id) do nothing;


INSERT INTO clients_orders (client_id, order_id)
VALUES
    ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', '6ba7b815-9dad-11d1-80b4-00c04fd430c8'),
    ('6ba7b811-9dad-11d1-80b4-00c04fd430c8', '6ba7b816-9dad-11d1-80b4-00c04fd430c8')
on conflict (client_id, order_id) do nothing;

INSERT INTO orders_products (order_id, product_id)
VALUES
    ('6ba7b815-9dad-11d1-80b4-00c04fd430c8', '6ba7b812-9dad-11d1-80b4-00c04fd430c8'),
    ('6ba7b815-9dad-11d1-80b4-00c04fd430c8', '6ba7b813-9dad-11d1-80b4-00c04fd430c8'),
    ('6ba7b816-9dad-11d1-80b4-00c04fd430c8', '6ba7b812-9dad-11d1-80b4-00c04fd430c8')
on conflict (order_id, product_id) do nothing;

INSERT INTO stock_products (stock_id, product_id)
VALUES
    ('6ba7b814-9dad-11d1-80b4-00c04fd430c8', '6ba7b812-9dad-11d1-80b4-00c04fd430c8')
on conflict (stock_id, product_id) do nothing;
