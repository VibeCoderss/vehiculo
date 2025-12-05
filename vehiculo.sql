CREATE TABLE Persona (
                         idPersona      SERIAL PRIMARY KEY,
                         nombre         TEXT NOT NULL,
                         primerApellido TEXT NOT NULL,
                         segundoApellido TEXT
);

CREATE TABLE Cliente (
                         idCliente      SERIAL PRIMARY KEY,
                         idPersona      INT NOT NULL UNIQUE,
                         rfc            TEXT NOT NULL,
                         telefono       TEXT,
                         correo         TEXT,
                         FOREIGN KEY (idPersona) REFERENCES persona(idPersona)
);

CREATE TABLE Vendedor (
                          idVendedor      SERIAL PRIMARY KEY,
                          idPersona       INT NOT NULL UNIQUE,
                          codigoEmpleado  TEXT NOT NULL,
                          FOREIGN KEY (idPersona) REFERENCES persona(idPersona)
);

CREATE TYPE EstadoVehiculo AS ENUM ('DISPONIBLE', 'APARTADO', 'VENDIDO');

CREATE TABLE Vehiculo (
                          idVehiculo   SERIAL PRIMARY KEY,
                          marca        TEXT NOT NULL,
                          modelo       TEXT NOT NULL,
                          anio         INT NOT NULL,
                          color        TEXT NOT NULL,
                          precioLista  DECIMAL(10,2) NOT NULL,
                          matricula    TEXT UNIQUE,
                          estado       EstadoVehiculo NOT NULL,
                          condicion    TEXT
);

CREATE TABLE Automovil (
                           idAutomovil INT PRIMARY KEY,
                           FOREIGN KEY (idAutomovil) REFERENCES vehiculo(idVehiculo)
);

CREATE TABLE Motocicleta (
                             idMotocicleta INT PRIMARY KEY,
                             FOREIGN KEY (idMotocicleta) REFERENCES vehiculo(idVehiculo)
);

CREATE TABLE Venta (
                       idVenta      SERIAL PRIMARY KEY,
                       fechaVenta   DATE NOT NULL,
                       fechaPago    DATE,
                       idCliente    INT NOT NULL,
                       idVendedor   INT NOT NULL,
                       idVehiculo   INT NOT NULL,
                       FOREIGN KEY (idCliente)  REFERENCES cliente(idCliente),
                       FOREIGN KEY (idVendedor) REFERENCES vendedor(idVendedor),
                       FOREIGN KEY (idVehiculo) REFERENCES vehiculo(idVehiculo)
);

CREATE TYPE FormaPago AS ENUM ('TRANSFERENCIA', 'EFECTIVO');

CREATE TABLE Contado (
                         idContado   SERIAL PRIMARY KEY,
                         idVenta     INT NOT NULL UNIQUE,
                         formaPago   FormaPago NOT NULL,
                         FOREIGN KEY (idVenta) REFERENCES venta(idVenta)
);

CREATE TYPE EstadoCredito AS ENUM ('AUTORIZADO', 'NO_AUTORIZADO');

CREATE TABLE Financiamiento (
                                idFinanciamiento SERIAL PRIMARY KEY,
                                idVenta          INT NOT NULL UNIQUE,
                                tasaInteres      INT NOT NULL CHECK (tasaInteres > 0),
                                enganche         INT NOT NULL CHECK (enganche >= 0),
                                plazo            INT NOT NULL CHECK (plazo > 0),
                                cuotaMensual     INT NOT NULL CHECK (cuotaMensual > 0),
                                estado           EstadoCredito NOT NULL,
                                FOREIGN KEY (idVenta) REFERENCES venta(idVenta)
);