create or replace FUNCTION FN_TEST_LOB
(
    PI_C1 IN CLOB,
    PI_C2 IN NCLOB,
    PI_C3 IN BLOB,
    PO_C4 OUT CLOB,
    PO_C5 OUT NCLOB,
    PO_C6 OUT BLOB
)
RETURN NUMBER
AS

BEGIN

   PO_C4 := TO_CLOB('clob');
   PO_C5 := TO_CLOB('any nchar literal');
   PO_C6 := EMPTY_BLOB();

   RETURN 0;

EXCEPTION            
   WHEN OTHERS
   THEN
      RETURN 1;

END;