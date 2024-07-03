-- MySQL Script generated by MySQL Workbench
-- Wed Jun 26 11:35:14 2024
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
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `gender` ENUM("male", "female", "non-binary", "other") NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(10) NOT NULL,
  `is_premium` BINARY NOT NULL DEFAULT 0 COMMENT '0 = free\n1 = premium',
  `is_artist` BINARY NOT NULL DEFAULT 0 COMMENT '0 = regular user\n1 = artist',
  `follow_id` INT NULL,
  `favorite_id` INT NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`subscriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`subscriptions` (
  `id_subscription` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `payment_method` BINARY NOT NULL COMMENT '0 = card\n1 = PayPal',
  `user_id` INT NULL,
  PRIMARY KEY (`id_subscription`),
  INDEX `fk_subscriptions_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_subscriptions_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payments` (
  `id_payment` INT NOT NULL,
  `user_id` INT NOT NULL,
  `order` VARCHAR(15) NOT NULL,
  `price` DECIMAL(4,2) NOT NULL,
  `subscription_id` INT NULL,
  PRIMARY KEY (`id_payment`),
  UNIQUE INDEX `order_UNIQUE` (`order` ASC) VISIBLE,
  INDEX `fk_payments_subscriptions1_idx` (`subscription_id` ASC) VISIBLE,
  CONSTRAINT `fk_payments_subscriptions1`
    FOREIGN KEY (`subscription_id`)
    REFERENCES `mydb`.`subscriptions` (`id_subscription`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cards` (
  `id_card` INT NOT NULL AUTO_INCREMENT,
  `card_num` INT NOT NULL,
  `expiration` DATE NOT NULL,
  `code` INT NOT NULL,
  `user_id` INT NOT NULL,
  `payment_id` INT NULL,
  PRIMARY KEY (`id_card`),
  INDEX `fk_cards_payments1_idx` (`payment_id` ASC) VISIBLE,
  CONSTRAINT `fk_cards_payments1`
    FOREIGN KEY (`payment_id`)
    REFERENCES `mydb`.`payments` (`id_payment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`paypals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`paypals` (
  `id_paypal` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `paypal_username` VARCHAR(45) NOT NULL,
  `payment_id` INT NULL,
  PRIMARY KEY (`id_paypal`),
  INDEX `fk_paypals_payments1_idx` (`payment_id` ASC) VISIBLE,
  CONSTRAINT `fk_paypals_payments1`
    FOREIGN KEY (`payment_id`)
    REFERENCES `mydb`.`payments` (`id_payment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`playlists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playlists` (
  `id_playlist` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `size` INT NOT NULL,
  `creation_date` DATE NOT NULL,
  `status` BINARY NOT NULL DEFAULT 0 COMMENT 'active = 0\ndeleted = 1',
  `sharing` BINARY NULL DEFAULT 0 COMMENT '0 = not shared\n1 = share playlist',
  `additional_users_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id_playlist`),
  INDEX `fk_playlists_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_playlists_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`shared_playlist_songs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shared_playlist_songs` (
  `id_shared_playlist_song` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `song` VARCHAR(45) NOT NULL,
  `addition_date` DATE NOT NULL,
  `playlist_id` INT NULL,
  PRIMARY KEY (`id_shared_playlist_song`),
  INDEX `fk_externally_added_songs_playlists1_idx` (`playlist_id` ASC) VISIBLE,
  INDEX `fk_externally_added_songs_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_externally_added_songs_playlists1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `mydb`.`playlists` (`id_playlist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_externally_added_songs_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`artists` (
  `id_artist` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `image` VARCHAR(200) NULL,
  `related_artist_id` INT NULL,
  PRIMARY KEY (`id_artist`),
  INDEX `fk_artists_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_artists_artists1_idx` (`related_artist_id` ASC) VISIBLE,
  CONSTRAINT `fk_artists_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artists_artists1`
    FOREIGN KEY (`related_artist_id`)
    REFERENCES `mydb`.`artists` (`id_artist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`favorites` (
  `id_favorite` INT NOT NULL,
  `user_id` INT NULL,
  `artist_song_id` INT NULL,
  `album_id` INT NULL,
  PRIMARY KEY (`id_favorite`),
  INDEX `fk_favorites_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_favorites_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`albums`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`albums` (
  `id_album` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `publication` DATE NOT NULL,
  `image` VARCHAR(200) NULL,
  `albums_id_album` INT NOT NULL,
  `favorite_id` INT NULL,
  PRIMARY KEY (`id_album`),
  INDEX `fk_albums_artists1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_albums_albums1_idx` (`albums_id_album` ASC) VISIBLE,
  INDEX `fk_albums_favorites1_idx` (`favorite_id` ASC) VISIBLE,
  CONSTRAINT `fk_albums_artists1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`artists` (`id_artist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_albums_albums1`
    FOREIGN KEY (`albums_id_album`)
    REFERENCES `mydb`.`albums` (`id_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_albums_favorites1`
    FOREIGN KEY (`favorite_id`)
    REFERENCES `mydb`.`favorites` (`id_favorite`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`artist_songs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`artist_songs` (
  `id_artist_song` INT NOT NULL AUTO_INCREMENT,
  `album_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `length` TIME NOT NULL,
  `reproductions` INT NOT NULL DEFAULT 0,
  `favorite_id` INT NULL,
  PRIMARY KEY (`id_artist_song`),
  INDEX `fk_artist_songs_artists1_idx` (`artist_id` ASC) VISIBLE,
  INDEX `fk_artist_songs_albums1_idx` (`album_id` ASC) VISIBLE,
  INDEX `fk_artist_songs_favorites1_idx` (`favorite_id` ASC) VISIBLE,
  CONSTRAINT `fk_artist_songs_artists1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `mydb`.`artists` (`id_artist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artist_songs_albums1`
    FOREIGN KEY (`album_id`)
    REFERENCES `mydb`.`albums` (`id_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artist_songs_favorites1`
    FOREIGN KEY (`favorite_id`)
    REFERENCES `mydb`.`favorites` (`id_favorite`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users_follow_artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users_follow_artists` (
  `users_id_user` INT NOT NULL,
  `artists_id_artist` INT NOT NULL,
  PRIMARY KEY (`users_id_user`, `artists_id_artist`),
  INDEX `fk_users_has_artists_artists1_idx` (`artists_id_artist` ASC) VISIBLE,
  INDEX `fk_users_has_artists_users1_idx` (`users_id_user` ASC) VISIBLE,
  CONSTRAINT `fk_users_has_artists_users1`
    FOREIGN KEY (`users_id_user`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_artists_artists1`
    FOREIGN KEY (`artists_id_artist`)
    REFERENCES `mydb`.`artists` (`id_artist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`artists_relate_artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`artists_relate_artists` (
  `artists_id_artist` INT NOT NULL,
  `artists_id_artist1` INT NOT NULL,
  PRIMARY KEY (`artists_id_artist`, `artists_id_artist1`),
  INDEX `fk_artists_has_artists_artists2_idx` (`artists_id_artist1` ASC) VISIBLE,
  INDEX `fk_artists_has_artists_artists1_idx` (`artists_id_artist` ASC) VISIBLE,
  CONSTRAINT `fk_artists_has_artists_artists1`
    FOREIGN KEY (`artists_id_artist`)
    REFERENCES `mydb`.`artists` (`id_artist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_artists_has_artists_artists2`
    FOREIGN KEY (`artists_id_artist1`)
    REFERENCES `mydb`.`artists` (`id_artist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;