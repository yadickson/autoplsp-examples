CREATE FUNCTION FnReturnString()
RETURNS VARCHAR(30) AS
BEGIN
   declare @value varchar(30)   
   set @value = 'Hello world'
   RETURN @value
END