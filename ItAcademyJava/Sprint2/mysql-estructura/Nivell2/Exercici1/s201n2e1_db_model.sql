-- MySQL Script generated by MySQL Workbench
-- Tue Jun 25 13:35:12 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`channel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`channel` (
  `id_channel` INT NOT NULL AUTO_INCREMENT,
  `subscribed_user_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(300) NULL,
  `creation_date` DATE NULL,
  `subscribers_id` INT NULL,
  `publication_id` INT NULL,
  `channelcol` VARCHAR(45) NULL,
  PRIMARY KEY (`id_channel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `birth_date` DATE NOT NULL,
  `gender` SET("male", "female", "non-binary", "other") NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(10) NOT NULL,
  `subscription_id` INT NULL,
  `like_id` INT NULL,
  `dislike_id` INT NULL,
  `playlist_id` INT NULL,
  `channel_id` INT NOT NULL,
  PRIMARY KEY (`id_user`, `channel_id`),
  UNIQUE INDEX `likes_id_UNIQUE` (`like_id` ASC) VISIBLE,
  UNIQUE INDEX `dislikes_id_UNIQUE` (`dislike_id` ASC) VISIBLE,
  INDEX `fk_users_channel1_idx` (`channel_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_channel1`
    FOREIGN KEY (`channel_id`)
    REFERENCES `mydb`.`channel` (`id_channel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`publications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`publications` (
  `id_publication` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `size` DECIMAL(6,2) NOT NULL,
  `file_name` VARCHAR(200) NOT NULL,
  `length` TIME NOT NULL,
  `thumbnail` VARCHAR(200) NOT NULL,
  `views` INT NOT NULL,
  `like_id` INT NOT NULL,
  `dislike_id` INT NOT NULL,
  `tags_id` INT NULL,
  `privacy` SET("public", "private", "hidden") NULL,
  `user_id` INT NOT NULL,
  `publishing_timestamp` TIMESTAMP NOT NULL,
  `likes_id` INT NULL,
  `dislikes_id` INT NULL,
  `channel_id` INT NULL,
  PRIMARY KEY (`id_publication`),
  INDEX `fk_publications_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_publications_channel1_idx` (`channel_id` ASC) VISIBLE,
  CONSTRAINT `fk_publications_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publications_channel1`
    FOREIGN KEY (`channel_id`)
    REFERENCES `mydb`.`channel` (`id_channel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tags` (
  `id_tag` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tag`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`playlists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playlists` (
  `id_playlists` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `creation_date` DATE NULL,
  `privacy` SET("public", "private") NULL,
  `user_id` INT NULL,
  `publication_id` INT NULL,
  PRIMARY KEY (`id_playlists`),
  INDEX `fk_playlists_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_playlists_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comments` (
  `id_comment` INT NOT NULL,
  `user_id` INT NULL,
  `publication_id` INT NULL,
  `text` VARCHAR(500) NULL,
  `timestamp` TIMESTAMP NULL,
  `comment_reaction_id` INT NULL,
  PRIMARY KEY (`id_comment`),
  INDEX `fk_comments_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comments_publications1_idx` (`publication_id` ASC) VISIBLE,
  CONSTRAINT `fk_comments_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_publications1`
    FOREIGN KEY (`publication_id`)
    REFERENCES `mydb`.`publications` (`id_publication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment_reactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comment_reactions` (
  `id_comment_reaction` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `reaction` BINARY(1) NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  `comment_id` INT NULL,
  PRIMARY KEY (`id_comment_reaction`),
  INDEX `fk_comment_reactions_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comment_reactions_comments1_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_reactions_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_reactions_comments1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `mydb`.`comments` (`id_comment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`playlists_has_publications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playlists_has_publications` (
  `playlists_id_playlists` INT NOT NULL,
  `publications_id_publication` INT NOT NULL,
  PRIMARY KEY (`playlists_id_playlists`, `publications_id_publication`),
  INDEX `fk_playlists_has_publications_publications1_idx` (`publications_id_publication` ASC) VISIBLE,
  INDEX `fk_playlists_has_publications_playlists_idx` (`playlists_id_playlists` ASC) VISIBLE,
  CONSTRAINT `fk_playlists_has_publications_playlists`
    FOREIGN KEY (`playlists_id_playlists`)
    REFERENCES `mydb`.`playlists` (`id_playlists`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlists_has_publications_publications1`
    FOREIGN KEY (`publications_id_publication`)
    REFERENCES `mydb`.`publications` (`id_publication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`publications_has_tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`publications_has_tags` (
  `publications_id_publication` INT NOT NULL,
  `tags_id_tag` INT NOT NULL,
  PRIMARY KEY (`publications_id_publication`, `tags_id_tag`),
  INDEX `fk_publications_has_tags_tags1_idx` (`tags_id_tag` ASC) VISIBLE,
  INDEX `fk_publications_has_tags_publications1_idx` (`publications_id_publication` ASC) VISIBLE,
  CONSTRAINT `fk_publications_has_tags_publications1`
    FOREIGN KEY (`publications_id_publication`)
    REFERENCES `mydb`.`publications` (`id_publication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publications_has_tags_tags1`
    FOREIGN KEY (`tags_id_tag`)
    REFERENCES `mydb`.`tags` (`id_tag`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`channel_has_subscribers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`channel_has_subscribers` (
  `channel_id_channel` INT NOT NULL,
  `subscription_id_subscribers` INT NOT NULL,
  PRIMARY KEY (`channel_id_channel`, `subscription_id_subscribers`),
  INDEX `fk_channel_has_users_channel1_idx` (`channel_id_channel` ASC) VISIBLE,
  INDEX `fk_channel_has_users_users1_idx` (`subscription_id_subscribers` ASC) VISIBLE,
  CONSTRAINT `fk_channel_has_users_channel1`
    FOREIGN KEY (`channel_id_channel`)
    REFERENCES `mydb`.`channel` (`id_channel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_channel_has_users_users1`
    FOREIGN KEY (`subscription_id_subscribers`)
    REFERENCES `mydb`.`users` (`subscription_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`likes` (
  `id_like` INT NOT NULL AUTO_INCREMENT,
  `publication_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_like`),
  INDEX `fk_likes_publications1_idx` (`publication_id` ASC) VISIBLE,
  INDEX `fk_likes_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_likes_publications1`
    FOREIGN KEY (`publication_id`)
    REFERENCES `mydb`.`publications` (`id_publication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_likes_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dislikes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`dislikes` (
  `id_dislike` INT NOT NULL AUTO_INCREMENT,
  `publication_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_dislike`),
  INDEX `fk_dislikes_publications1_idx` (`publication_id` ASC) VISIBLE,
  INDEX `fk_dislikes_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_dislikes_publications1`
    FOREIGN KEY (`publication_id`)
    REFERENCES `mydb`.`publications` (`id_publication`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dislikes_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
