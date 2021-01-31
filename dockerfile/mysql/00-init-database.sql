CREATE DATABASE IF NOT EXISTS `score_db`;

USE score_db;

DROP TABLE IF EXISTS `scores`;
CREATE TABLE IF NOT EXISTS `scores` (
   `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `player` VARCHAR(250)  NOT NULL DEFAULT '',
   `hash_player` CHAR(32) NOT NULL DEFAULT (md5(`player`)),
   `score` INT NOT NULL DEFAULT 0,
   `time` BIGINT(19) DEFAULT (unix_timestamp()),
    key (hash_player)
) ENGINE = INNODB;

CREATE USER 'java_app'@'%' IDENTIFIED BY 'foobar';
GRANT ALL PRIVILEGES ON score_db.* TO 'java_app'@'%' WITH GRANT OPTION;