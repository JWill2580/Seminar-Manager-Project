/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  admin
 * Created: 9/04/2020
 */

CREATE TABLE Staff (
StaffID varchar(50) not null auto_increment,
Username VARCHAR(20) NOT NULL UNIQUE,
Password VARCHAR(100) NOT NULL,
FirstName VARCHAR(100) NOT NULL,
Surname VARCHAR(100) NOT NULL,
Bio TEXT NOT NULL,
Email VARCHAR(50) NOT NULL,
--
CONSTRAINT Staff_PK PRIMARY KEY (StaffID)
);

CREATE TABLE Seminar(
SeminarID varchar(50) not null auto_increment,
StaffID varchar(50),
--
Topic VARCHAR(255) NOT NULL,
Title VARCHAR(255) NOT NULL,
Abstract TEXT NOT NULL,
Location VARCHAR(255) NOT NULL,
Modality VARCHAR(255) NOT NULL,
Day_Date VARCHAR(20) NOT NULL,
--
CONSTRAINT Seminar_PK PRIMARY KEY (SeminarID),
CONSTRAINT StaffSeminar_FK FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)

);

--Test Data
INSERT INTO Staff (StaffID, Username, Password, FirstName, Surname, Bio, Email) VALUES (1,'oolong1234','Meeps445','John','Ong','This is my talk', 'oolong1234@gmail.com');
INSERT INTO Seminar (SeminarID, Topic, Title, Abstract, Location, Modality, Day_Date, StaffID) VALUES (1, 'Tea', 'Types of Tea', 'This is where it started', 'OBS2.57', 'Spreading joy', '17-APR-2020', 1);

INSERT INTO Staff (Username, Password, FirstName, Surname, Bio, Email) VALUES ('oolong1234','Meeps445','John','Ong','This is my talk', 'oolong1234@gmail.com');
INSERT INTO Seminar (Topic, Title, Abstract, Location, Modality, Day_Date, StaffID) VALUES ('Tea', 'Types of Tea', 'This is where it started', 'OBS2.57', 'Spreading joy', '17-APR-2020', 1);
