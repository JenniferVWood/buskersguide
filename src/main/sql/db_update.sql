BEGIN ;
alter table users
  add column createdDateTime TIMESTAMP default now();
alter table busker
  add column createdDateTime TIMESTAMP default now();
alter table location
  add column createdDateTime TIMESTAMP default now();
alter table rating
  add column createdDateTime TIMESTAMP default now();
alter table invite
  add column createdDateTime TIMESTAMP default now();
commit;