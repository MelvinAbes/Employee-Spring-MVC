CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) not null,
  `email` varchar(45) not NULL,
  `dob` Date not NULL,
  `age` int not NULL,
  `salary` int not NULL,
  `status` boolean not NULL,
  PRIMARY KEY (`id`)
) ENGINE=employeeInnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;