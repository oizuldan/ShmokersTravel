USE ShmokersTravel;

INSERT INTO TrainStation(Name, Address) VALUES('Almaty', 'Al-Farabi 7');
INSERT INTO TrainStation(Name, Address) VALUES('Astana', 'Kabanbay Batyr 53');
INSERT INTO TrainStation(Name, Address) VALUES('Semey', 'Pushkin 100');
INSERT INTO TrainStation(Name, Address) VALUES('Karaganda', 'Buhar-Zhyrau 10');
INSERT INTO TrainStation(Name, Address) VALUES('Shymkent', 'Abay 1');

INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Almaty', 'Astana', '2019-11-01 15:10', '2019-11-02 10:00'); -- 1
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Almaty', 'Semey', '2019-11-01 12:00 ', '2019-11-02 09:00'); -- 2
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Astana', 'Almaty', '2019-11-01 12:00', '2019-11-02 14:15'); -- 3
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Astana', 'Karaganda', '2019-11-01 06:30', '2019-11-02 01:45'); -- 4
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Karaganda', 'Almaty', '2019-11-01 03:30', '2019-11-02 07:00'); -- 5
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Semey', 'Almaty', '2019-11-01 09:00', '2019-11-02 15:25'); -- 6
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Semey', 'Karaganda', '2019-11-01 21:25', '2019-11-02 23:10'); -- 7
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Semey', 'Astana', '2019-11-01 23:59', '2019-11-02 00:01'); -- 8
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Shymkent', 'Astana', '2019-11-01 06:00', '2019-11-02 07:00'); -- 9
INSERT INTO Route(DepartureTrainStationName, ArrivalTrainStationName, DepartureDate, ArrivalDate) 
VALUES('Shymkent', 'Almaty', '2019-11-01 12:11', '2019-11-02 11:12'); -- 10

INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(1, 'Almaty', 'Astana');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(2, 'Karaganda', 'Semey');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(3, 'Astana', 'Almaty');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(4, 'Astana', 'Karaganda');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(5, 'Karaganda', 'Karaganda');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(6, 'Semey', 'Almaty');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(7, 'Semey', 'Karaganda');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(8, 'Semey', 'Astana');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(9, 'Shymkent', 'Astana');
INSERT INTO Train(RouteID, DepartureTrainStationName, ArrivalTrainStationName) 
VALUES(10, 'Shymkent', 'Almaty');

INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 1);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 2);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 3);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 4);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 5);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 6);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 7);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 8);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 9);
INSERT INTO Vagon(VagonNumber, TrainNumber) VALUES(1, 10);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,1);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,1);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,1);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,1);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,1);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,2);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,2);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,2);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,2);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,2);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,3);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,3);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,3);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,3);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,3);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,4);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,4);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,4);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,4);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,4);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,5);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,5);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,5);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,5);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,5);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,6);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,6);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,6);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,6);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,6);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,7);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,7);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,7);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,7);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,7);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,8);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,8);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,8);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,8);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,8);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,9);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,9);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,9);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,9);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,9);

INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(1,1,10);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(2,1,10);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(3,1,10);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(4,1,10);
INSERT INTO Seat(SeatNumber, VagonNumber, TrainNumber) VALUES(5,1,10); 

INSERT INTO Stations(RouteId, StationIndex, TrainStationName, ArrivalTime, DepartureTime)
VALUES(1, 1, 'Almaty', NULL, '2019-11-01 15:10');
INSERT INTO Stations(RouteId, StationIndex, TrainStationName, ArrivalTime, DepartureTime)
VALUES(1, 2, 'Astana', '2019-11-02 10:00', NULL);

INSERT INTO AvailiableRoute(SeatNumber, VagonNumber, RouteId, FromStation, ToStation) VALUES(1, 1, 1, 1, 2);
INSERT INTO AvailiableRoute(SeatNumber, VagonNumber, RouteId, FromStation, ToStation) VALUES(2, 1, 1, 1, 2);
INSERT INTO AvailiableRoute(SeatNumber, VagonNumber, RouteId, FromStation, ToStation) VALUES(3, 1, 1, 1, 2);
INSERT INTO AvailiableRoute(SeatNumber, VagonNumber, RouteId, FromStation, ToStation) VALUES(4, 1, 1, 1, 2);
INSERT INTO AvailiableRoute(SeatNumber, VagonNumber, RouteId, FromStation, ToStation) VALUES(5, 1, 1, 1, 2);

