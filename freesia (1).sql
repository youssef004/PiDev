-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 19 oct. 2019 à 13:04
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `freesia`
--

-- --------------------------------------------------------

--
-- Structure de la table `accessory`
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
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `CinAdmin` int(11) NOT NULL,
  `FirstNameAdmin` varchar(50) NOT NULL,
  `LastNameAdmin` varchar(50) NOT NULL,
  `EmailAdmin` varchar(100) NOT NULL,
  `PwdAdmin` varchar(50) NOT NULL,
  `IdUser` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  PRIMARY KEY (`CinAdmin`),
  KEY `fk_user` (`IdUser`),
  KEY `fk_company` (`IdCompany`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `IdAnnonce` int(11) NOT NULL,
  `DescriptionAnnonce` varchar(200) NOT NULL,
  `DateAnnonce` date NOT NULL,
  `TitreAnnoce` varchar(50) NOT NULL,
  `DescriptionEvennement` varchar(200) NOT NULL,
  `DateEvennement` date NOT NULL,
  `IdUser` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  PRIMARY KEY (`IdAnnonce`),
  KEY `fk_user_annonce` (`IdUser`),
  KEY `fk_company_annonce` (`IdCompany`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `IdChariot` int(11) NOT NULL,
  `NumberProduit` int(11) NOT NULL,
  `TotalChariot` int(11) NOT NULL,
  `BonusChariot` float NOT NULL,
  `IdUser` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  `IdPlant` int(11) NOT NULL,
  `IdAccessoire` int(11) NOT NULL,
  `IdPromotion` int(11) NOT NULL,
  `IdFacture` int(11) NOT NULL,
  PRIMARY KEY (`IdChariot`),
  KEY `fk_user_cart` (`IdUser`),
  KEY `fk_company_cart` (`IdCompany`),
  KEY `fk_plant_cart` (`IdPlant`),
  KEY `fk_accessory_cart` (`IdAccessoire`),
  KEY `fk_promotion_cart` (`IdPromotion`),
  KEY `fk_facture_cart` (`IdFacture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `IdCompany` int(11) NOT NULL,
  `NameCompany` varchar(50) NOT NULL,
  `EmailCompany` varchar(100) NOT NULL,
  `PasswordCompany` varchar(50) NOT NULL,
  `NumberCompany` int(11) NOT NULL,
  `AddressCompany` varchar(100) NOT NULL,
  `IdPlant` int(11) NOT NULL,
  PRIMARY KEY (`IdCompany`),
  KEY `fk_plant_company` (`IdPlant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
CREATE TABLE IF NOT EXISTS `delivery` (
  `IdDelivery` int(11) NOT NULL,
  `DateDelivery` date NOT NULL,
  `DescriptionDelivery` varchar(200) NOT NULL,
  `StateDelivery` varchar(100) NOT NULL,
  `IdUser` int(11) NOT NULL,
  PRIMARY KEY (`IdDelivery`),
  KEY `fk_user_delivery` (`IdUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `Idfacture` int(11) NOT NULL,
  `DateEmission` date NOT NULL,
  `TotalPrice` double NOT NULL,
  `DatePayment` date NOT NULL,
  `ModePayment` varchar(150) NOT NULL,
  `StateFacture` varchar(50) NOT NULL,
  `IdPlant` int(11) NOT NULL,
  `IdAccessory` int(11) NOT NULL,
  PRIMARY KEY (`Idfacture`),
  KEY `fk_plant_facture` (`IdPlant`),
  KEY `fk_accessory_facture` (`IdAccessory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture_promotion`
--

DROP TABLE IF EXISTS `facture_promotion`;
CREATE TABLE IF NOT EXISTS `facture_promotion` (
  `IdFacture` int(11) NOT NULL,
  `IdPromotion` int(11) NOT NULL,
  `DateFac` date NOT NULL,
  PRIMARY KEY (`IdFacture`,`IdPromotion`),
  KEY `fk_promotion` (`IdPromotion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `plants`
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
-- Structure de la table `promotion`
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
  `IdUser` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  PRIMARY KEY (`IdPromotion`),
  KEY `fk_user_promotion` (`IdUser`),
  KEY `fk_company_promotion` (`IdCompany`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
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
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `IdUser` int(11) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address` varchar(150) NOT NULL,
  `Number` int(11) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `Mdp` varchar(50) NOT NULL,
  `IdPlant1` int(11) NOT NULL,
  `IdAccessory` int(11) NOT NULL,
  `IdReclamation` int(11) NOT NULL,
  `IdFacture` int(11) NOT NULL,
  PRIMARY KEY (`IdUser`),
  KEY `fk_plant` (`IdPlant1`),
  KEY `fk_accessory` (`IdAccessory`),
  KEY `fk_reclamation` (`IdReclamation`),
  KEY `fk_facture_user` (`IdFacture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_company` FOREIGN KEY (`IdCompany`) REFERENCES `company` (`IdCompany`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `fk_company_annonce` FOREIGN KEY (`IdCompany`) REFERENCES `company` (`IdCompany`),
  ADD CONSTRAINT `fk_user_annonce` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_accessory_cart` FOREIGN KEY (`IdAccessoire`) REFERENCES `accessory` (`IdAccessory`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_company_cart` FOREIGN KEY (`IdCompany`) REFERENCES `company` (`IdCompany`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_facture_cart` FOREIGN KEY (`IdFacture`) REFERENCES `facture` (`Idfacture`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_plant_cart` FOREIGN KEY (`IdPlant`) REFERENCES `plants` (`IdPlant`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_promotion_cart` FOREIGN KEY (`IdPromotion`) REFERENCES `promotion` (`IdPromotion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_cart` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `fk_plant_company` FOREIGN KEY (`IdPlant`) REFERENCES `plants` (`IdPlant`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `fk_user_delivery` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `fk_accessory_facture` FOREIGN KEY (`IdAccessory`) REFERENCES `accessory` (`IdAccessory`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_plant_facture` FOREIGN KEY (`IdPlant`) REFERENCES `plants` (`IdPlant`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture_promotion`
--
ALTER TABLE `facture_promotion`
  ADD CONSTRAINT `fk_facture` FOREIGN KEY (`IdFacture`) REFERENCES `facture` (`Idfacture`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_promotion` FOREIGN KEY (`IdPromotion`) REFERENCES `promotion` (`IdPromotion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `fk_company_promotion` FOREIGN KEY (`IdCompany`) REFERENCES `company` (`IdCompany`),
  ADD CONSTRAINT `fk_user_promotion` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_accessory` FOREIGN KEY (`IdAccessory`) REFERENCES `accessory` (`IdAccessory`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_facture_user` FOREIGN KEY (`IdFacture`) REFERENCES `facture` (`Idfacture`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_plant` FOREIGN KEY (`IdPlant1`) REFERENCES `plants` (`IdPlant`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reclamation` FOREIGN KEY (`IdReclamation`) REFERENCES `reclamation` (`IdReclamation`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
