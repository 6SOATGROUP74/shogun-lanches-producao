-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_soat_producao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_soat_producao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_soat_producao` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_soat_producao` ;

-- -----------------------------------------------------
-- Table `db_soat_producao`.`tb_producao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_soat_producao`.`tb_producao` (
    `id_producao` BIGINT NOT NULL AUTO_INCREMENT,
    `id_pagamento` BIGINT NOT NULL,
    `numero_pedido` BIGINT NOT NULL,
    `etapa` VARCHAR(255) NULL,
    `data_criacao` DATETIME NULL DEFAULT NULL,
    `data_atualizacao` DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (`id_producao`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 15
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
