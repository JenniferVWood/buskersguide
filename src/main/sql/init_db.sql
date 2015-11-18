

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