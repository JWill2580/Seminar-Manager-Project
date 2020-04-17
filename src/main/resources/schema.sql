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

StaffID INT,
Username varchar(20) NOT NULL UNIQUE,
Password varchar(100) NOT NULL,
FirstName varchar(100) NOT NULL,
LastName varchar(100) NOT NULL,
Bio TEXT,
StaffEmail varchar(50) NOT NULL,
CONSTRAINT Staff_PK PRIMARY KEY (StaffID)
);

CREATE TABLE Seminar(

SeminarID INT,
Topic varchar(255) NOT NULL,
Title varchar(255) NOT NULL,
Abstract TEXT NOT NULL,
Location Varchar(255) NOT NULL,
Modality Varchar(255) NOT NULL,
Day_Date DATE NOT NULL,
StaffID int,
CONSTRAINT Seminar_PK PRIMARY KEY (SeminarID),
CONSTRAINT StaffSeminar_FK FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)

);

INSERT INTO Staff (StaffID, Username, Password, FirstName, LastName, Bio, StaffEmail) VALUES (1,'oolong1234','Meeps445','John','Ong','This is my talk', 'oolong1234@gmail.com');

INSERT INTO Seminar (SeminarID, Topic, Title, Abstract, Location, Modality, Day_Date, StaffID) VALUES (1, 'Tea', 'Types of Tea', 'This is where it started', 'OBS2.57', 'Spreading joy', '17-APR-2020', 1);
