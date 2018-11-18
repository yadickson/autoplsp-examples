CREATE PROCEDURE SpListarTabla
    @Id INT
AS
    SELECT Id, Patente, Marca, Modelo FROM Vehiculos;
RETURN