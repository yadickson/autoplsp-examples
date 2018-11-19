CREATE PROCEDURE SpInsertNumericTypes
    @CInt INT,
    @CBigInt BIGINT,
    @CSmallInt SMALLINT,
    @CTinyInt TINYINT,
    @CDecimal DECIMAL,
    @CNumeric NUMERIC,
    @CFloat FLOAT,
    @CReal REAL,
    @CBit BIT,
    @CMoney MONEY,
    @CSmallMoney SMALLMONEY,
    @Id BIGINT OUTPUT
AS
    INSERT INTO NumericTypes (CInt, CBigInt, CSmallInt, CTinyInt, CDecimal, CNumeric, CFloat, CReal, CBit, CMoney, CSmallMoney)  
    VALUES (@CInt, @CBigInt, @CSmallInt, @CTinyInt, @CDecimal, @CNumeric, @CFloat, @CReal, @CBit, @CMoney, @CSmallMoney);

    select @Id = (SELECT SCOPE_IDENTITY());