/**
 * Author:  Yadickson Soto
 */

CREATE OR REPLACE FUNCTION FN_PARAMETER(id integer)
RETURNS real
AS $$
BEGIN
    return id * 0.6;
END;
$$ LANGUAGE plpgsql;