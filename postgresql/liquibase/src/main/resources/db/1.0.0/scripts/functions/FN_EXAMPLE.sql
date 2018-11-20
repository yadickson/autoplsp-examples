/**
 * Author:  Yadickson Soto
 */

CREATE OR REPLACE FUNCTION FN_EXAMPLE(in value real)
RETURNS real
AS $$
BEGIN

    return value;
END;

$$ LANGUAGE plpgsql;