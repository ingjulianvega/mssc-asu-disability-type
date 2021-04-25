DROP DATABASE IF EXISTS disabilitytypeservice ;
DROP USER IF EXISTS `disability_type_service`@`%`;
CREATE DATABASE IF NOT EXISTS disabilitytypeservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `disability_type_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `disabilitytypeservice`.* TO `disability_type_service`@`%`;
FLUSH PRIVILEGES;