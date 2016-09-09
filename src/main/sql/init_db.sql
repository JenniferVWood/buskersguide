-- Enable PostGIS (includes raster)
CREATE EXTENSION postgis;
-- Enable Topology
CREATE EXTENSION postgis_topology;
-- Enable PostGIS Advanced 3D
-- and other geoprocessing algorithms
CREATE EXTENSION postgis_sfcgal;
-- fuzzy matching needed for Tiger
CREATE EXTENSION fuzzystrmatch;
-- rule based standardizer
CREATE EXTENSION address_standardizer;
-- example rule data set
CREATE EXTENSION address_standardizer_data_us;
-- Enable US Tiger Geocoder
CREATE EXTENSION postgis_tiger_geocoder;


create TABLE if not exists users (
  userid BIGSERIAL not null PRIMARY KEY ,
  username text not null,
  password text,
  enabled BOOLEAN,
  createdDateTime TIMESTAMP default now()
);
CREATE UNIQUE INDEX user_username_idx ON users (username);

create table if not exists authorities (
  username varchar(50) not null,
  authority varchar(50) not null
);
create unique index user_authorities_idx on authorities(username, authority);

create TABLE busker (
  buskerid BIGSERIAL PRIMARY KEY,
  userid bigint,
  name text not null,
  FOREIGN KEY (userid) REFERENCES users (userid),
  createdDateTime TIMESTAMP default now()
);


create TABLE location (
  locationid BIGSERIAL PRIMARY KEY,
  latitude numeric,
  longitude numeric,
  name text,
  longdescription TEXT,
  geog geography(Point,4326),
  createdDateTime TIMESTAMP default now()
);
CREATE UNIQUE INDEX location_latitude_longitude_idx ON location (latitude, longitude);



create TABLE location_busker (
  buskerid bigint,
  userid bigint,
FOREIGN KEY (buskerid) REFERENCES busker (buskerid),
FOREIGN KEY (userid) REFERENCES users (userid)
);



create TABLE rating (
  userid bigint,
  buskerid bigint,
  locationid bigint,
  "value" integer,
  ratingid BIGSERIAL,
  createdDateTime timestamp default now(),
    PRIMARY KEY (ratingid),
FOREIGN KEY (buskerid) REFERENCES busker (buskerid),
FOREIGN KEY (userid) REFERENCES users (userid),
FOREIGN KEY (locationid) REFERENCES location (locationid)
);
CREATE UNIQUE INDEX rating_ratingid_pk ON rating (ratingid);
CREATE UNIQUE INDEX rating_ratingid_uindex ON rating (ratingid);



create table comment (
  commentid bigserial primary key,
  userid bigint not null REFERENCES users (userid),
  locationid bigint NOT NULL REFERENCES location(locationid),
  commenttext text,
  createddatetime TIMESTAMP
)
;


create table Invite (
  inviteId text PRIMARY KEY,
  userId bigint not null references users(userId),
  grantedTo BIGINT references users(userId),
  createdDateTime timestamp default now()
);

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
BEGIN

  NEW.geog := ST_MakePoint(NEW.longitude, NEW.latitude);

  RETURN NEW;

END
$func$ LANGUAGE plpgsql;

CREATE TRIGGER trig_location_pre_insert
BEFORE INSERT ON location
FOR EACH ROW
EXECUTE PROCEDURE fn_trig_location_pre_insert();