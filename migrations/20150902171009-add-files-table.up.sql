CREATE TABLE files (
       id           bigint null null,
       name         varchar(255),
       enabled      boolean default FALSE,
       created_at   timestamp not null,
       updated_at   timestamp not null,
       primary key(id)
);
