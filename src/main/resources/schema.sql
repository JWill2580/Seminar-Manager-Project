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
Username VARCHAR(20) NOT NULL UNIQUE,
Password VARCHAR(100) NOT NULL,
FirstName VARCHAR(100) NOT NULL,
LastName VARCHAR(100) NOT NULL,
Bio TEXT,
StaffEmail VARCHAR(50) NOT NULL,
CONSTRAINT Staff_PK PRIMARY KEY (StaffID)
);

CREATE TABLE Seminar(

SeminarID INT,
Topic VARCHAR(255) NOT NULL,
Title VARCHAR(255) NOT NULL,
Abstract TEXT NOT NULL,
Location VARCHAR(255) NOT NULL,
Modality VARCHAR(255) NOT NULL,
Day_Date DATE NOT NULL,
StaffID INT,
CONSTRAINT Seminar_PK PRIMARY KEY (SeminarID),
CONSTRAINT StaffSeminar_FK FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)

);

INSERT INTO Staff (StaffID, Username, Password, FirstName, LastName, Bio, StaffEmail) VALUES (1,'oolong1234','Meeps445','John','Ong','This is my talk', 'oolong1234@gmail.com');

INSERT INTO Seminar (SeminarID, Topic, Title, Abstract, Location, Modality, Day_Date, StaffID) VALUES (1, 'Tea', 'Types of Tea', 'This is where it started', 'OBS2.57', 'Spreading joy', '17-APR-2020', 1);
