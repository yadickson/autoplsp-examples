CREATE PROCEDURE SpFiltrarVehiculos   
    @Marca nvarchar(50),
    @Modelo nvarchar(50)
AS   

    SELECT Id, Patente, Marca, Modelo  
    FROM Vehiculos  
    WHERE Marca = @Marca AND Modelo = @Modelo;