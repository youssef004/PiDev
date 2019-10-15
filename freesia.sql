-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 15, 2019 at 08:56 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `freesia`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessory`
--

DROP TABLE IF EXISTS `accessory`;
CREATE TABLE IF NOT EXISTS `accessory` (
  `IdAccessory` int(11) NOT NULL,
  `NameAccessory` varchar(50) NOT NULL,
  `PrixAccessory` int(11) NOT NULL,
  `QuantityAccessory` int(11) NOT NULL,
  `DescriptionAccessory` varchar(200) NOT NULL,
  PRIMARY KEY (`IdAccessory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `CinAdmin` int(11) NOT NULL,
  `FirstNameAdmin` varchar(50) NOT NULL,
  `LastNameAdmin` varchar(50) NOT NULL,
  `EmailAdmin` varchar(100) NOT NULL,
  `PwdAdmin` varchar(50) NOT NULL,
  PRIMARY KEY (`CinAdmin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `IdAnnonce` int(11) NOT NULL,
  `DescriptionAnnonce` varchar(200) NOT NULL,
  `DateAnnonce` date NOT NULL,
  `TitreAnnoce` varchar(50) NOT NULL,
  `DescriptionEvennement` varchar(200) NOT NULL,
  `DateEvennement` date NOT NULL,
  PRIMARY KEY (`IdAnnonce`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `IdChariot` int(11) NOT NULL,
  `NumberProduit` int(11) NOT NULL,
  `TotalChariot` int(11) NOT NULL,
  `BonnusChariot` float NOT NULL,
  PRIMARY KEY (`IdChariot`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `IdCompany` int(11) NOT NULL,
  `NameCompany` varchar(50) NOT NULL,
  `EmailCompany` varchar(100) NOT NULL,
  `PasswordCompany` varchar(50) NOT NULL,
  `NumberCompany` int(11) NOT NULL,
  `AddressCompany` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
CREATE TABLE IF NOT EXISTS `delivery` (
  `IdDelivery` int(11) NOT NULL,
  `DateDelivery` date NOT NULL,
  `DescriptionDelivery` varchar(200) NOT NULL,
  `StateDelivery` varchar(100) NOT NULL,
  PRIMARY KEY (`IdDelivery`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `Idfacture` int(11) NOT NULL,
  `DateEmission` date NOT NULL,
  `TotalPrice` double NOT NULL,
  `DatePayment` date NOT NULL,
  `ModePayment` varchar(150) NOT NULL,
  `StateFacture` varchar(50) NOT NULL,
  PRIMARY KEY (`Idfacture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `plants`
--

DROP TABLE IF EXISTS `plants`;
CREATE TABLE IF NOT EXISTS `plants` (
  `IdPlant` int(11) NOT NULL,
  `NamePlant` varchar(50) NOT NULL,
  `TypePlant` varchar(50) NOT NULL,
  `QantityPlant` int(11) NOT NULL,
  `CategoryPlant` varchar(50) NOT NULL,
  `PricePlant` double NOT NULL,
  `DescriptionPlant` varchar(500) NOT NULL,
  PRIMARY KEY (`IdPlant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `IdPromotion` int(11) NOT NULL,
  `DescriptionPromotion` varchar(200) NOT NULL,
  `PercentagePromotion` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `StatePromotion` varchar(20) NOT NULL,
  `Period` varchar(50) NOT NULL,
  PRIMARY KEY (`IdPromotion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `IdReclamation` int(11) NOT NULL,
  `SubjectReclamation` varchar(150) NOT NULL,
  `DescriptionReclamation` varchar(150) NOT NULL,
  `DateReclamation` date NOT NULL,
  `StateReclamation` varchar(50) NOT NULL,
  PRIMARY KEY (`IdReclamation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `Cin` int(11) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address` varchar(150) NOT NULL,
  `Number` int(11) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `Mdp` varchar(50) NOT NULL,
  `IdPlant` int(11) NOT NULL,
  PRIMARY KEY (`Cin`),
  KEY `IdPlant1` (`IdPlant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `IdPlant1` FOREIGN KEY (`IdPlant`) REFERENCES `plants` (`IdPlant`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
