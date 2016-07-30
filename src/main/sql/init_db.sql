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
  enabled BOOLEAN
);
CREATE UNIQUE INDEX user_username_idx ON users (username);

create table if not exists authorities (
  username varchar(50) not null,
  authority varchar(50) not null
);
create unique index user_authorities_idx on authorities(username, authorities);

create TABLE busker (
  buskerid BIGSERIAL PRIMARY KEY,
  userid bigint,
  name text not null,
  FOREIGN KEY (userid) REFERENCES users (userid)
);


create TABLE location (
  locationid BIGSERIAL PRIMARY KEY,
  latitude numeric,
  longitude numeric,
  name text,
  longdescription TEXT,
  geog geography(Point,4326)
);
CREATE UNIQUE INDEX location_latitude_longitude_idx ON location (latitude, longitude);
\i trig_location_post_insert.sql;


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
