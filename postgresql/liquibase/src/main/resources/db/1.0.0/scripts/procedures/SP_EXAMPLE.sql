CREATE PROCEDURE SP_EXAMPLE(a integer, b integer)
LANGUAGE SQL
AS $$
    select * from T_VERSION;
$$;