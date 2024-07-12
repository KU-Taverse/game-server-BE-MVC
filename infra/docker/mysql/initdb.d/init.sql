
CREATE USER 'simple'@'localhost' IDENTIFIED BY 'simple';
CREATE USER 'simple'@'%' IDENTIFIED BY 'simple';

GRANT ALL PRIVILEGES ON *.* TO 'simple'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'simple'@'%';

CREATE DATABASE simple DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- DROP DATABASE IF EXISTS mvc;
-- CREATE DATABASE mvc;
-- USE mvc;
-- CREATE TABLE map_user (
--                           user_id VARCHAR(255) NOT NULL PRIMARY KEY,
--                           position_x DOUBLE NOT NULL,
--                           position_y DOUBLE NOT NULL,
--                           position_z DOUBLE NOT NULL,
--                           rotation_pitch DOUBLE NOT NULL,
--                           rotation_yaw DOUBLE NOT NULL,
--                           rotation_roll DOUBLE NOT NULL,
--                           status VARCHAR(50) NOT NULL,
--                           velocity_x DOUBLE NOT NULL,
--                           velocity_y DOUBLE NOT NULL,
--                           velocity_z DOUBLE NOT NULL,
--                           local_date_time DATETIME
-- );