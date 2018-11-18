CREATE OR REPLACE PROCEDURE SP_TEST_INSERT
(
  PI_ID IN NUMERIC,
  PI_NAME IN VARCHAR2,
  PO_COD_RETORNO OUT NUMBER,
  PO_MSG_RETORNO OUT VARCHAR2
)
AS

BEGIN

  PO_COD_RETORNO := 0;
  PO_MSG_RETORNO := 'OK';

  INSERT INTO TABLE_TEST (ID, "NAME") VALUES (PI_ID, PI_NAME);

EXCEPTION            
   WHEN OTHERS
   THEN
      PO_COD_RETORNO := 100;
      PO_MSG_RETORNO := 'NOK';

END;
