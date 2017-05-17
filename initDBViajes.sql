/* 
 * Datos de pruebas para inicializar cada una de las Entities en la base de datos.
 */
/**
 * Author:  ac.fandino10
 * Created: 19/04/2017
 */

--Primero se eliminan las tablas para reiniciar los datos


delete from MultaEntity;
delete from ViajeEntity;
delete from ReservaEntity;
delete from VehiculoEntity;
delete from UsuarioEntity;
delete from CiudadEntity;


--Datos de Ciudad Entity

insert into CiudadEntity (nombre) values ('Cartagena');
insert into CiudadEntity (nombre) values ('Bogota');
insert into CiudadEntity (nombre) values ('Medellin');
insert into CiudadEntity (nombre) values ('Cali');

--Datos de Usuario Entity (necesita tener creadas las multas del id respectivo)

insert into UsuarioEntity (id,email,licencia,nombre,numero,telefono)
            values(1,'email@mai.com','1324465342','Harry Plotter','1111',3456574);
insert into UsuarioEntity (id,email,licencia,nombre,numero,telefono)
            values(2,'email@mai.com','1324465342','Harry Plotter','1342124',3456574);
insert into UsuarioEntity (id,email,licencia,nombre,numero,telefono)
            values(3,'email@mai.com','1324465342','Harry Plotter','234554',3456574);
insert into UsuarioEntity (id,email,licencia,nombre,numero,telefono)
            values(4,'email@mai.com','1324465342','Harry Plotter','3451234',3456574);
insert into UsuarioEntity (id,email,licencia,nombre,numero,telefono)
            values(20,'email@mai.com','1324465342','Usuario a borrar','3451234',3456574);



--Datos de Vehiculo Entity (necesita tener creados los usuarios respectivos)

insert into VehiculoEntity (id, aseguradora, capacidad, color, marca, numeroseguro, placa, usuario_id)
            values(1,'Asegurando',3,'gris','Chevrolet',4135365,'ASF234',1);
insert into VehiculoEntity (id, aseguradora, capacidad, color, marca, numeroseguro, placa, usuario_id)
            values(2,'Asegurando',3,'gris','Chevrolet',4135365,'ASF234',2);
insert into VehiculoEntity (id, aseguradora, capacidad, color, marca, numeroseguro, placa, usuario_id)
            values(3,'Asegurando',3,'gris','Chevrolet',4135365,'ASF234',3);
insert into VehiculoEntity (id, aseguradora, capacidad, color, marca, numeroseguro, placa, usuario_id)
            values(4,'Asegurando',3,'gris','Chevrolet',4135365,'ASF234',4);


--Datos de ViajeEntity (necesitan tener creados los vehiculos respectivos)

insert into ViajeEntity (id,ciudaddestino,ciudadorigen,direcciondejar,direccionrecoger,
                            fechallegada,fechapartida,gastogasolina,gastootros,gastopeaje,horallegada,
                            horasalida,kilometros,numpasajeros,vehiculo_id)
                values (1,'Medellin','Cartagena','los chicos del barrio', 'carrera 8',DATE('2015-12-17'), DATE('2015-12-17'),
                        130.4,45.3,20.3,DATE('2015-12-17'),DATE('2015-12-17'),105,2,1);

insert into ViajeEntity (id,ciudaddestino,ciudadorigen,direcciondejar,direccionrecoger,
                            fechallegada,fechapartida,gastogasolina,gastootros,gastopeaje,horallegada,
                            horasalida,kilometros,numpasajeros,vehiculo_id)
                values (2,'Medellin','Cartagena','los chicos del barrio', 'carrera 8',DATE('2015-12-17'), DATE('2015-12-17'),
                        130.4,45.3,20.3,DATE('2015-12-17'),DATE('2015-12-17'),105,2,2);

insert into ViajeEntity (id,ciudaddestino,ciudadorigen,direcciondejar,direccionrecoger,
                            fechallegada,fechapartida,gastogasolina,gastootros,gastopeaje,horallegada,
                            horasalida,kilometros,numpasajeros,vehiculo_id)
                values (3,'Medellin','Cartagena','los chicos del barrio', 'carrera 8',DATE('2015-12-17'), DATE('2015-12-17'),
                        130.4,45.3,20.3,DATE('2015-12-17'),DATE('2015-12-17'),105,2,3);

insert into ViajeEntity (id,ciudaddestino,ciudadorigen,direcciondejar,direccionrecoger,
                            fechallegada,fechapartida,gastogasolina,gastootros,gastopeaje,horallegada,
                            horasalida,kilometros,numpasajeros,vehiculo_id)
                values (4,'Medellin','Cartagena','los chicos del barrio', 'carrera 8',DATE('2015-12-17'), DATE('2015-12-17'),
                        130.4,45.3,20.3,DATE('2015-12-17'),DATE('2015-12-17'),105,2,4);


--Datos de Reserva Entity (necesita tener usuario id y viaje id)
--insert into ReservaEntity (id,comision,pasajeros,precio,usuario_id,viaje_id)
            --values (1,13.43,3,220.0,4,2);

--Datos de Multa Entity (necesita tener creados las reservas y los usuarios respectivos)

insert into MultaEntity (id,valor,fecha, descripcion,estado,fechapago,usuario_id)
            values (1,10.33,DATE('2015-12-17'),'Multa por echar chistes malos',1,DATE('2015-12-17'),4);




