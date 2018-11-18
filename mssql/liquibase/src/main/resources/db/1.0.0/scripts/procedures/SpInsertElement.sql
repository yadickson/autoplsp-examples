CREATE PROCEDURE SpInsertElement
    @Patente varchar(7),
    @Marca varchar(50),
    @Modelo varchar(50)
AS

    INSERT INTO Vehiculos (Patente, Marca, Modelo)  
    VALUES (@Patente, @Marca, @Modelo);