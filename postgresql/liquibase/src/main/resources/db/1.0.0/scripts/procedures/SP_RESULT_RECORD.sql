/**
 * Author:  Yadickson Soto
 */

CREATE OR REPLACE PROCEDURE SP_RESULT_RECORD(id integer)
AS $$
BEGIN
    SELECT VERSION FROM T_VERSION;
END;
$$ LANGUAGE plpgsql;