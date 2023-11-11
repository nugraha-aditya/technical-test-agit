-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.38-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for technical_test
CREATE DATABASE IF NOT EXISTS `technical_test` /*!40100 DEFAULT CHARACTER SET ascii COLLATE ascii_bin */;
USE `technical_test`;

-- Dumping structure for table technical_test.customer_account
CREATE TABLE IF NOT EXISTS `customer_account` (
  `customer_name` varchar(255) COLLATE ascii_bin NOT NULL,
  `account_number` varchar(50) COLLATE ascii_bin NOT NULL,
  `balance` decimal(38,0) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_number`),
  UNIQUE KEY `account_number` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Dumping data for table technical_test.customer_account: ~2 rows (approximately)
/*!40000 ALTER TABLE `customer_account` DISABLE KEYS */;
INSERT INTO `customer_account` (`customer_name`, `account_number`, `balance`) VALUES
	('aditya', '55100', 975500),
	('joni', '55101', 524500);
/*!40000 ALTER TABLE `customer_account` ENABLE KEYS */;

-- Dumping structure for table technical_test.customer_transactions
CREATE TABLE IF NOT EXISTS `customer_transactions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_account` varchar(50) COLLATE ascii_bin NOT NULL,
  `amount` decimal(38,0) NOT NULL DEFAULT '0',
  `dest_account` varchar(50) COLLATE ascii_bin NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Dumping data for table technical_test.customer_transactions: ~5 rows (approximately)
/*!40000 ALTER TABLE `customer_transactions` DISABLE KEYS */;
INSERT INTO `customer_transactions` (`id`, `source_account`, `amount`, `dest_account`, `created_date`) VALUES
	(1, '55100', 1000, '55101', '2023-11-11 21:34:23');
/*!40000 ALTER TABLE `customer_transactions` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
