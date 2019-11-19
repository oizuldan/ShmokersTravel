USE ShmokersTravel;

INSERT INTO train_station(name, address) VALUES('Almaty', 'Al-Farabi 7');
INSERT INTO train_station(name, address) VALUES('Astana', 'Kabanbay Batyr 53');
INSERT INTO train_station(name, address) VALUES('Semey', 'Pushkin 100');
INSERT INTO train_station(name, address) VALUES('Karaganda', 'Buhar-Zhyrau 10');
INSERT INTO train_station(name, address) VALUES('Shymkent', 'Abay 1');


INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Almaty', 'Astana', '2019-11-01T15:10', '2019-11-02T10:00', 1); -- 1
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Almaty', 'Semey', '2019-11-01T12:00', '2019-11-02T09:00', 2); -- 2
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Astana', 'Almaty', '2019-11-01T12:00', '2019-11-02T14:15', 3); -- 3
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Astana', 'Karaganda', '2019-11-01T06:30', '2019-11-02T01:45', 4); -- 4
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Karaganda', 'Almaty', '2019-11-01T03:30', '2019-11-02T07:00', 5); -- 5
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Semey', 'Almaty', '2019-11-01T09:00', '2019-11-02T15:25', 6); -- 6
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Semey', 'Karaganda', '2019-11-01T21:25', '2019-11-02T23:10', 7); -- 7
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Semey', 'Astana', '2019-11-01T23:59', '2019-11-02T00:01', 8); -- 8
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Shymkent', 'Astana', '2019-11-01T06:00', '2019-11-02T07:00', 9); -- 9
INSERT INTO trip(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date, train_number)
VALUES('Shymkent', 'Almaty', '2019-11-01T12:11', '2019-11-02T11:12', 10); -- 10

INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(1, 'Almaty', 'Astana');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(2, 'Karaganda', 'Semey');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(3, 'Astana', 'Almaty');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(4, 'Astana', 'Karaganda');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(5, 'Karaganda', 'Karaganda');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(6, 'Semey', 'Almaty');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(7, 'Semey', 'Karaganda');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(8, 'Semey', 'Astana');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(9, 'Shymkent', 'Astana');
INSERT INTO train(trip_id, departure_train_station_name, arrival_train_station_name)
VALUES(10, 'Shymkent', 'Almaty');

INSERT INTO vagon(vagon_number, train_number) VALUES(1, 1);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 2);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 3);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 4);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 5);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 6);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 7);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 8);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 9);
INSERT INTO vagon(vagon_number, train_number) VALUES(1, 10);

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

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,7);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,7);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,7);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,7);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,7);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,8);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,8);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,8);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,8);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,8);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,9);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,9);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,9);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,9);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,9);

INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(1,1,10);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(2,1,10);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(3,1,10);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(4,1,10);
INSERT INTO seat(seat_number, vagon_number, train_number) VALUES(5,1,10);

INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(1, 1, 'Almaty', NULL, '2019-11-01 15:10', 1);
INSERT INTO trip_station(trip_id, station_index, train_station_name, arrival_date, departure_date, train_number)
VALUES(1, 2, 'Astana', '2019-11-02 10:00', NULL, 1);

INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, departure_date, arrival_date) VALUES(1, 1, 1, 1, 2, 1, 500, '2019-11-01T15:10', '2019-11-02T10:00');
INSERT INTO available_seat(seat_number, vagon_number, trip_id, from_station, to_station, train_number, ticket_price, departure_date, arrival_date) VALUES(2, 1, 1, 1, 2, 1, 500, '2019-11-01T15:10', '2019-11-02T10:00');


