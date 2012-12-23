# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table chat_history (
  id                        bigint auto_increment not null,
  session_id                varchar(255),
  question                  varchar(255),
  answer                    varchar(255),
  date                      datetime,
  constraint pk_chat_history primary key (id))
;

create table user_info (
  id                        bigint auto_increment not null,
  ip                        varchar(255),
  session_id                varchar(255),
  constraint pk_user_info primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table chat_history;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;

