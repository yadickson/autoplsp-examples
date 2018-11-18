CREATE PROCEDURE SpListarTablas
    @Id INT
AS
    SELECT Codigo, Nombre, Valor, FechaModificacion FROM Parametros;
    SELECT Id, Patente, Marca, Modelo FROM Vehiculos;
    SELECT Id, Modelo FROM Vehiculos;
    SELECT Id, Patente, Modelo FROM Vehiculos;
    SELECT Marca, Modelo FROM Vehiculos;
RETURN