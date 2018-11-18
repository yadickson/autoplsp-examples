CREATE PROCEDURE SpObtenerVehiculos
    @Vehiculos CURSOR VARYING OUTPUT
AS   

    SET @Vehiculos = CURSOR
    FORWARD_ONLY STATIC FOR
    SELECT Id, Patente, Marca, Modelo FROM Vehiculos;
    OPEN @Vehiculos;
