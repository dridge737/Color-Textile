-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2014 at 09:30 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `color_textile`
--

-- --------------------------------------------------------

--
-- Table structure for table `colorway`
--

CREATE TABLE IF NOT EXISTS `colorway` (
  `id_colorway` int(11) NOT NULL AUTO_INCREMENT,
  `colorway_name` varchar(45) DEFAULT NULL,
  `binder` float DEFAULT NULL,
  `design_code` varchar(45) DEFAULT NULL,
  `weight_kg` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_colorway`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `colorway_and_screen`
--

CREATE TABLE IF NOT EXISTS `colorway_and_screen` (
  `id_color_screen` int(11) NOT NULL AUTO_INCREMENT,
  `id_screen` int(11) DEFAULT NULL,
  `id_colorway` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_color_screen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `colorway_screen_connect`
--

CREATE TABLE IF NOT EXISTS `colorway_screen_connect` (
  `id_color_screen` int(11) NOT NULL AUTO_INCREMENT,
  `id_screen` int(11) DEFAULT NULL,
  `id_colorway` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_color_screen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_customer`, `customer_name`) VALUES
(1, 'winston'),
(2, 'Jordan'),
(3, 'JV'),
(4, 'Eldridge');

-- --------------------------------------------------------

--
-- Table structure for table `design`
--

CREATE TABLE IF NOT EXISTS `design` (
  `design_code` varchar(45) NOT NULL,
  `textile_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`design_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `design_colorway_connect`
--

CREATE TABLE IF NOT EXISTS `design_colorway_connect` (
  `id_design_colorway` int(11) NOT NULL AUTO_INCREMENT,
  `design_code` varchar(45) DEFAULT NULL,
  `id_colorway` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_design_colorway`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `job_order`
--

CREATE TABLE IF NOT EXISTS `job_order` (
  `job_order_id` varchar(11) NOT NULL,
  `date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `fabric_style` varchar(45) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `design_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`job_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pigment`
--

CREATE TABLE IF NOT EXISTS `pigment` (
  `pigment_no` int(11) NOT NULL AUTO_INCREMENT,
  `pigment_name` varchar(45) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  `tingi` int(11) DEFAULT NULL,
  PRIMARY KEY (`pigment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `screen_pigment`
--

CREATE TABLE IF NOT EXISTS `screen_pigment` (
  `id_screen` int(11) NOT NULL,
  `pigment_no` int(11) DEFAULT NULL,
  `pigment_percentage` float DEFAULT NULL,
  PRIMARY KEY (`id_screen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `textile`
--

CREATE TABLE IF NOT EXISTS `textile` (
  `textile_code` varchar(45) NOT NULL,
  `textile_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`textile_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
