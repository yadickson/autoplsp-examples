CREATE PROCEDURE SpNumericTypes
AS
    SELECT Id, CInt, CBigInt, CSmallInt, CTinyInt, CDecimal, CNumeric, CFloat, CReal, CBit, CMoney, CSmallMoney
    FROM NumericTypes;
