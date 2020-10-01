-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2020 at 04:45 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `staff_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(4) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `MI` varchar(15) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `Telephone` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `firstName`, `lastName`, `MI`, `Address`, `City`, `State`, `Telephone`) VALUES
(1, 'asdfg', 'dgsgg', 'Q', 'xfggsgg', 'dsdd', 'QLD', 343243),
(2, 'Krish', 'dinesh', 'F', '30,ajbsjbfhfbf,ijbhfswbhwf', 'jdbjdbfjhf', 'NT', 384389834),
(3, 'Alfar', 'Kaleel', 'M', '50,dfbsjfb,ajbasjh', 'jbjsgbvj', 'NSW', 894784784),
(4, 'Krish', 'dinesh', 'F', '30,ajbsjbfhfbf,ijbhfswbhwf', 'jdbjdbfjhf', 'NT', 384389834),
(5, 'Krish', 'dinesh', 'F', '30,ajbsjbfhfbf,ijbhfswbhwf', 'jdbjdbfjhf', 'NT', 384389834),
(6, 'Krish', 'dinesh', 'F', '30,ajbsjbfhfbf,ijbhfswbhwf', 'jdbjdbfjhf', 'NT', 384389834),
(7, 'Krish', 'dinesh', 'F', '30,ajbsjbfhfbf,ijbhfswbhwf', 'jdbjdbfjhf', 'NT', 384389834),
(8, 'dhajh', 'abjf', 'K', 'kenhfje', 'wlker', 'NSW', 8732894),
(9, 'Kthu', 'sdnjb', 'j', 'jdnjnjdsnjgnj', 'jfnjsnj', 'NT', 939343409),
(10, 'Saman', 'kumara', 'f', 'vnxjkvs', 'lnjlb', 'NT', 37320943),
(11, 'asdfg', 'dgsgg', 'Q', 'xfggsgg', 'dsdd', 'QLD', 343243),
(12, 'asdfg', 'dgsgg', 'Q', 'xfggsgg', 'dsdd', 'QLD', 343243),
(13, 'Alfar', 'Mohamed', 'F', 'jbjf', 'kjshjbv', 'NSW', 778347),
(14, 'ggs', 'kjhj', 'lkjhj', 'khj', 'lkjhj', 'QLD', 998796789);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
