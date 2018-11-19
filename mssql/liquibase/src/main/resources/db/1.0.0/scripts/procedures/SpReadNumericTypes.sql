CREATE PROCEDURE SpReadNumericTypes
    @Id BIGINT,
    @CInt INT OUTPUT,
    @CBigInt BIGINT OUTPUT,
    @CSmallInt SMALLINT OUTPUT,
    @CTinyInt TINYINT OUTPUT,
    @CDecimal DECIMAL OUTPUT,
    @CNumeric NUMERIC OUTPUT,
    @CFloat FLOAT OUTPUT,
    @CReal REAL OUTPUT,
    @CBit BIT OUTPUT,
    @CMoney MONEY OUTPUT,
    @CSmallMoney SMALLMONEY OUTPUT
AS
    SELECT @CInt = CInt, @CBigInt = CBigInt, @CSmallInt = CSmallInt, @CTinyInt = CTinyInt, @CDecimal = CDecimal, @CNumeric = CNumeric, @CFloat = CFloat, @CReal = CReal, @CBit = CBit, @CMoney = CMoney, @CSmallMoney = CSmallMoney
    FROM NumericTypes
    WHERE ID = @Id
