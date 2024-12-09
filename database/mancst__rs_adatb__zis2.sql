-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Gép: localhost:3306
-- Létrehozás ideje: 2024. Dec 09. 10:11
-- Kiszolgáló verziója: 5.7.24
-- PHP verzió: 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `mancstárs_adatbázis`
--

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewCat` (IN `NameIn` VARCHAR(100), IN `BreedIn` VARCHAR(100), IN `AgeIn` DATE, IN `GendeIn` VARCHAR(100), IN `Kids_friendlyIn` INT(8), IN `Apartmnet_friendlyIn` INT(8), IN `Tedency_to_gain_weightIn` INT(8), IN `HealthIn` INT(8), IN `IntelligenceIn` INT(8), IN `Tedency_toescapeIn` INT(8), IN `PlayfulnessIn` INT(8), IN `Dog_friendlyIn` INT(8), IN `Rate_of_hair_lossIn` INT(8), IN `Energy_levelIn` INT(8), IN `Cat_imgIn` TEXT)   INSERT INTO `cat` VALUES (Null, NameIn, BreedIn, AgeIn, GendeIn, Kids_friendlyIn, Apartmnet_friendlyIn,Tedency_to_gain_weightIn,  HealthIn, IntelligenceIn, Tedency_toescapeIn, PlayfulnessIn, Dog_friendlyIn, Rate_of_hair_lossIn, Energy_levelIn, Cat_imgIn)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewDog` (IN `NameIn` VARCHAR(100), IN `BreedIN` VARCHAR(100), IN `AgeIn` DATE, IN `GendeIn` VARCHAR(100), IN `Kids_friendlyIn` INT(8), IN `Apartmnet_friendlyIn` INT(8), IN `Tedency_to_gain_weightIn` INT(8), IN `HealthIn` INT(8), IN `IntelligenceIn` INT(8), IN `Tedency_toescapeIn` INT(8), IN `PlayfulnessIn` INT(8), IN `Cat_friendlyIn` INT(8), IN `Energy_levelIn` INT(8), IN `Dog_imgIn` TEXT)   INSERT INTO `dog` VALUES ( Null, NameIn, BreedIN, AgeIn, GendeIn, Kids_friendlyIn, Apartmnet_friendlyIn,Tedency_to_gain_weightIn, HealthIn,  IntelligenceIn, Tedency_toescapeIn, PlayfulnessIn, Cat_friendlyIn, Energy_levelIn, Dog_imgIn)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCat` ()   SELECT * FROM `cat`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllDog` ()   SELECT * FROM `dog`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllShelter` ()   SELECT * FROM `shelter`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUsers` ()   SELECT * FROM `User`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `emailIN` VARCHAR(100), IN `passwordIN` VARCHAR(255))   SELECT * FROM `user`WHERE `user`.`email` = emailIN AND `user`.`password` = SHA1 (passwordIN)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `cat`
--

CREATE TABLE `cat` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `breed` varchar(100) NOT NULL,
  `age` date DEFAULT NULL,
  `gender` varchar(100) NOT NULL,
  `kids_friendly` int(8) NOT NULL,
  `apartment_friendly` int(8) NOT NULL,
  `tendency_to_gain_weight` int(8) NOT NULL,
  `health` int(8) NOT NULL,
  `intelligence` int(8) NOT NULL,
  `tendency_to_Escape` int(8) NOT NULL,
  `playfulness` int(8) NOT NULL,
  `dog_friendly` int(8) NOT NULL,
  `rate_of_hair_loss` int(8) NOT NULL,
  `energy_level` int(8) NOT NULL,
  `cat_img` text NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shelter_id` int(11) DEFAULT NULL,
  `dog_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `cat`
--

