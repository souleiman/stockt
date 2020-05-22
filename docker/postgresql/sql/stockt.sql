CREATE TABLE stockt_user
(
    id                  uuid PRIMARY KEY,
    name                varchar(32),
    age                 integer,
    account_create_date date
);

create index stockt_user_index on stockt_user (id);