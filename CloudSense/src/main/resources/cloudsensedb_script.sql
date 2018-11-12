
CREATE DATABASE IF NOT EXISTS cloudsensedb; 


CREATE TABLE `cloudsensedb`.`cluster_node` (
  `cluster_id` VARCHAR(10) NOT NULL,
  `cluster_name` VARCHAR(45) NULL,
  `cluster_desc` VARCHAR(255) NULL,
  `cluster_latitude` VARCHAR(45) NULL,
  `cluster_longitude` VARCHAR(45) NULL,
  `cluster_address` VARCHAR(255) NULL,
  `cluster_city` VARCHAR(45) NULL,
  `cluster_state` VARCHAR(45) NULL,
  `cluster_country` VARCHAR(45) NULL,
  `cluster_zip` VARCHAR(45) NULL,
  `installed_by` VARCHAR(10) NULL,
  `installation_date` DATETIME NULL,
  `last_maintained_by` VARCHAR(10) NULL,
  `last_maintained_date` DATETIME NULL,
  `cluster_status` INT NULL,
  PRIMARY KEY (`cluster_id`));


CREATE TABLE `cloudsensedb`.`smart_node` (
  `node_id` VARCHAR(10) NOT NULL,
  `node_name` VARCHAR(45) NULL,
  `node_desc` VARCHAR(255) NULL,
  `node_latitude` VARCHAR(45) NULL,
  `node_longitude` VARCHAR(45) NULL,
  `node_address` VARCHAR(255) NULL,
  `node_city` VARCHAR(45) NULL,
  `node_state` VARCHAR(45) NULL,
  `node_country` VARCHAR(45) NULL,
  `node_zip` VARCHAR(45) NULL,
  `installed_by` VARCHAR(10) NULL,
  `installation_date` DATETIME NULL,
  `last_maintained_by` VARCHAR(10) NULL,
  `last_maintained_date` DATETIME NULL,
  `node_status` INT NULL,
  PRIMARY KEY (`node_id`));


CREATE TABLE `cloudsensedb`.`sensor` (
  `sensor_id` VARCHAR(10) NOT NULL,
  `device_id` VARCHAR(10) NOT NULL,
  `sensor_name` VARCHAR(45) NULL,
  `sensor_desc` VARCHAR(255) NULL,
  `sensor_status` INT NULL,
  `sensor_type` VARCHAR(45) NULL,
  `sensor_frequency` VARCHAR(45) NULL,
  `sensor_provider_name` VARCHAR(45) NULL,
  `sensor_start_time` DATETIME NULL,
  `sensor_end_time` DATETIME NULL,
  `sensor_data_queue_name` VARCHAR(45) NULL,
  `sensor_data_format` VARCHAR(45) NULL,
  `sensor_latitude` VARCHAR(45) NULL,
  `sensor_longitude` VARCHAR(45) NULL,
  `sensor_address` VARCHAR(255) NULL,
  `sensor_city` VARCHAR(45) NULL,
  `sensor_state` VARCHAR(45) NULL,
  `sensor_country` VARCHAR(45) NULL,
  `sensor_zip` VARCHAR(45) NULL,
  `installed_by` VARCHAR(10) NULL,
  `installation_date` DATETIME NULL,
  `last_maintained_by` VARCHAR(10) NULL,
  `last_maintained_date` DATETIME NULL,
  PRIMARY KEY (`sensor_id`));

  CREATE TABLE `cloudsensedb`.`permission` (
  `permission_id` VARCHAR(10) NOT NULL,
  `permission_name` VARCHAR(45) NULL,
  `created_by` VARCHAR(10) NULL,
  `created_date` DATETIME NULL,
  `last_modified_by` VARCHAR(10) NULL,
  `last_modified_date` DATETIME NULL,
  PRIMARY KEY (`permission_id`));

  CREATE TABLE `cloudsensedb`.`role` (
  `role_id` VARCHAR(10) NOT NULL,
  `role_name` VARCHAR(45) NULL,
  `created_by` VARCHAR(10) NULL,
  `created_date` DATETIME NULL,
  `last_modified_by` VARCHAR(10) NULL,
  `last_modified_date` DATETIME NULL,
  PRIMARY KEY (`role_id`));

 
  CREATE TABLE `cloudsensedb`.`user` (
  `user_id` VARCHAR(10) NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `user_pwd` VARCHAR(45)  NULL,
  `user_email` VARCHAR(255)  NULL,
  `user_phone` VARCHAR(10)  NULL,
  `user_address` VARCHAR(255)  NULL,
  `user_city` VARCHAR(45) NULL,
  `user_state` VARCHAR(45) NULL,
  `user_country` VARCHAR(45) NULL,
  `user_zip` VARCHAR(45) NULL,
  `user_role_id` VARCHAR(10) NULL,
  `created_by` VARCHAR(10) NULL,
  `created_date` DATETIME NULL,
  `last_modified_by` VARCHAR(10) NULL,
  `last_modified_date` DATETIME NULL,
  PRIMARY KEY (`user_id`));

  CREATE TABLE `cloudsensedb`.`role_permission_mapping` (
  `role_permission_id` VARCHAR(10) NOT NULL,
  `permission_id` VARCHAR(10) NOT NULL,
  `role_id` VARCHAR(10) NOT NULL,
  `created_by` VARCHAR(10) NULL,
  `created_date` DATETIME NULL,
   PRIMARY KEY (`role_permission_id`));

  CREATE TABLE `cloudsensedb`.`cluster_node_mapping` (
  `cluster_node_id` VARCHAR(10) NOT NULL,
  `cluster_id` VARCHAR(10) NOT NULL,
  `node_id` VARCHAR(10) NOT NULL,
  `created_by` VARCHAR(10) NULL,
  `created_date` DATETIME NULL,
   PRIMARY KEY (`cluster_node_id`));

  CREATE TABLE `cloudsensedb`.`node_sensor_mapping` (
  `node_sensor_id` VARCHAR(10) NOT NULL,
  `node_id` VARCHAR(10) NOT NULL,
  `sensor_id` VARCHAR(10) NOT NULL,
  `created_by` VARCHAR(10) NULL,
  `created_date` DATETIME NULL,
   PRIMARY KEY (`node_sensor_id`));