INSERT INTO `cat` (`id`, `name`, `breed`, `age`, `gender`, `kids_friendly`, `apartment_friendly`, `tendency_to_gain_weight`, `health`, `intelligence`, `tendency_to_Escape`, `playfulness`, `dog_friendly`, `rate_of_hair_loss`, `energy_level`, `cat_img`, `user_id`, `shelter_id`, `dog_id`) VALUES
(1, 'Szofi', 'Szfinx', '2021-01-05', 'Girl', 5, 4, 5, 5, 4, 3, 4, 2, 2, 3, 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Sphinx2_July_2006.jpg/1200px-Sphinx2_July_2006.jpg', NULL, NULL, NULL),
(2, 'Ördög', 'Bombay', '2019-03-15', 'Boy', 4, 3, 5, 2, 3, 2, 3, 5, 3, 1, 'https://hobbiallat.hu/wp-content/uploads/2018/10/bombaymacska-1.jpg', NULL, NULL, NULL),
(3, 'Mancs ', 'Maine Coon', '2020-07-23', 'Boy', 4, 5, 3, 4, 5, 5, 5, 3, 0, 4, 'https://www.zooplus.hu/magazin/wp-content/uploads/2018/10/Maine-Coon-768x658.jpg', NULL, NULL, NULL),
(4, 'Cirmos', 'Perzsa', '2018-12-10', 'Girl', 5, 4, 4, 4, 4, 4, 4, 5, 4, 3, 'https://www.pet4you.hu/img/big/Perzsa_1200x1200px.jpg', NULL, NULL, NULL),
(5, 'Foltos', 'Sziámi', '2022-02-28', 'Boy', 3, 5, 5, 3, 3, 5, 2, 4, 4, 3, 'https://upload.wikimedia.org/wikipedia/commons/6/60/Neighbours_Siamese.jpg', NULL, NULL, NULL),
(6, 'Bogi', 'Bengáli', '2020-06-18', 'Girl', 5, 4, 3, 5, 4, 5, 3, 4, 3, 5, 'https://upload.wikimedia.org/wikipedia/commons/9/97/Female_bengal_cat_outdoor.jpg', NULL, NULL, NULL),
(7, 'Mázli ', 'Brit rövidszőrű', '2019-10-09', 'Boy', 5, 5, 5, 3, 3, 2, 3, 3, 2, 2, 'https://www.zooplus.hu/magazin/wp-content/uploads/2017/03/britisch-kurzhaar-gelb-augen.jpg', NULL, NULL, NULL),
(8, 'Zsömle', 'Ragdoll', '2021-04-30', 'Girl', 5, 5, 3, 4, 4, 2, 4, 3, 3, 3, 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Flame_point_Ragdoll.jpg/800px-Flame_point_Ragdoll.jpg', NULL, NULL, NULL),
(9, 'Bendegúz', 'Scottish Fold', '2022-05-17', 'Boy', 4, 5, 4, 1, 4, 1, 2, 3, 3, 2, 'https://www.purina.co.uk/sites/default/files/2021-02/CAT%20HERO_0021_Scottish_fold.jpg', NULL, NULL, NULL),
(10, 'Mancs ', 'Szingapúri macska', '2020-08-12', 'Boy', 4, 5, 3, 4, 5, 5, 5, 3, 3, 4, 'https://www.zooplus.hu/magazin/wp-content/uploads/2024/02/singapura-kitten-1024x682-1.jpg', NULL, NULL, NULL),
(11, '', 'Abesszin', '2018-11-04', 'Boy', 3, 1, 1, 2, 5, 3, 2, 4, 3, 5, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.zooplus.hu%2Fmagazin%2Fmacska-magazin%2Fmacskafajtak%2Fabesszin-macska&psig=AOvVaw0irsifnfyAg4nuVaXUWsPY&ust=1731928715071000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCNi6nLCf44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(12, ' Lili', 'Szibériai', '2019-09-22', 'Girl', 5, 2, 3, 4, 4, 3, 4, 4, 3, 4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fhu.wikipedia.org%2Fwiki%2FSzib%25C3%25A9riai_macska&psig=AOvVaw16-vIZwEkI4TeKqX_LNtVS&ust=1731929664458000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCODZhfWi44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(13, 'Sámson', 'Himalája', '2021-10-15', 'Boy', 2, 5, 4, 2, 4, 2, 2, 2, 4, 3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.zooplus.hu%2Fmagazin%2Fmacska-magazin%2Fmacskafajtak%2Fhimalaja-macska&psig=AOvVaw0W3FWK-QB1isW-zU5h_tEY&ust=1731929747068000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMjfpbCj44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(14, 'Selyem', 'Devon Rex', '2020-12-05', 'Girl', 5, 5, 2, 3, 5, 2, 5, 5, 2, 5, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FDevon_Rex&psig=AOvVaw2RsnsKxGdvq-NgFmbr6x8q&ust=1731929971167000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCLCErIyk44kDFQAAAAAdAAAAABAJ', NULL, NULL, NULL),
(15, 'Pamacs', 'Burma', '2018-04-06', 'Boy', 5, 4, 3, 2, 4, 3, 5, 3, 2, 4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fcatcorner.hu%2Fburma-macska%2F&psig=AOvVaw3BYf0_pNgswSB-KjI9gwPI&ust=1731930125260000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCPDdgOuk44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(16, 'Füles', 'Manx', '2022-03-09', 'Girl', 5, 3, 4, 5, 2, 4, 4, 3, 4, 3, 'https://www.google.com/imgres?q=Manx&imgurl=https%3A%2F%2Fwww.thesprucepets.com%2Fthmb%2F73iUUgYAVYQgBDcLoL1yvmVRypc%3D%2F2910x0%2Ffilters%3Ano_upscale()%3Astrip_icc()%2FGettyImages-87584783-438490f69bac4ac7b90a75a70e76eef6.jpg&imgrefurl=https%3A%2F%2Fwww.thesprucepets.com%2Fmanx-cat-4584387&docid=KTQ6rEnbpcP-gM&tbnid=liMFu2lV4lkZlM&vet=12ahUKEwjmwf6apeOJAxVHm_0HHVKiCTMQM3oECBYQAA..i&w=2910&h=1940&hcb=2&ved=2ahUKEwjmwf6apeOJAxVHm_0HHVKiCTMQM3oECBYQAA', NULL, NULL, NULL),
(17, 'Tappancs', 'Burmai szent templommacska ', '2021-08-14', 'Boy', 5, 4, 3, 3, 4, 3, 4, 3, 3, 3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.purina.hu%2Fleendo-gazdi%2Fmacskafajtak%2Fbirman&psig=AOvVaw2N5EyrSXtj2PTA9EwDPOUX&ust=1731930347965000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMi-stOl44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(18, 'Pihe', 'Török Van', '2020-05-21', 'Girl', 5, 4, 3, 5, 3, 2, 4, 3, 5, 2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.azenmacskam.hu%2Ffajtaleiras%2Ftorok-van-macska-fajtaleiras%2F&psig=AOvVaw0m-C20bfGn160k3qQ6HV8f&ust=1731930617643000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCID4ubym44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(19, 'Marci', 'Török Angóra', '2019-06-11', 'Boy', 3, 2, 4, 5, 3, 2, 5, 3, 4, 3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fhu.wikipedia.org%2Fwiki%2FT%25C3%25B6r%25C3%25B6k_ang%25C3%25B3ramacska&psig=AOvVaw1xiPhwzxXcET_jsj2Ng6pc&ust=1731930730701000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCPiD8vem44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(20, 'Bella', 'Orosz kék', '2022-10-29', 'Girl', 4, 4, 2, 4, 5, 2, 2, 3, 2, 2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.zooplus.hu%2Fmagazin%2Fmacska-magazin%2Fmacskafajtak%2Forosz-kek-macska&psig=AOvVaw2UkCwNI8NnOgMXPiEWuxW5&ust=1731930799175000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMCgpKen44kDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(21, 'Zénó', 'Cornish Rex', '2021-11-25', 'Boy', 5, 5, 3, 3, 4, 2, 4, 3, 2, 4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.zooplus.co.uk%2Fmagazine%2Fcat%2Fcat-breeds%2Fcornish-rex&psig=AOvVaw1gF-dqEC3kIAOUIrDOKkwr&ust=1732005399602000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCJjzzIi95YkDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(22, 'Mici', 'Ocicat', '2020-01-03', 'Girl', 5, 3, 2, 3, 4, 2, 5, 5, 2, 5, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.azenmacskam.hu%2Ffajtaleiras%2Focicat-fajtaleiras%2F&psig=AOvVaw3BOIszabvaGKetGiQHNzqc&ust=1732005963083000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCNjB65K_5YkDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(23, 'Ábel', 'Japán csonkafarkú', '2018-06-17', 'Boy', 4, 3, 2, 5, 5, 5, 4, 1, 5, 3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fhu.wikipedia.org%2Fwiki%2FJap%25C3%25A1n_csonkafark%25C3%25BA_macska&psig=AOvVaw3TYpy8qqzecIRauLOJS181&ust=1732006083315000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCIDMy82_5YkDFQAAAAAdAAAAABAE', NULL, NULL, NULL),
(24, 'Csilla', 'Egyiptomi mau', '2019-05-06', 'Girl', 3, 2, 3, 4, 5, 2, 5, 3, 2, 5, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fhu.wikipedia.org%2Fwiki%2FEgyiptomi_mau&psig=AOvVaw3GPnedg4OQrQgh-_8tdtR3&ust=1732006218191000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOjmxpLA5YkDFQAAAAAdAAAAABAI', NULL, NULL, NULL),
(25, 'Gombóc', 'Balinéz', '2022-08-13', 'Boy', 5, 4, 3, 4, 5, 3, 5, 4, 2, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/03/Balin%C3%A9z-macska.jpeg', NULL, NULL, NULL),
(26, 'Rozsdi', 'Amerikai rövidszőrű', '2020-02-16', 'girl', 5, 4, 4, 4, 4, 3, 5, 5, 3, 3, 'https://www.zooplus.hu/magazin/wp-content/uploads/2017/06/fotolia_138223631-768x512.jpg', NULL, NULL, NULL),
(27, 'Léna', 'Tonkinéz', '2018-03-12', 'Girl', 5, 3, 3, 3, 4, 3, 2, 4, 5, 3, 'https://macskafajtak.hu/kepek/tonkinez-macska/tonkinez-macska-01.jpg', NULL, NULL, NULL),
(28, 'Kormi', 'Chartreux', '2021-02-07', 'Boy', 5, 4, 2, 3, 4, 5, 1, 3, 4, 5, 'https://upload.wikimedia.org/wikipedia/commons/3/3c/IC_Blue_Melody_Flipper_CHA_male_EX1_CACIB.jpg', NULL, NULL, NULL),
(29, 'Süni', 'Lykoi', '2019-07-19', 'Boy', 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 'https://www.azenmacskam.hu/wp-content/uploads/2023/01/gettyimages-1230422049.jpg', NULL, NULL, NULL),
(30, 'Zizi', 'Selkirk Rex', '2020-11-23', 'Girl', 4, 4, 4, 3, 3, 2, 3, 4, 3, 3, 'https://www.zooplus.hu/magazin/wp-content/uploads/2021/11/Selkirk-Rex-katze-768x512-1.jpeg', NULL, NULL, NULL),
(31, 'Vihar', 'Keleti rövidszőrű', '2018-05-13', 'Boy', 4, 4, 3, 4, 5, 1, 3, 3, 1, 3, 'https://www.zooplus.hu/magazin/wp-content/uploads/2023/02/AdobeStock_351639199-768x512-1.jpeg', NULL, NULL, NULL),
(32, 'Hópihe', '', '2022-04-02', 'Girl', 5, 4, 3, 2, 5, 4, 3, 2, 3, 5, 'https://macskafajtak.hu/kepek/szomali-macska/szomali-macska-02.jpg', NULL, NULL, NULL),
(33, 'Peti', 'Havanna barna', '2021-09-28', 'Boy', 5, 3, 4, 2, 4, 3, 5, 2, 3, 5, 'https://www.azenmacskam.hu/wp-content/uploads/2022/10/gettyimages-1253996764-360x540.jpg', NULL, NULL, NULL),
(34, 'Mimi', 'Singapura', '2019-12-03', 'Girl', 5, 4, 3, 2, 5, 4, 3, 2, 5, 4, 'https://icatcare.org/app/uploads/2018/10/singapura-1.jpg', NULL, NULL, NULL),
(35, 'Cuki', 'Pixie-bob', '2020-03-21', 'Boy', 5, 4, 3, 2, 5, 4, 3, 2, 5, 4, 'https://cdn-images.vetstreet.com/06/97c900a34011e087a80050568d634f/file/Pixie-Bob-4-645mk062311.jpg', NULL, NULL, NULL),
(36, 'Luna', 'Snowsho cat', '2018-07-11', 'Girl', 5, 4, 3, 5, 4, 5, 3, 2, 5, 4, 'https://www.azenmacskam.hu/wp-content/uploads/2022/04/gettyimages-1083243006-360x240.jpg', NULL, NULL, NULL),
(37, 'Zorró', 'Amerikai drotszőrű', '2022-06-26', 'Boy', 5, 4, 2, 3, 3, 4, 4, 5, 4, 3, 'https://www.azenmacskam.hu/wp-content/uploads/2022/04/amerikai-drotszoru.jpg', NULL, NULL, NULL),
(38, 'Nala', 'Amerikai csonkafarkú', '2021-12-20', 'Girl', 4, 3, 2, 1, 4, 5, 4, 3, 2, 2, 'https://macskafajtak.hu/kepek/rovidszoru-amerikai-csonkafarku-macska/rovidszoru-amerikai-csonkafarku-macska-04.jpg', NULL, NULL, NULL),
(39, 'Maxi', 'Laperm', '2019-08-30', 'Boy', 5, 4, 5, 5, 5, 4, 3, 2, 4, 4, 'https://catmania.hu/wp-content/uploads/2023/10/laperm-macska3.jpg', NULL, NULL, NULL),
(40, 'Dió', 'Munckin', '2020-10-08', 'Boy', 4, 3, 2, 5, 4, 3, 2, 4, 5, 5, 'https://www.azenmacskam.hu/wp-content/uploads/2022/12/gettyimages-1281446002.jpg', NULL, NULL, NULL),
(41, 'Füge', 'Korat', '2018-09-05', 'Boy', 5, 4, 3, 2, 4, 5, 4, 3, 2, 4, 'https://www.azenmacskam.hu/wp-content/uploads/2022/08/gettyimages-1312777957.jpg', NULL, NULL, NULL),
(42, 'Tünci', 'Jávai', '2022-01-25', 'Girl', 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 'https://fashion.decorexpro.com/images/article/orig/2019/03/yavanskaya-koshka-kak-vyglyadit-i-kak-za-nej-uhazhivat-5.jpg', NULL, NULL, NULL),
(43, 'Boróka', 'Nebelung', '2021-06-12', 'Girl', 5, 4, 3, 4, 5, 2, 3, 4, 5, 5, 'https://www.zooplus.co.uk/magazine/wp-content/uploads/2021/10/Nebelung-sitting-on-the-grass.jpeg', NULL, NULL, NULL),
(44, 'Mazsola', 'Colorpoint rövidszőrű', '2020-09-15', 'Boy', 5, 4, 3, 5, 4, 4, 3, 3, 2, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/01/Brit-R%C3%B6vidsz%C5%91r%C5%B1.jpg', NULL, NULL, NULL),
(45, 'Vendel', 'Savannah', '2019-04-04', 'Boy', 5, 4, 3, 4, 5, 3, 4, 5, 4, 5, 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Savannah_Cat_portrait.jpg', NULL, NULL, NULL),
(46, 'Szofi', 'Toyger\r\n', '2018-08-19', 'Girl', 4, 3, 4, 5, 3, 4, 5, 4, 3, 2, 'https://www.pet4you.hu/img/big/Toyger_800x800px.jpg', NULL, NULL, NULL),
(47, 'Frici', 'Peterbald', '2022-07-01', 'Boy', 4, 3, 5, 4, 3, 2, 5, 4, 1, 3, 'https://upload.wikimedia.org/wikipedia/commons/c/c7/Peterbald_male_Shango_by_Irina_Polunina.jpg', NULL, NULL, NULL),
(48, 'Cili', 'Kuril-szigeti csonkafarkú', '2021-03-18', 'Girl', 5, 4, 3, 2, 4, 3, 4, 5, 4, 5, 'https://www.azenmacskam.hu/wp-content/uploads/2024/04/gettyimages-87584783-1.jpg', NULL, NULL, NULL),
(49, 'Lacika', 'Donskov cat', '2019-11-27', 'Boy', 4, 3, 3, 2, 5, 3, 1, 2, 3, 4, 'https://www.purina.hu/sites/default/files/styles/ttt_image_510/public/2024-01/sitesdefaultfilesstylessquare_medium_440x440public2022-06Sphynx.2.jpg?itok=YxfjUmhw', NULL, NULL, NULL),
(50, 'Eper', 'Balinéz hosszúszőrű', '2020-12-29', 'Girl', 4, 3, 2, 1, 4, 3, 2, 4, 3, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/03/Balin%C3%A9z-macska-768x512.jpeg', NULL, NULL, NULL),
(51, 'Kókusz', 'Khao Manee', '2022-10-11', 'Boy', 3, 2, 4, 3, 5, 2, 1, 4, 3, 5, 'https://www.azenmacskam.hu/wp-content/uploads/2023/01/gettyimages-1438545714.jpg', NULL, NULL, NULL),
(52, 'Menta', 'Thai macska', '2018-02-22', 'Girl', 3, 2, 3, 4, 3, 2, 4, 5, 4, 3, 'https://www.zooplus.hu/magazin/wp-content/uploads/2019/06/thai-katze-sitzt-auf-treppe-768x512-1.jpg', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `dog`
--

CREATE TABLE `dog` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `breed` varchar(100) NOT NULL,
  `age` date DEFAULT NULL,
  `gender` varchar(100) NOT NULL,
  `kids_friendly` int(8) NOT NULL,
  `apartmnet_friendly` int(8) NOT NULL,
  `tendency_to_gain_weight` int(8) NOT NULL,
  `health` int(8) NOT NULL,
  `intelligence` int(8) NOT NULL,
  `tedency_to_Escape` int(8) NOT NULL,
  `playfulness` int(8) NOT NULL,
  `cat_friendly` int(8) NOT NULL,
  `energy_level` int(8) NOT NULL,
  `dog_img` text NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shelter_id` int(11) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `dog`
--

INSERT INTO `dog` (`id`, `name`, `breed`, `age`, `gender`, `kids_friendly`, `apartmnet_friendly`, `tendency_to_gain_weight`, `health`, `intelligence`, `tedency_to_Escape`, `playfulness`, `cat_friendly`, `energy_level`, `dog_img`, `user_id`, `shelter_id`, `cat_id`) VALUES
(1, 'Arthur', 'Golden retriever', '2020-06-10', 'Boy', 5, 1, 4, 3, 2, 4, 3, 2, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2017/03/gl%C3%BCcklich-golden-retriever-welpe.jpg', NULL, NULL, NULL),
(2, 'Pamacs', 'Puli', '2023-09-11', 'Boy', 1, 3, 3, 3, 5, 5, 3, 0, 5, 'https://upload.wikimedia.org/wikipedia/commons/a/af/Csalfa_Sommer_07_10_A.jpg', NULL, NULL, NULL),
(3, 'Herceg', 'Miniature daschund', '2020-09-08', 'Boy', 5, 5, 5, 4, 4, 5, 5, 3, 5, 'https://upload.wikimedia.org/wikipedia/commons/a/a1/Standard-Dachshund.jpg', NULL, NULL, NULL),
(4, 'Betsy', 'Bulldog', '2024-04-10', 'Girl', 5, 5, 2, 4, 4, 5, 5, 5, 5, 'https://dogtime.com/wp-content/uploads/sites/12/2011/01/GettyImages-168620477.jpg?resize=1200,630', NULL, NULL, NULL),
(5, 'Cézár', 'Kaukázusi juhászkutya', '2018-08-08', 'Boy', 1, 0, 5, 5, 5, 3, 2, 0, 5, 'https://www.haziallat.hu/upload/4/article/6032/kaukazusi_juhaszkutya.jpg', NULL, NULL, NULL),
(6, 'Pöttyös', 'Dalmata', '2016-10-11', 'Boy', 4, 1, 3, 4, 5, 4, 3, 2, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToSTQX0ggOB1eG1XpVlXBHdmisZizzC7UP8Q&s', NULL, NULL, NULL),
(7, 'Ella', 'Agár', '2022-10-05', 'Girl', 2, 1, 3, 4, 4, 3, 4, 2, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2019/10/Whippet-768x513.jpg', NULL, NULL, NULL),
(8, 'Ero', 'Cseh farkaskutya', '2021-12-03', 'Boy', 3, 4, 2, 3, 2, 1, 3, 4, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/04/csehszlov%C3%A1k-farkaskutya-768x512.jpeg', NULL, NULL, NULL),
(9, 'Baba', 'Husky', '2021-05-02', 'Boy', 5, 4, 3, 4, 4, 5, 4, 3, 4, 'https://petchef.hu/gazdiknak/wp-content/uploads/2022/11/18/Ne%CC%81vtelen-terv-8.png', NULL, NULL, NULL),
(10, 'Fifi', 'Palota pincsi', '2014-12-20', 'Girl', 5, 4, 3, 4, 2, 3, 1, 3, 5, '', NULL, NULL, NULL),
(11, 'Cuki', 'Németjuhász', '2010-10-12', 'Girl', 5, 4, 3, 4, 2, 3, 4, 5, 4, 'https://hamuesgyemant.hu/media-library/kolyok-nemetjuhasz.jpg?id=50775019&width=1200&height=800&quality=85&coordinates=0%2C0%2C0%2C1', NULL, NULL, NULL),
(12, 'Bundi', 'Afgán agár', '2019-10-12', 'Girl', 2, 5, 5, 5, 5, 4, 3, 2, 5, 'https://upload.wikimedia.org/wikipedia/commons/f/fe/Afghan_Hound.jpg', NULL, NULL, NULL),
(13, 'Mamlasz', 'Bernáthegyi', '2020-10-12', 'Boy', 5, 1, 3, 2, 5, 4, 3, 4, 2, 'https://www.zooplus.hu/magazin/wp-content/uploads/2017/03/bernhardiner-im-schnee.jpg', NULL, NULL, NULL),
(14, 'Szőrmok', 'border collie', '2021-10-12', 'Boy', 4, 5, 3, 5, 4, 3, 5, 3, 4, 'https://www.zooplus.hu/magazin/wp-content/uploads/2017/03/border-collie-im-grass.jpg', NULL, NULL, NULL),
(15, 'Lucy', 'Csivava', '2022-10-12', 'Girl', 2, 5, 3, 2, 5, 0, 3, 0, 5, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Chihuahuasmoothcoat.jpg/250px-Chihuahuasmoothcoat.jpg', NULL, NULL, NULL),
(16, 'Luna', 'Beagle', '2018-11-20', 'Girl', 5, 4, 5, 4, 3, 4, 5, 3, 5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQJn_m2iAFa8F2UgRSr9UzTZjhaMeoXmGxmw&s', NULL, NULL, NULL),
(17, 'Max', 'Labrador retriever', '2020-03-24', 'Boy', 5, 3, 5, 4, 4, 2, 5, 4, 4, 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Yellow_Labrador_Retriever_2.jpg/640px-Yellow_Labrador_Retriever_2.jpg', NULL, NULL, NULL),
(18, 'Bella', 'shih tzu', '2019-10-23', 'Girl', 4, 5, 4, 4, 3, 2, 3, 4, 2, 'https://www.zooplus.hu/magazin/wp-content/uploads/2018/10/Shih-Tzu.jpeg', NULL, NULL, NULL),
(19, 'Rocky', 'Boxer', '2019-07-15', 'Boy', 5, 3, 3, 3, 4, 3, 5, 2, 4, 'https://kutyafajtak.kutyanev.hu/wp-content/uploads/2023/04/boxer.jpg', NULL, NULL, NULL),
(20, 'Daisy', 'Pembroke Welsh Corgi', '2021-09-17', 'Girl', 5, 5, 5, 4, 4, 2, 4, 4, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVIwFO-6QJqYrzHu8MH9gPNLO8TbDfwDx_Pw&s', NULL, NULL, NULL),
(21, 'Charlie', 'Vizsla', '2019-10-12', 'Boy', 5, 3, 3, 4, 5, 4, 5, 3, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2019/08/Magyar-Vizsla.jpg', NULL, NULL, NULL),
(22, 'Lily', 'Cavalier King Charles spániel', '2018-02-15', 'Girl', 5, 5, 4, 3, 4, 1, 4, 5, 3, 'https://www.zooplus.hu/magazin/wp-content/uploads/2017/03/cavalier-king-charles-welpe.jpg', NULL, NULL, NULL),
(23, 'Milo', 'Shetlandi juhászkutya', '2022-12-23', 'Boy', 5, 4, 3, 4, 5, 3, 5, 4, 4, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/03/Shetlandi-juh%C3%A1szkutya-768x512.jpeg', NULL, NULL, NULL),
(24, 'Ruby', 'Pomerániai törpespricc', '2019-11-24', 'Girl', 4, 5, 4, 4, 3, 2, 5, 4, 4, 'https://cricksydog.hu/wp-content/uploads/2023/07/png_dog_1260.png', NULL, NULL, NULL),
(25, 'Teddy', 'Malinois', '2015-11-25', 'Boy', 5, 3, 2, 4, 5, 4, 5, 3, 5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN5x26SXfuTM3LPmEkla2foAVopH8jumpMFA&s', NULL, NULL, NULL),
(26, 'Bella', 'Boston terrier', '2016-05-11', 'Girl', 5, 5, 3, 4, 4, 2, 4, 4, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_wSa6AMrFJOEqBuQjW38uppTv_xaRiXoocw&s', NULL, NULL, NULL),
(27, 'Oscar', 'Ir szetter', '2013-11-25', 'Boy', 5, 3, 3, 4, 4, 4, 5, 3, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/04/%C3%8Dr-szetter-768x510.jpeg', NULL, NULL, NULL),
(28, 'Lucy', 'Bichon Havanese', '2016-11-30', 'Girl', 5, 5, 4, 4, 4, 1, 4, 5, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHzBzyE06oqgWtKdjUMf3xk__jk9ASIIarGw&s', NULL, NULL, NULL),
(29, 'Archie', 'Angol spániel', '2015-04-25', 'Boy', 5, 4, 3, 4, 4, 2, 5, 4, 4, 'https://www.zooplus.hu/magazin/wp-content/uploads/2019/10/Angol-Cocker-Sp%C3%A1niel-768x510.jpg', NULL, NULL, NULL),
(30, 'Luna', 'Keeshond', '2015-06-03', 'Girl', 5, 4, 3, 4, 4, 3, 4, 4, 4, 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Keeshond_Majic_standing_cropped.jpg/640px-Keeshond_Majic_standing_cropped.jpg', NULL, NULL, NULL),
(31, 'Teddy', 'Shar Pei', '2016-11-12', 'Boy', 4, 4, 4, 3, 3, 2, 3, 3, 2, 'https://www.zooplus.hu/magazin/wp-content/uploads/2019/04/Shar-Pei.jpeg', NULL, NULL, NULL),
(32, 'Rosie', 'Schipperke', '2015-12-10', 'Girl', 4, 4, 3, 5, 5, 4, 4, 3, 5, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/06/Schipperke.jpeg', NULL, NULL, NULL),
(33, 'Bruno', 'Whippet', '2010-10-10', 'Boy', 5, 4, 2, 4, 4, 3, 5, 4, 5, 'https://petchef.hu/gazdiknak/wp-content/uploads/2023/03/28/whippet-kutya-kolyok.jpg', NULL, NULL, NULL),
(34, 'Bella', 'Miniatűr schnauzer', '2011-11-11', 'Girl', 5, 5, 3, 4, 5, 2, 4, 4, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjrkTRYwFPDQLqavvsXL2MOQsObcG_uPUS1A&s', NULL, NULL, NULL),
(35, 'Leo', 'Airedale terrier', '2012-12-12', 'Boy', 5, 4, 3, 4, 4, 3, 5, 3, 4, 'https://www.zooplus.hu/magazin/wp-content/uploads/2020/04/Airedale-terrier.jpeg', NULL, NULL, NULL),
(36, 'Ruby', ' Tibeti spánielt', '2024-09-12', 'Girl', 5, 4, 4, 4, 4, 2, 4, 4, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQm_hYfjV_B0Sk7V-APStPAVjo--urtUOP2xg&s', NULL, NULL, NULL),
(37, 'Duke', 'Akita Inu', '2015-12-15', 'Boy', 4, 3, 3, 4, 4, 4, 3, 2, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoDoSeHd4w9Qgut08WeekcXJYu9gHG-AAitg&s', NULL, NULL, NULL),
(38, 'Stella', 'Skót terrier', '2016-09-23', 'Girl', 4, 5, 3, 4, 4, 3, 4, 4, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0gzKpIFWPIVUToE9EdT7KrbEVDY5W6RDuDQ&s', NULL, NULL, NULL),
(39, 'Simba', 'Basenji', '2019-11-26', 'Boy', 4, 4, 2, 5, 5, 5, 4, 3, 5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShPzFrSf9yOgP8_LKTtwwKfoAdA9V2fO6DBA&s', NULL, NULL, NULL),
(40, 'Maggie', 'Papillon', '2018-12-01', 'Girl', 5, 5, 3, 4, 5, 2, 5, 5, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj2HR4W-EcUyy8_OcB7GT7wRbWS4O23rAo2Q&s', NULL, NULL, NULL),
(41, 'Toby', 'Bedlington terrier', '2014-05-14', 'Boy', 5, 5, 3, 4, 4, 3, 4, 5, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUkHtVM_jvloArQax2QwTzZ3DRoMd4I-B6Dg&s', NULL, NULL, NULL),
(42, 'Zoey', 'Lagotto Romagnolo', '2015-08-09', 'Girl', 5, 4, 3, 4, 5, 3, 5, 4, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyE6nTxOlXo5-Uh0Ku680Tmp8tFYcXUZ-_Tw&s', NULL, NULL, NULL),
(43, 'Oliver', 'Német spitz', '2021-02-15', 'Boy', 4, 5, 4, 4, 3, 2, 5, 4, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUNxDkYtdOJhk0sIYEaOijn8kNcHgMZQ3ayw&s', NULL, NULL, NULL),
(44, 'Sadie', 'Soft Coated Wheaten terrier', '2015-12-11', 'Girl', 5, 4, 3, 4, 4, 3, 4, 4, 4, 'https://www.thesprucepets.com/thmb/2g6UxOrSCW9ZvqO7MZRDZAtJAEw=/1500x0/filters:no_upscale():strip_icc()/GettyImages-466537013-1115343d979f49658c4874b6e72b2d1e.jpg', NULL, NULL, NULL),
(45, 'Bentley', 'Amerikai cocker spániel', '2022-06-04', 'Boy', 5, 4, 4, 3, 4, 2, 5, 4, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoYH2432QZDB74kRAXJBLbji9yc3hTB__tJA&s', NULL, NULL, NULL),
(46, 'Milo', 'Foxy', '2024-05-10', 'Boy', 4, 4, 3, 5, 5, 2, 4, 4, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg_tE3rhxEIdjw9pRqRXfny_8lDcJIy6KqNQ&s', NULL, NULL, NULL),
(47, 'Rosie', 'Olasz agár', '2021-08-04', 'Girl', 4, 4, 2, 4, 4, 3, 3, 4, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBrpPzbBssFeVak-cucBDtEie-IcmIJNks_w&s', NULL, NULL, NULL),
(48, 'Coco', 'Erdélyi kopó', '2023-06-12', 'Girl', 4, 3, 2, 5, 4, 4, 4, 3, 4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq4FSwhj8l8DF3HqFkoEQyXbJPgvGKKPiSVg&s', NULL, NULL, NULL),
(49, 'Max', 'Appenzeller havasi kutya', '2021-12-25', 'Boy', 5, 3, 3, 5, 4, 3, 5, 3, 5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpyklemGmONFpewIf33uWnnWucJ0Du2iA2Vg&s', NULL, NULL, NULL),
(50, 'Lily', 'Norvég buhund', '2023-12-13', 'Girl', 5, 4, 3, 5, 4, 3, 5, 4, 4, 'https://upload.wikimedia.org/wikipedia/commons/3/3b/Norwegian_Buhund_600.jpg', NULL, NULL, NULL),
(51, 'Toby ', 'Komondor', '2021-08-15', 'Boy', 5, 3, 3, 4, 4, 2, 3, 4, 3, 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Komondor_delvin.jpg/640px-Komondor_delvin.jpg', NULL, NULL, NULL),
(52, 'Bella', 'Tibeti terrier', '2022-10-12', 'Girl', 5, 5, 4, 4, 4, 2, 4, 5, 3, 'https://www.azenkutyam.hu/wp-content/smush-webp/2022/03/gettyimages-488438607-360x540.jpg.webp', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shelter`
--

CREATE TABLE `shelter` (
  `id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `web_address` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `shelter_name` varchar(255) NOT NULL,
  `director_name` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dog_id` int(11) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `shelter`
--

INSERT INTO `shelter` (`id`, `address`, `web_address`, `email`, `phone_number`, `shelter_name`, `director_name`, `comment`, `user_id`, `dog_id`, `cat_id`) VALUES
(1, 'Béke utca 0328/1 hrsz, gyepmesteri telep, Dombóvár, Hungary', 'https://www.facebook.com/helpgazdikeresok/?locale=hu_HU', 'helpdombovar@gmail.com', '06306017564', 'Gyepmesteri Telep Dombóvár', 'Tieger Endre', 'Nyitvatartási idő:\r\nhétfő\r\n14:30 – 16:30\r\nkedd\r\n14:30 – 16:30\r\nszerda\r\n14:30 – 16:30\r\ncsütörtök\r\n14:30 – 16:30\r\npéntek\r\n14:30 – 16:30\r\nszombat\r\n14:30 – 16:30\r\nvasárnap\r\n14:30 – 16:30', NULL, NULL, NULL),
(2, 'Csörge tói utca, Szekszárd, Hungary', 'https://www.facebook.com/p/Szeksz%C3%A1rdi-Kutyamenhely-100064310604959/', 'tmallatvedo@gmail.com', '06209810558', 'Szekszárdi kutyamenhely', 'Valami Szilvi', 'Nyitvatartási idő:\r\nCsak szombat:10:00-16:00', NULL, NULL, NULL),
(3, 'Pécs, Pajtás utca 17, 7691', 'https://misina.hu/', 'misina@t-online.hu', '(06 72) 337 035\r\n', 'Misina Természet- és Állatvédő Egyesület (Pécs)', '??', 'Nyitva tartási idő:\r\nMinden nap\r\n9:00 – 16:00', NULL, NULL, NULL),
(4, '7030 Paks, Babits Mihály u. 2 / 11.', 'Honlap: http://paksiallatmenhely.ivph.info\r\nFacebook:https://www.facebook.com/Paksimenhely/', ' paksimenhely@gmail.com\r\n\r\n', ' 06-70-945-0612 ', 'Váczikai Cerberus Alapítvány \r\n', 'Gál Tiborné (Erzsike)', 'Nyitva tartási idő:\r\nMinden nap:\r\n12:00-17:00', NULL, NULL, NULL),
(5, 'Sia dűlő 20, Szeged, Hungary', 'https://www.tappancs.hu/?fbclid=IwY2xjawGmnqJleHRuA2FlbQIxMAABHRHdjEoZ8b5adrNIewLc87haWQSUUvqd0OWm27sBdATwgkz7pVUdEGwZEw_aem_NdE0Q3FDZ3F7eVRDtdDq0w\r\n', 'info@tappancs.hu', '06(70) 380 9922', 'Tappancs Állatvédő Alapítvány', '??', '??', NULL, NULL, NULL),
(6, '0334/169 hrsz., Cegléd, Hungary', 'https://allatmenhelycegled.hu/?fbclid=IwY2xjawGmn4JleHRuA2FlbQIxMAABHX9CwG82gLyw3IPeYKWBU2gwz_CCAzZne071RnNIKFv8rd4JnYLxsPCe2Q_aem_SStrDJ2afFyq6Mo1BRft-A', 'cegled.allatmenhely@gmail.com', '06(20) 566 1536', 'Állatmenhely Nyílt Alapítvány Cegléd ', '??', 'Nyitva tartás idő:\r\nhétfő\r\n14:30 – 16:00\r\nkedd\r\n14:30 – 16:30\r\nszerda\r\n14:30 – 16:00\r\ncsütörtök\r\n14:30 – 16:00\r\npéntek\r\n14:30 – 16:30\r\nszombat\r\n14:30 – 16:30\r\nvasárnap\r\n14:30 – 16:30', NULL, NULL, NULL),
(7, 'Szikhát 0141/48 hrsz, Orosháza, Hungary', 'https://oroshaziallatvedok.hu/?fbclid=IwY2xjawGmoH9leHRuA2FlbQIxMAABHdAS4hmTIVvoI5qZD0R_ktQgGkgejJz1DrIVufLqofY4tQeOUPkB0_AGbA_aem_Aa4aIiQlsLL9MSyGSxvuog', 'oroshaziallatvedok@freemail.hu', '??', 'Orosházi Állat És Természetvédő Közhasznú Egyesület - Szikhát Kutyamenhely ', '??', 'Nyitva tartási idő:\r\nSzerda és Péntek:\r\n10:00-14:00', NULL, NULL, NULL),
(8, 'MENHELY: Kétegyházi út 30. szám, Békéscsaba, Hungary\r\n\r\n', 'https://www.csabaiallatvedok.hu/?fbclid=IwY2xjawGmoTxleHRuA2FlbQIxMAABHZIjBi84bLorLrhW_BKJ5h-_mWOOzDpbl_b1omWglb7lt7DLobDFuqUdBg_aem_VFM_ychuAcNUdU3dsXHJvQ', 'csabaiallatvedok.hu@gmail.com', '06(20) 380 0848', 'Csabai Állatvédők Khe \r\n', '??', 'Nyitva tartási idő:\r\nhétfő\r\n10:00 – 15:00\r\nkedd\r\n10:00 – 15:00\r\nszerda\r\n10:00 – 15:00\r\ncsütörtök\r\n10:00 – 15:00\r\npéntek\r\n10:00 – 15:00\r\nszombat\r\n10:00 – 13:00\r\nvasárnap\r\n10:00 – 13:00', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shelterxcat`
--

CREATE TABLE `shelterxcat` (
  `id` int(11) NOT NULL,
  `shelter_id` int(11) NOT NULL,
  `cat_id` int(11) NOT NULL,
  `arrivel_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shelterxdog`
--

CREATE TABLE `shelterxdog` (
  `id` int(11) NOT NULL,
  `shelter_id` int(11) NOT NULL,
  `dog_id` int(11) NOT NULL,
  `arrivel_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shelter_worker`
--

CREATE TABLE `shelter_worker` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `job_position` varchar(100) NOT NULL,
  `start_date` datetime NOT NULL,
  `shelter_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `shelter_worker`
--

INSERT INTO `shelter_worker` (`id`, `name`, `email`, `phone_number`, `job_position`, `start_date`, `shelter_id`) VALUES
(1, 'Menhely Péter', 'Menhelypeter45@gmail.com', '063067876523', 'Főnök', '2024-11-11 08:52:38', 1),
(2, 'Menhely István', 'Menhelyistván162@gmail.com', '06702345982', 'Beosztott', '2024-11-11 08:54:25', 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `age` int(8) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `age`, `email`, `password`, `phone_number`) VALUES
(1, 'Minta', 'Péter', 25, 'Mintapeter11@gmail.com', '447d51f174e77350c26333cffd2b1470b769865d', '06203456780'),
(2, 'Minta ', 'Lajos', 22, 'Mintalajos10@gmail.com', '447d51f174e77350c26333cffd2b1470b769865d', '06704567432');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `userxshelter`
--

CREATE TABLE `userxshelter` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `shelter_id` int(11) DEFAULT NULL,
  `role` int(8) NOT NULL,
  `connection_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `cat`
--
ALTER TABLE `cat`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `dog`
--
ALTER TABLE `dog`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `shelter`
--
ALTER TABLE `shelter`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `shelterxcat`
--
ALTER TABLE `shelterxcat`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `shelterxdog`
--
ALTER TABLE `shelterxdog`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `shelter_worker`
--
ALTER TABLE `shelter_worker`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `userxshelter`
--
ALTER TABLE `userxshelter`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `cat`
--
ALTER TABLE `cat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT a táblához `dog`
--
ALTER TABLE `dog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT a táblához `shelter`
--
ALTER TABLE `shelter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT a táblához `shelterxcat`
--
ALTER TABLE `shelterxcat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `shelterxdog`
--
ALTER TABLE `shelterxdog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `shelter_worker`
--
ALTER TABLE `shelter_worker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `userxshelter`
--
ALTER TABLE `userxshelter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
