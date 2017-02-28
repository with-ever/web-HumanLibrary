CREATE TABLE IF NOT EXISTS `oauth_client_details` (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove tinyint
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `oauth_code` (
  code VARCHAR(255), authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `USERS` (
  `USER_ID` INT(11) NOT NULL AUTO_INCREMENT,
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


-- Add Humanbook Table
CREATE TABLE `HUMANBOOK` (
  `hb_id` int(11) NOT NULL,
  `hb_title` varchar(45) DEFAULT NULL,
  `hb_main_career` varchar(45) DEFAULT NULL,
  `hb_status` varchar(45) DEFAULT NULL,
  `hb_create_time` int(11) DEFAULT NULL,
  `hb_update_time` int(11) DEFAULT NULL,
  `login_id` varchar(45) NOT NULL,
  `service_time` varchar(45) DEFAULT NULL,
  `sub_category` varchar(45) NOT NULL,
  `upper_category` varchar(45) NOT NULL,
  PRIMARY KEY (`hb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

