USE ShmokersTravel;

INSERT INTO TrainStation(name, address) VALUES('Almaty', 'Al-Farabi 7');
INSERT INTO TrainStation(name, address) VALUES('Astana', 'Kabanbay Batyr 53');
INSERT INTO TrainStation(name, address) VALUES('Semey', 'Pushkin 100');
INSERT INTO TrainStation(name, address) VALUES('Karaganda', 'Buhar-Zhyrau 10');
INSERT INTO TrainStation(name, address) VALUES('Shymkent', 'Abay 1');


INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Almaty', 'Astana', '2019-11-01T15:10', '2019-11-02T10:00'); -- 1
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Almaty', 'Semey', '2019-11-01T12:00', '2019-11-02T09:00'); -- 2
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Astana', 'Almaty', '2019-11-01T12:00', '2019-11-02T14:15'); -- 3
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Astana', 'Karaganda', '2019-11-01T06:30', '2019-11-02T01:45'); -- 4
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Karaganda', 'Almaty', '2019-11-01T03:30', '2019-11-02T07:00'); -- 5
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Semey', 'Almaty', '2019-11-01T09:00', '2019-11-02T15:25'); -- 6
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Semey', 'Karaganda', '2019-11-01T21:25', '2019-11-02T23:10'); -- 7
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Semey', 'Astana', '2019-11-01T23:59', '2019-11-02T00:01'); -- 8
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Shymkent', 'Astana', '2019-11-01T06:00', '2019-11-02T07:00'); -- 9
INSERT INTO Route(departure_train_station_name, arrival_train_station_name, departure_date, arrival_date)
VALUES('Shymkent', 'Almaty', '2019-11-01T12:11', '2019-11-02T11:12'); -- 10

INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(1, 'Almaty', 'Astana');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(2, 'Karaganda', 'Semey');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(3, 'Astana', 'Almaty');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(4, 'Astana', 'Karaganda');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(5, 'Karaganda', 'Karaganda');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(6, 'Semey', 'Almaty');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(7, 'Semey', 'Karaganda');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(8, 'Semey', 'Astana');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(9, 'Shymkent', 'Astana');
INSERT INTO Train(route_id, departure_train_station_name, arrival_train_station_name)
VALUES(10, 'Shymkent', 'Almaty');

INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 1);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 2);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 3);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 4);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 5);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 6);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 7);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 8);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 9);
INSERT INTO Vagon(vagon_number, train_number) VALUES(1, 10);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,1);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,1);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,1);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,1);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,1);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,2);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,2);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,2);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,2);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,2);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,3);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,3);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,3);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,3);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,3);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,4);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,4);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,4);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,4);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,4);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,5);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,5);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,5);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,5);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,5);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,6);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,6);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,6);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,6);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,6);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,7);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,7);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,7);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,7);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,7);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,8);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,8);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,8);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,8);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,8);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,9);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,9);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,9);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,9);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,9);

INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(1,1,10);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(2,1,10);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(3,1,10);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(4,1,10);
INSERT INTO Seat(seat_number, vagon_number, train_number) VALUES(5,1,10);

INSERT INTO RouteStation(route_id, station_index, train_station_name, arrival_date, departure_date)
VALUES(1, 1, 'Almaty', NULL, '2019-11-01 15:10');
INSERT INTO RouteStation(route_id, station_index, train_station_name, arrival_date, departure_date)
VALUES(1, 2, 'Astana', '2019-11-02 10:00', NULL);

INSERT INTO AvailableRoute(seat_number, vagon_number, route_id, from_station, to_station, train_number, ticket_price) VALUES(1, 1, 1, 1, 2, 1, 500);
INSERT INTO AvailableRoute(seat_number, vagon_number, route_id, from_station, to_station, train_number, ticket_price) VALUES(2, 1, 1, 1, 2, 1, 500);
INSERT INTO AvailableRoute(seat_number, vagon_number, route_id, from_station, to_station, train_number, ticket_price) VALUES(3, 1, 1, 1, 2, 1, 500);
INSERT INTO AvailableRoute(seat_number, vagon_number, route_id, from_station, to_station, train_number, ticket_price) VALUES(4, 1, 1, 1, 2, 1, 500);
INSERT INTO AvailableRoute(seat_number, vagon_number, route_id, from_station, to_station, train_number, ticket_price) VALUES(5, 1, 1, 1, 2, 1, 500);


