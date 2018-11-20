/**
 * Author:  Yadickson Soto
 */

CREATE OR REPLACE PROCEDURE SP_PARAMETERS(id integer, inout c integer, inout m text)
AS $$
BEGIN
    c := 0;
    m := 'OK';
END;
$$ LANGUAGE plpgsql;