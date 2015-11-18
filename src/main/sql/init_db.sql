create TABLE busker (
  buskerid bigint not null default nextval('busker_buskerid_seq'::regclass),
  userid bigint,
  name text not null,
  PRIMARY KEY (buskerid),
  FOREIGN KEY (userid) REFERENCES member (userid)
);
CREATE UNIQUE INDEX busker_pkey ON busker (buskerid);


create TABLE location (
  locationid bigint not null default nextval('location_locationid_seq'::regclass),
  latitude numeric,
  longitude numeric,
name text,
PRIMARY KEY (locationid)
);
CREATE UNIQUE INDEX location_pkey ON location (locationid);
CREATE UNIQUE INDEX location_latitude_longitude_idx ON location (latitude, longitude);


create TABLE location_busker (
  buskerid bigint,
  userid bigint,
FOREIGN KEY (buskerid) REFERENCES busker (buskerid),
FOREIGN KEY (userid) REFERENCES member (userid)
);



create TABLE member (
  userid bigint not null default nextval('user_userid_seq'::regclass),
  username text not null,
PRIMARY KEY (userid)
);
CREATE UNIQUE INDEX user_pkey ON member (userid);
CREATE UNIQUE INDEX member_username_idx ON member (username);



create TABLE rating (
  memberid bigint,
  buskerid bigint,
  locationid bigint,
  "value" integer,
  ratingid integer not null default nextval('rating_ratingid_seq'::regclass),
PRIMARY KEY (ratingid),
FOREIGN KEY (buskerid) REFERENCES busker (buskerid),
FOREIGN KEY (locationid) REFERENCES location (locationid)
);
CREATE UNIQUE INDEX rating_ratingid_pk ON rating (ratingid);
CREATE UNIQUE INDEX rating_ratingid_uindex ON rating (ratingid);