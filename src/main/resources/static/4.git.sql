CREATE TABLE Persone
(
	Persone_Id SERIAL PRIMARY KEY,
	Name VARCHAR,
	Surname VARCHAR,
	Age Integer,
	Gender VARCHAR
);

CREATE TABLE Animals
(
	Animals_Id SERIAL PRIMARY KEY,
	Persone_id Integer,
	Kind VARCHAR,
	Breed VARCHAR,
	Age Integer,
	FOREIGN KEY (Persone_id) REFERENCES Persone (Persone_Id)
);