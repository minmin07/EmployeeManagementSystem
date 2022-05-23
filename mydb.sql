-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2022 at 11:25 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `employeedb`
--

CREATE TABLE `employeedb` (
  `employeeID` int(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `contactNumber` int(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `remarks` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employeedb`
--

INSERT INTO `employeedb` (`employeeID`, `firstName`, `lastName`, `email`, `contactNumber`, `address`, `remarks`) VALUES(1001, 'Dorji', 'Choden', 'dorji.c@gmail.com', 17722346, 'Thimphu', 'active');
INSERT INTO `employeedb` (`employeeID`, `firstName`, `lastName`, `email`, `contactNumber`, `address`, `remarks`) VALUES(1002, 'Tshering', 'Tobgay', 'ttobgay@gmail.com', 17879653, 'Thimphu', 'on leave');
INSERT INTO `employeedb` (`employeeID`, `firstName`, `lastName`, `email`, `contactNumber`, `address`, `remarks`) VALUES(1003, 'Jigme', 'Yozer', 'jigmeyzee@gmail.com', 77234673, 'Thimphu', 'on leave');
INSERT INTO `employeedb` (`employeeID`, `firstName`, `lastName`, `email`, `contactNumber`, `address`, `remarks`) VALUES(1004, 'Sonam', 'Kinga', 'skinga@gmail.com', 17879546, 'Thimphu', 'active');
INSERT INTO `employeedb` (`employeeID`, `firstName`, `lastName`, `email`, `contactNumber`, `address`, `remarks`) VALUES(1005, 'Karma', 'Choden', 'wangchuk.009@gmail', 14556, 'Thimphu', 'on leave');
INSERT INTO `employeedb` (`employeeID`, `firstName`, `lastName`, `email`, `contactNumber`, `address`, `remarks`) VALUES(1006, 'Ugyen', 'Samdrup', 'sam@gmail.com', 17000000, 'Thimphu', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES('123', 'abc');
INSERT INTO `login` (`username`, `password`) VALUES('admin', 'root');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
