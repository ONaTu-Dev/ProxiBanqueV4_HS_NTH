-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Lun 29 Janvier 2018 à 08:02
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `ProxiBanqueV4_Hubert_NTH`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` int(11) NOT NULL,
  `dateCretion` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `agence`
--

INSERT INTO `agence` (`id`, `dateCretion`, `reference`) VALUES
(1, NULL, NULL),
(2, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE `carte` (
  `carte_type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `numeroCarte` varchar(255) DEFAULT NULL,
  `compteCourant_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `carte`
--

INSERT INTO `carte` (`carte_type`, `id`, `numeroCarte`, `compteCourant_id`) VALUES
('ELECTRON', 12, '123890123', NULL),
('ELECTRON', 14, '234566543', NULL),
('ELECTRON', 16, '5858575785', NULL),
('ELECTRON', 18, '757777557', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `codePostal` int(11) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_conseiller` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `adresse`, `codePostal`, `telephone`, `ville`, `email`, `nom`, `prenom`, `id_conseiller`) VALUES
(7, '1 rue Verdun', 75001, '014356782', 'Paris 1', ' abc@gmail.com', 'Spear', 'Brineuy', 5),
(8, '2 rue General', 75012, '016732904', 'Paris 12', ' npre2@gmail.com', 'Porman', 'Nath', 5),
(9, '3 rue Charle de Gaule', 94030, '014526875', 'St Maur', ' hjkpc@gmail.com', 'Kiko', 'Azika', 5),
(10, '4 avenue Elerc', 95040, '0536426875', 'Champigni', ' nbchdqc@gmail.com', 'Thompson', 'Lili', 5);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `compte_type` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `dateOuverture` datetime DEFAULT NULL,
  `numeroCompte` varchar(255) DEFAULT NULL,
  `solde` double NOT NULL,
  `tauxRemuneration` double DEFAULT NULL,
  `autorisationDecouvert` double DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`compte_type`, `id`, `dateOuverture`, `numeroCompte`, `solde`, `tauxRemuneration`, `autorisationDecouvert`, `id_client`) VALUES
('COMPTE_COURANT', 11, '2018-01-29 02:47:21', '1517190441829', 11345.55, NULL, 1000, 7),
('COMPTE_COURANT', 13, '2018-01-29 02:47:21', '1517190441872', 265.55, NULL, 1000, 8),
('COMPTE_COURANT', 15, '2018-01-29 02:47:21', '1517190441906', 65.55, NULL, 1000, 9),
('COMPTE_COURANT', 17, '2018-01-29 02:47:21', '1517190441939', 165.55, NULL, 1000, 10),
('COMPTE_EPARGNE', 19, '2018-01-29 02:47:21', '1517190441971', 15400, 0.03, NULL, 7),
('COMPTE_EPARGNE', 20, '2018-01-29 02:47:21', '1517190442002', 400, 0.03, NULL, 8),
('COMPTE_EPARGNE', 21, '2018-01-29 02:47:21', '1517190442024', 4500, 0.03, NULL, 9),
('COMPTE_EPARGNE', 22, '2018-01-29 02:47:21', '1517190442046', 6700, 0.03, NULL, 10);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `agence_id` int(11) DEFAULT NULL,
  `gerant_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`id`, `login`, `nom`, `prenom`, `pwd`, `agence_id`, `gerant_id`) VALUES
(5, 'cons', 'Hjka', 'Niko', 'cons', 1, 3),
(6, NULL, 'NDH', 'Robert', NULL, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Employe`
--

CREATE TABLE `Employe` (
  `login` varchar(255) NOT NULL,
  `pwd` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

CREATE TABLE `gerant` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `agence_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `gerant`
--

INSERT INTO `gerant` (`id`, `login`, `nom`, `prenom`, `pwd`, `agence_id`) VALUES
(3, NULL, 'Dupont', 'Fred', NULL, 1),
(4, NULL, 'Douglas', 'Mike', NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(29),
(29),
(29),
(29),
(29),
(29),
(29);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequences`
--

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `idcomptecible` int(11) NOT NULL,
  `idcomptedepart` int(11) NOT NULL,
  `montant` double NOT NULL,
  `numcomptecible` varchar(255) DEFAULT NULL,
  `numcomptedepart` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `operation`
--

INSERT INTO `operation` (`id`, `date`, `etat`, `idcomptecible`, `idcomptedepart`, `montant`, `numcomptecible`, `numcomptedepart`, `type`, `id_client`) VALUES
(23, '2017-11-01 02:49:01', 'COMPTA', 11, -1, 2000, '1517190441829', '', 'Versement', 7),
(24, '2017-09-05 02:53:22', 'COMPTA', 11, -1, 10000, '1517190441829', '', 'Versement', 7),
(25, '2017-12-01 02:53:22', 'COMPTA', 19, 11, 5000, '1517190441971', '1517190441829', 'Virement', 7),
(26, '2018-01-03 02:53:22', 'COMPTA', 11, -1, 2000, '1517190441829', '', 'Versement', 7),
(27, '2018-01-29 03:08:31', 'COMPTA', 11, -1, 10000, '1517190441829', '', 'Versement', 7),
(28, '2018-01-29 03:11:01', 'COMPTA', 19, 11, 10000, '1517190441971', '1517190441829', 'Virement', 7);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj23ivc3vm2slqctk3gup35kx7` (`compteCourant_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcu16e576j6rsiofn47y4wx5yu` (`id_conseiller`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfn9jafk7kn8gpmsxv9uhqna92` (`id_client`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6t18x41m1v16wp7wvk7dl9p5j` (`login`),
  ADD KEY `FKkbmcby54s6b7m9d4pcxasp00y` (`agence_id`),
  ADD KEY `FK6mv66nvat4s0vj4x3tmmqih64` (`gerant_id`);

--
-- Index pour la table `Employe`
--
ALTER TABLE `Employe`
  ADD PRIMARY KEY (`login`);

--
-- Index pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_p55ytx84x7kgdkenpqb7a3s3s` (`login`),
  ADD KEY `FKmghgfrjlgv37ah0on1y292gy2` (`agence_id`);

--
-- Index pour la table `hibernate_sequences`
--
ALTER TABLE `hibernate_sequences`
  ADD PRIMARY KEY (`sequence_name`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK28n0hvvmkj94goftny34p412f` (`id_client`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `carte`
--
ALTER TABLE `carte`
  ADD CONSTRAINT `FKj23ivc3vm2slqctk3gup35kx7` FOREIGN KEY (`compteCourant_id`) REFERENCES `compte` (`id`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKcu16e576j6rsiofn47y4wx5yu` FOREIGN KEY (`id_conseiller`) REFERENCES `conseiller` (`id`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FKfn9jafk7kn8gpmsxv9uhqna92` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD CONSTRAINT `FK6mv66nvat4s0vj4x3tmmqih64` FOREIGN KEY (`gerant_id`) REFERENCES `gerant` (`id`),
  ADD CONSTRAINT `FKkbmcby54s6b7m9d4pcxasp00y` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`);

--
-- Contraintes pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD CONSTRAINT `FKmghgfrjlgv37ah0on1y292gy2` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FK28n0hvvmkj94goftny34p412f` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);
