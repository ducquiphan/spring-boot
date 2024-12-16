USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES 
('duc','{bcrypt}$2a$10$khgyi2oXLxHRruFYEALHb.muvV06wSCa/ZJjA7bkwg3XIF7Y1Vg7K',1),
('bin','{bcrypt}$2a$10$khgyi2oXLxHRruFYEALHb.muvV06wSCa/ZJjA7bkwg3XIF7Y1Vg7K',1),
('thien','{bcrypt}$2a$10$khgyi2oXLxHRruFYEALHb.muvV06wSCa/ZJjA7bkwg3XIF7Y1Vg7K',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('duc','ROLE_EMPLOYEE'),
('bin','ROLE_EMPLOYEE'),
('bin','ROLE_MANAGER'),
('thien','ROLE_EMPLOYEE'),
('thien','ROLE_MANAGER'),
('thien','ROLE_ADMIN');