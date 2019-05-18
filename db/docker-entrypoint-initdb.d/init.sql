CREATE DATABASE plug;
USE plug;
CREATE TABLE `reading` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `voltage_mv` int(10) NOT NULL,
  `current_ma` int(10) NOT NULL,
  `power_mw` int(10) NOT NULL,
  `total_wh` int(10) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
