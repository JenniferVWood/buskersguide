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


create TABLE if not exists member (
  userid BIGSERIAL,
  username text not null,
  PRIMARY KEY (userid)
);
CREATE UNIQUE INDEX user_pkey ON member (userid);
CREATE UNIQUE INDEX member_username_idx ON member (username);


create TABLE busker (
  buskerid BIGSERIAL PRIMARY KEY,
  userid bigint,
  name text not null,
  FOREIGN KEY (userid) REFERENCES member (userid)
);


create TABLE location (
  locationid BIGSERIAL PRIMARY KEY,
  latitude numeric,
  longitude numeric,
name text
);
CREATE UNIQUE INDEX location_latitude_longitude_idx ON location (latitude, longitude);


create TABLE location_busker (
  buskerid bigint,
  userid bigint,
FOREIGN KEY (buskerid) REFERENCES busker (buskerid),
FOREIGN KEY (userid) REFERENCES member (userid)
);



create TABLE rating (
  memberid bigint,
  buskerid bigint,
  locationid bigint,
  "value" integer,
  ratingid BIGSERIAL,
PRIMARY KEY (ratingid),
FOREIGN KEY (buskerid) REFERENCES busker (buskerid),
FOREIGN KEY (locationid) REFERENCES location (locationid)
);
CREATE UNIQUE INDEX rating_ratingid_pk ON rating (ratingid);
CREATE UNIQUE INDEX rating_ratingid_uindex ON rating (ratingid);


ALTER TABLE location ADD COLUMN geog geography(Point,4326);
UPDATE location SET geog = ST_MakePoint(longitude, latitude);

\i trig_location_post_insert.sql;

create table comment (
  commentid bigserial primary key,
  memberid bigint not null REFERENCES member(userid),
  locationid bigint NOT NULL REFERENCES location(locationid),
  commenttext text,
  createddatetime TIMESTAMP
)
;

alter table location
add column longdescription TEXT;