-- USERS

INSERT INTO Users (id, email, firstname, lastname, password, status)
VALUES (111, 'admin@miu.edu', 'Admin', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2','ACTIVE'); --123
INSERT INTO Users (id, email, firstname, lastname, password,status)
VALUES (112, 'testuser01@miu.edu', 'Test', 'User', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2','ACTIVE'); --123
INSERT INTO Users (id, email, firstname, lastname, password,status)
VALUES (113, 'mohammad.fuad@miu.edu', 'Mohammad', 'Fuad', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2','ACTIVE'); --123

-- Role
INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CUSTOMER');
INSERT INTO role (id, role)
VALUES (3, 'OWNER');
INSERT INTO role (id, role)
VALUES (4, 'VIEWER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (111, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (112, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (113, 2);
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (1, '2022-11-24', 'Yes', 28111, 'Yes', 8, 0, 'Yes');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (2, '2022-8-31', 'Yes', 28113, 'Yes', 14, 0, 'Yes');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (3, '2022-6-24', 'Yes', 28111, 'Yes', 8, 0, 'Yes');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (4, '2022-5-31', 'No', 28113, 'Yes', 14, 0, 'Yes');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (5, '2022-1-24', 'Yes', 28111, 'Yes', 8, 0, 'Yes');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (6, '2022-10-31', 'Yes', 28113, 'Yes', 14, 0, 'No');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (7, '2022-9-24', 'Yes', 28111, 'Yes', 8, 0, 'Yes');
INSERT INTO property_details (id, build_date, cooling_system, description, heating_system, no_of_rooms, no_of_views, parking) VALUES (8, '2022-10-8', 'Yes', 28113, 'Yes', 14, 0, 'Yes');
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (1, 3456000, 2000, 'ACTIVE', 'SINGLE', 'Bunglow on Sale', null, 1, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (2, 10000, 1000000, 'ACTIVE', 'CONDO', 'Apartment For Sale', null, 2, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (3, 34000, 200, 'ACTIVE', 'DUPLEX', 'House on Sale', null, 3, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (4, 100, 1000, 'ACTIVE', 'CONDO', 'Flat For Rent', null, 4, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (5, 34000, 2000, 'ACTIVE', 'DUPLEX', 'House on Sale', null, 5, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (6, 100, 1200, 'ACTIVE', 'CONDO', 'Apartment For Rent', null, 6, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (7, 3450, 2000, 'ACTIVE', 'DUPLEX', 'Bunglow on Rent', null, 7, 113);
INSERT INTO property (id, area, price, property_status, property_type, title, address_id, details_id, owner_id) VALUES (8, 10000, 10500, 'ACTIVE', 'CONDO', 'Apartment For Rent', null, 8, 113);
