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
Username VARCHAR(20) NOT NULL unique,
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
Topic VARCHAR(255) NOT NULL,
Title VARCHAR(255) NOT NULL,
Abstract TEXT NOT NULL,
Location VARCHAR(255) NOT NULL,
Modality TEXT NOT NULL,
Day_Date VARCHAR(20) NOT NULL,
DisplayName varchar(50) NOT NULL,
--
CONSTRAINT Seminar_PK PRIMARY KEY (SeminarID),
CONSTRAINT CHK_MODALITY CHECK (Modality = 'Zoom' OR Modality = 'University')

);



--Test Data
INSERT INTO Staff (Username, Password, FirstName, Surname, Bio, Email) VALUES ('oolong1234','Meeps445','John','Ong','This is my talk', 'oolong1234@gmail.com');
INSERT INTO Seminar (Topic, Title, Abstract, Location, Modality, Day_Date, DisplayName) VALUES ('Tea', 'Types of Tea', 'This is where it started', 'OBS2.57', 'Zoom', '17-APR-2020', 'oolong1234');
