--Insert users
INSERT INTO users (id, document_type, document_number) VALUES (1, 'CC', '123');
INSERT INTO users (id, document_type, document_number) VALUES (2, 'CC', '456');
INSERT INTO users (id, document_type, document_number) VALUES (3, 'CC', '678');



--Insert turns
INSERT INTO turns (id, code, process_type, fecha, user_id, status) VALUES ('1','T1', 'TRANSFERS', '2023-01-11 08:00:00',1, 'AVAILABLE');
INSERT INTO turns (id, code, process_type, fecha, user_id, status) VALUES ('2','T2', 'TRANSFERS', '2023-01-11 08:30:00',2, 'AVAILABLE');
INSERT INTO turns (id, code, process_type, fecha, user_id, status) VALUES ('3','T3', 'TRANSFERS', '2023-01-11 09:00:00',3, 'AVAILABLE');
