CREATE OR REPLACE FUNCTION FN_TEST
RETURN NUMBER
AS

BEGIN

   RETURN 0;

EXCEPTION            
   WHEN OTHERS
   THEN
      RETURN 1;

END;
