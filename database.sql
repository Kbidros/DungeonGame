CREATE DATABASE IF NOT EXISTS `DungeonRun` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `combat_log` (
  `logID` int NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `playerID` int DEFAULT NULL,
  `monsterID` int DEFAULT NULL,
  `ACTION` varchar(200) DEFAULT NULL,
  `damageDone` int DEFAULT NULL,
  PRIMARY KEY (`logID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `monster` (
  `monsterID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) DEFAULT NULL,
  `CurrentHP` int DEFAULT NULL,
  `MaxHP` int DEFAULT NULL,
  `Strength` int DEFAULT NULL,
  `BaseDamage` int DEFAULT NULL,
  PRIMARY KEY (`monsterID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `player` (
  `playerID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) DEFAULT NULL,
  `Lvl` int DEFAULT NULL,
  `CurrentHP` int DEFAULT NULL,
  `MaxHP` int DEFAULT NULL,
  `Strength` int DEFAULT NULL,
  `Intelligence` int DEFAULT NULL,
  `Agility` int DEFAULT NULL,
  `BaseDamage` int DEFAULT NULL,
  PRIMARY KEY (`playerID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;