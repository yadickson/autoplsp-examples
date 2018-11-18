CREATE PROCEDURE SpObtenerVehiculo
    @Id BIGINT,
    @Patente varchar(7) OUTPUT,
    @Marca varchar(50) OUTPUT,
    @Modelo varchar(50) OUTPUT
AS   

    SELECT @Patente = Patente, @Marca = Marca, @Modelo = Modelo
    FROM Vehiculos  
    WHERE Id = @Id;