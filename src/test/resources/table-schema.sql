CREATE TABLE IF NOT EXISTS `USERS` (
  `USER_ID` INT(11) NOT NULL,
  `LOGIN_ID` VARCHAR(45) DEFAULT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(255) DEFAULT NULL,
  `PASSWORD` VARCHAR(255) NOT NULL,
  `PHONE_NO` VARCHAR(255) DEFAULT NULL,
  `M_PHONE_NO` VARCHAR(255) DEFAULT NULL,
  `BIRTH` VARCHAR(255) DEFAULT NULL,
  `ZIP_CODE` VARCHAR(255) DEFAULT NULL,
  `ADDRESS` VARCHAR(255) DEFAULT NULL,
  `DETAIL_ADDRESS` VARCHAR(255) DEFAULT NULL,
  `CREATE_TIME` INT(10) DEFAULT NULL,
  `UPDATE_TIME` INT(10) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `ROLES` (
  `ROLE` VARCHAR(45) NOT NULL,
  `DESC` VARCHAR(255) NULL,
  PRIMARY KEY (`ROLE`)
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `USERS_ROLES_REL` (
  `USER_ID` INT NOT NULL,
  `ROLE` VARCHAR(45) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

