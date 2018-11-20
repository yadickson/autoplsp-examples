/**
 * Author:  Yadickson Soto
 */

CREATE OR REPLACE FUNCTION FN_PARAMETERS(id integer, name text, c integer, m text)
RETURNS real
AS $$
BEGIN
    return id * 0.6;
END;
$$ LANGUAGE plpgsql;