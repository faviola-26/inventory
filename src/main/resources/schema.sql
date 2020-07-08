
CREATE SCHEMA IF NOT EXISTS INVENTORY;

CREATE TABLE IF NOT EXISTS address(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    street_name VARCHAR(60) NOT NULL,
    street_number INT NOT NULL,
    neighborhood VARCHAR(60) NOT NULL,
    city VARCHAR(40) NOT NULL,
    state VARCHAR(40) NOT NULL,
    cp VARCHAR(10) NOT NULL,
    country VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS _section(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    columnY INT NOT NULL, 
    rowX INT NOT NULL,
    capacity FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS section_categories(
    section_id INT NOT NULL,
    product_category_id BIGINT NOT NULL,
    FOREIGN KEY (section_id) REFERENCES _section(id)
);

CREATE TABLE IF NOT EXISTS active_product(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_product BIGINT NOT NULL,
    quantity BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS section_active_products(
    id_inventory_section_row INT NOT NULL,
    id_active_product BIGINT NOT NULL,
    FOREIGN KEY (id_inventory_section_row) REFERENCES inventory_section_row(id),
    FOREIGN KEY (id_active_product) REFERENCES active_product(id)
);

CREATE TABLE IF NOT EXISTS rack(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    identifier VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS rack_sections(
    id_rack INT NOT NULL,
    id_section INT NOT NULL,
    FOREIGN KEY (id_rack) REFERENCES rack(id),
    FOREIGN KEY (id_section) REFERENCES _section(id)
);

CREATE TABLE IF NOT EXISTS area(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    identifier VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS area_racks(
    id_area INT NOT NULL,
    id_rack INT NOT NULL,
    FOREIGN KEY (id_area) REFERENCES area(id),
    FOREIGN KEY (id_rack) REFERENCES rack(id)
);

CREATE TABLE IF NOT EXISTS location(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_address INT NOT NULL,
    landline VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_address) REFERENCES address (id)
);

CREATE TABLE IF NOT EXISTS location_areas(
    id_location INT NOT NULL,
    id_area INT NOT NULL,
    FOREIGN KEY (id_location) REFERENCES location(id),
    FOREIGN KEY (id_area) REFERENCES area(id)
);

CREATE TABLE IF NOT EXISTS entry_order(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    created_hour VARCHAR(6) NOT NULL,
    created_date VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS entry_order_product(
    entry_order_id INT NOT NULL,
    catalog_product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (entry_order_id) REFERENCES entry_order(id)
);
