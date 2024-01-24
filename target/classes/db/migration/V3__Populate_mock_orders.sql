INSERT INTO orders (id, to_date_time, client_info, delivery_address, comment, people_count, cart_items, sticks_count, study_sticks_count, delivery_type, payment_type, status_type, removal_date)
VALUES (1, '09.10.2023', '{"phoneNumber": "1234567890", "name": "Oleg"}', '{"clientAddress": "Elbląska 51, 1 entrance, 2, 209, 01737"}', 'through the main entrance', 2,  '[{"id": 1, "quantity": 2}]', 2, 1, 'DELIVERY', 'CASH', 'CREATED', null);
INSERT INTO orders (id, to_date_time, client_info, delivery_address, comment, people_count, cart_items, sticks_count, study_sticks_count, delivery_type, payment_type, status_type, removal_date)
VALUES (2, '11.01.2024', '{"phoneNumber": "987654321", "name": "Bohdan"}', '{"clientAddress": "Warsaw"}', 'none', 2,  '[{"id": 1, "quantity": 1}]', 4, 2, 'PICKUP', 'ONLINE', 'CREATED', null);
INSERT INTO orders (id, to_date_time, client_info, delivery_address, comment, people_count, cart_items, sticks_count, study_sticks_count, delivery_type, payment_type, status_type, removal_date)
VALUES (3, '12.31.2023', '{"phoneNumber": "+48882374284", "name": "Ruslan"}', '{"clientAddress": "Gdansk"}', 'none', 4,  '[{"id": 1, "quantity": 4}]', 3, 2, 'PICKUP', 'CASH', 'CREATED', null);
INSERT INTO orders (id, to_date_time, client_info, delivery_address, comment, people_count, cart_items, sticks_count, study_sticks_count, delivery_type, payment_type, status_type, removal_date)
VALUES (4, '01.12.2023', '{"phoneNumber": "+48256925785", "name": "Oleksandr"}', '{"clientAddress": "Oliva"}', 'please call me when courier will be near my house', 2,  '[{"id": 1, "quantity": 4}]', 1, 1, 'DELIVERY', 'TERMINAL', 'CREATED', null);
