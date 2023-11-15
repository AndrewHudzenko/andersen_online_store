CREATE TABLE IF NOT EXISTS clients (
                                       id VARCHAR(255) PRIMARY KEY,
                                       name VARCHAR(255),
                                       surname VARCHAR(255),
                                       phone_number VARCHAR(255),
                                       email VARCHAR(255),
                                       visible BOOLEAN
);

CREATE TABLE IF NOT EXISTS orders (
                                      id VARCHAR(255) PRIMARY KEY,
                                      client_id VARCHAR(255),
                                      creating_time TIMESTAMP,
                                      visible BOOLEAN,
                                      FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE IF NOT EXISTS products (
                                        id VARCHAR(255) PRIMARY KEY,
                                        title VARCHAR(255),
                                        category VARCHAR(255),
                                        purchase_price DECIMAL(10, 2),
                                        retail_price DECIMAL(10, 2),
                                        amount BIGINT,
                                        visible BOOLEAN
);

CREATE TABLE IF NOT EXISTS stock (
                       id VARCHAR(255) PRIMARY KEY,
                       visible BOOLEAN
);

CREATE TABLE stock_products (
                                stock_id VARCHAR(255),
                                product_id VARCHAR(255),
                                PRIMARY KEY (stock_id, product_id),
                                FOREIGN KEY (stock_id) REFERENCES stock(id),
                                FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE IF NOT EXISTS clients_orders (
    client_id VARCHAR(255) NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (client_id, order_id),
    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (order_id) REFERENCES orders (id)
);

CREATE TABLE IF NOT EXISTS orders_products (
    order_id VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
