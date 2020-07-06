/**
 * Author:  Faviola
 * Created: 1 jul 2020
 */

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

CREATE TABLE IF NOT EXISTS inventory_section_column(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_section_row(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_product BIGINT NOT NULL,
    capacity FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_section_column_section_rows(
    id_inventory_section_column INT NOT NULL,
    id_inventory_section_row INT NOT NULL,
    FOREIGN KEY (id_inventory_section_column) REFERENCES inventory_section_column(id),
    FOREIGN KEY (id_inventory_section_row) REFERENCES inventory_section_row(id)
);

CREATE TABLE IF NOT EXISTS inventory_section_row_categories(
    id_inventory_section_row INT NOT NULL,
    id_category BIGINT NOT NULL,
    FOREIGN KEY (id_inventory_section_row) REFERENCES inventory_section_row(id),
    FOREIGN KEY (id_category) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS active_product(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_product BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    FOREIGN KEY(id_product) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS inventory_section_row_active_products(
    id_inventory_section_row INT NOT NULL,
    id_active_product BIGINT NOT NULL,
    FOREIGN KEY (id_inventory_section_row) REFERENCES inventory_section_row(id),
    FOREIGN KEY (id_active_product) REFERENCES active_product(id)
);

CREATE TABLE IF NOT EXISTS inventory_rack(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    identifier VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS rack_section_columns(
    id_inventory_rack INT NOT NULL,
    id_inventory_section_column INT NOT NULL,
    FOREIGN KEY (id_inventory_rack) REFERENCES inventory_rack(id),
    FOREIGN KEY (id_inventory_section_column) REFERENCES inventory_section_column(id)
);

CREATE TABLE IF NOT EXISTS inventory_area(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    identifier VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_area_racks(
    id_inventory_area INT NOT NULL,
    id_inventory_rack INT NOT NULL,
    FOREIGN KEY (id_inventory_area) REFERENCES inventory_area(id),
    FOREIGN KEY (id_inventory_rack) REFERENCES inventory_rack(id)
);

CREATE TABLE IF NOT EXISTS inventory_location(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_address INT NOT NULL,
    landline VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_location_areas(
    id_inventory_location INT NOT NULL,
    id_inventory_area INT NOT NULL,
    FOREIGN KEY (id_inventory_location) REFERENCES inventory_location(id),
    FOREIGN KEY (id_inventory_area) REFERENCES inventory_area(id)
);

CREATE TABLE IF NOT EXISTS inventory_entry_order(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    hour VARCHAR(6) NOT NULL,
    date VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_entry_order_product(
    id_inventory_entry_order INT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (id_inventory_entry_order) REFERENCES inventory_entry_order(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

