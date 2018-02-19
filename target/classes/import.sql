insert into employee(pesel, firstname, secondname, dateOfBirth, dateOfEmployment) values(72020500216, 'Zbigniew', 'Stasik','1972-02-05', '2000-03-02');
insert into employee(pesel, firstname, secondname, dateOfBirth, dateOfEmployment) values(75061504501, 'Adam', 'Nowak','1975-06-15', '2001-04-05');
insert into employee(pesel, firstname, secondname, dateOfBirth, dateOfEmployment) values(68042503389, 'Marcin', 'Kowalski','1968-04-25', '2001-04-07');
insert into employee(pesel, firstname, secondname, dateOfBirth, dateOfEmployment) values(82020500536, 'Jan', 'Tomaszewski','1982-02-05', '2001-05-11');
insert into employee(pesel, firstname, secondname, dateOfBirth, dateOfEmployment) values(92110801256, 'Tomasz', 'Lis','1992-11-08', '2003-08-22');

insert into privatecar(brand, capacity, mileage, employee) values(1, 6000, 330000,68042503389);
insert into privatecar(brand, capacity, mileage, employee) values(0, 2500, 240000,75061504501);

insert into car(brand, capacity, mileage, typeOfProperty) values(0, 2500, 200000,1);
insert into car(brand, capacity, mileage, typeOfProperty) values(2, 4000, 180000,1);
insert into car(brand, capacity, mileage, typeOfProperty) values(1, 6000, 330000,2);
insert into car(brand, capacity, mileage, typeOfProperty) values(0, 2500, 240000,2);
insert into car(brand, capacity, mileage, typeOfProperty) values(3, 4500, 120000,0);
insert into car(brand, capacity, mileage, typeOfProperty) values(2, 3000, 235000,1);
insert into car(brand, capacity, mileage, typeOfProperty) values(3, 5000, 127000,0);

insert into assignment( startOfAssignment, employee, car ) values('2001-04-08', 68042503389, 5);
insert into assignment( startOfAssignment, employee, car ) values('2001-04-08', 75061504501, 3);
insert into assignment( startOfAssignment, employee, car ) values('2000-03-03', 72020500216, 6);
insert into assignment( startOfAssignment, employee, car ) values('2001-05-12', 82020500536, 1);
insert into assignment( startOfAssignment, employee, car ) values('2003-08-25', 92110801256, 2);
insert into assignment( startOfAssignment, employee, car ) values('2000-03-18', 72020500216, 4);
insert into assignment( startOfAssignment, employee, car ) values('2001-05-27', 82020500536, 7);
