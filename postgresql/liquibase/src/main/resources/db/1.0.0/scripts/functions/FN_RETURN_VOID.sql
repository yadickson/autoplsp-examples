/**
 * Author:  Yadickson Soto
 */

CREATE OR REPLACE FUNCTION FN_RETURN_VOID(integer,integer)
RETURNS VOID AS $$
BEGIN
    null;
END;
$$ LANGUAGE plpgsql;
