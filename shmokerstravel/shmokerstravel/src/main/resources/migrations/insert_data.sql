USE ShmokersTravel;

INSERT INTO train_station(name) VALUES('Nur-Sultan');
INSERT INTO train_station(name) VALUES('Kokshetau');
INSERT INTO train_station(name) VALUES('Petropavl');
INSERT INTO train_station(name) VALUES('Kostanay');
INSERT INTO train_station(name) VALUES('Pavlodar');

INSERT INTO train(departure_train_station_name, arrival_train_station_name)
VALUES('Nur-Sultan', 'Petropavl');
INSERT INTO train(departure_train_station_name, arrival_train_station_name)
VALUES('Petropavl', 'Nur-Sultan');
INSERT INTO train(departure_train_station_name, arrival_train_station_name)
VALUES('Kokshetau', 'Kostanay');
INSERT INTO train(departure_train_station_name, arrival_train_station_name)
VALUES('Kostanay', 'Kokshetau');
INSERT INTO train(departure_train_station_name, arrival_train_station_name)
VALUES('Nur-Sultan', 'Pavlodar');
INSERT INTO train(departure_train_station_name, arrival_train_station_name)
VALUES('Pavlodar', 'Nur-Sultan');


INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Nur-Sultan', 'Petropavl', '2019-11-01T08:00', '2019-11-01T16:00', 1); -- 1
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Petropavl', 'Nur-Sultan', '2019-11-01T17:00', '2019-11-02T01:00', 2); -- 2
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Kokshetau', 'Kostanay', '2019-11-01T12:00', '2019-11-01T15:00', 3); -- 3
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Kostanay', 'Kokshetau', '2019-11-01T16:00', '2019-11-01T19:00', 4); -- 4
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Nur-Sultan', 'Pavlodar', '2019-11-01T12:00', '2019-11-01T15:00', 5); -- 5
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Pavlodar', 'Nur-Sultan', '2019-11-01T16:00', '2019-11-01T19:00', 6); -- 6

INSERT INTO vagon(vagon_number, train_number) VALUES(1, 1);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 2);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 3);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 4);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 5);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 6);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,1);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,1);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,1);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,1);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,1);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,2);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,2);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,2);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,2);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,2);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,3);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,3);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,3);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,3);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,3);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,4);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,4);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,4);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,4);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,4);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,5);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,5);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,5);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,5);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,5);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,6);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,6);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,6);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,6);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,6);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(1, 1, 'Nur-Sultan', NULL, '2019-11-01T08:00', 1);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(1, 2, 'Kokshetau', '2019-11-01T11:00', '2019-11-01T11:00', 1);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(1, 3, 'Petropavl', '2019-11-01T16:00', null, 1);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(2, 1, 'Petropavl', NULL, '2019-11-01T17:00', 2);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(2, 2, 'Kokshetau', '2019-11-01T22:00', '2019-11-01T22:00', 2);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(2, 3, 'Nur-Sultan', '2019-11-02T01:00', null, 2);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(3, 1, 'Kokshetau', NULL, '2019-11-01T12:00', 3);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(3, 2, 'Kostanay', '2019-11-01T15:00', null, 3);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(4, 1, 'Kostanay', NULL, '2019-11-01T16:00', 4);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(4, 2, 'Kokshetau', '2019-11-01T19:00', null, 4);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(5, 1, 'Nur-Sultan', NULL, '2019-11-01T12:00', 5);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(5, 2, 'Pavlodar', '2019-11-01T15:00', null, 5);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(6, 1, 'Pavlodar', NULL, '2019-11-01T16:00', 6);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(6, 2, 'Nur-Sultan', '2019-11-01T19:00', null, 6);

INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(1, 1, 1, 1, 3, 1, 500, '2019-11-01T08:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(2, 1, 1, 1, 3, 1, 500, '2019-11-01T08:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(3, 1, 1, 1, 3, 1, 500, '2019-11-01T08:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(4, 1, 1, 1, 3, 1, 500, '2019-11-01T08:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(5, 1, 1, 1, 3, 1, 500, '2019-11-01T08:00');

INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(1, 1, 2, 1, 3, 2, 500, '2019-11-01T17:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(2, 1, 2, 1, 3, 2, 500, '2019-11-01T17:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(3, 1, 2, 1, 3, 2, 500, '2019-11-01T17:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(4, 1, 2, 1, 3, 2, 500, '2019-11-01T17:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(5, 1, 2, 1, 3, 2, 500, '2019-11-01T17:00');


INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(1, 1, 3, 1, 2, 3, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(2, 1, 3, 1, 2, 3, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(3, 1, 3, 1, 2, 3, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(4, 1, 3, 1, 2, 3, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(5, 1, 3, 1, 2, 3, 500, '2019-11-01T12:00');


INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(1, 1, 4, 1, 2, 4, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(2, 1, 4, 1, 2, 4, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(3, 1, 4, 1, 2, 4, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(4, 1, 4, 1, 2, 4, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(5, 1, 4, 1, 2, 4, 500, '2019-11-01T16:00');

INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(1, 1, 5, 1, 2, 5, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(2, 1, 5, 1, 2, 5, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(3, 1, 5, 1, 2, 5, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(4, 1, 5, 1, 2, 5, 500, '2019-11-01T12:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(5, 1, 5, 1, 2, 5, 500, '2019-11-01T12:00');

INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(1, 1, 6, 1, 2, 6, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(2, 1, 6, 1, 2, 6, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(3, 1, 6, 1, 2, 6, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(4, 1, 6, 1, 2, 6, 500, '2019-11-01T16:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, date) 
VALUES(5, 1, 6, 1, 2, 6, 500, '2019-11-01T16:00');

insert into user(password, phone, email, first_name, last_name)
values("123", "87082079818", "aisultan.kassenov@nu.edu.kz", "Aisultan", "Kassenov")


