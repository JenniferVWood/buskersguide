----------------------------------------------------------------------------------------------
--
-- fn_trig_location_pre_insert.sql
--
-- populate location.geog on each insert.
--
-- This exists because mapping that data to/from hibernate is a configuration nightmare,
-- but we need this type to exist in order to do queries like "find locations close to x,y"
--
-----------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION fn_trig_location_pre_insert()
  RETURNS trigger AS
$func$
declare round_long float8;
declare round_lat float8;
BEGIN

  round_long := ROUND( NEW.longitude, 4);
  round_lat := ROUND( NEW.latitude, 4);

  NEW.geog := ST_MakePoint(round_long, round_lat);

  RETURN NEW;

END
$func$ LANGUAGE plpgsql;

CREATE TRIGGER trig_location_pre_insert
BEFORE INSERT ON location
FOR EACH ROW
EXECUTE PROCEDURE fn_trig_location_pre_insert();