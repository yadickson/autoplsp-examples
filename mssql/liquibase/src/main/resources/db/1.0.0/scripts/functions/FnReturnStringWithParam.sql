CREATE FUNCTION FnReturnStringWithParam
(
   @Text VARCHAR(30)
)
RETURNS VARCHAR(200) AS
BEGIN
   declare @value varchar(200)   
   set @value = 'Hello world [' + @Text + ']'
   RETURN @value
END