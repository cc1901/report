# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table userInfo (
  id                        bigint auto_increment not null,
  ip                        varchar(255),
  session_id                varchar(255),
  constraint pk_userInfo primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table userInfo;

SET FOREIGN_KEY_CHECKS=1;

