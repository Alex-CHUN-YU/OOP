-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1
-- 產生時間： 2017-11-04 12:18:08
-- 伺服器版本: 10.1.28-MariaDB
-- PHP 版本： 7.0.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `flight_booking`
--

-- --------------------------------------------------------

--
-- 資料表結構 `airline_company`
--

CREATE TABLE `airline_company` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `flight_number` int(20) NOT NULL,
  `departure_airport` varchar(40) NOT NULL,
  `departure_date` varchar(40) NOT NULL,
  `arrival_airport` varchar(40) NOT NULL,
  `arrival_date` varchar(40) NOT NULL,
  `validity_period` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `airline_company`
--

INSERT INTO `airline_company` (`id`, `name`, `flight_number`, `departure_airport`, `departure_date`, `arrival_airport`, `arrival_date`, `validity_period`) VALUES
(1, 'BR', 0, 'Taoyuan International', '2017-10-18 13:00', 'Melbourne', '2017-10-19 9:00', 10),
(2, 'BR', 1, 'Kaohsiung International', '2017-10-18 13:00', 'Heathrow', '2017-10-18 15:00', 9),
(4, 'CI', 0, 'Melbourne', '2017-11-11 13:00', 'Taoyuan International', '2017-11-13 13:00', 7),
(5, 'GE', 0, 'John F. Kennedy International', '2017-12-19 13:00', 'Tainan', '2017-12-20 07:00', 7),
(6, 'GE', 1, 'Kaohsiung International', '2017-10-19 15:00', 'Songshan', '2017-10-19 20:00', 5),
(11, 'CI', 1, 'Songshan', '2017-11-01 09:00', 'Charles de Gaulle', '2017-11-02 05:00', 7),
(12, 'CI', 2, 'Charles de Gaulle', '2017-10-19 13:00', 'John F. Kennedy International', '2017-10-20 9:00', 5),
(13, 'BR', 2, 'Melbourne', '2017-12-19 13:00', 'Charles de Gaulle', '2017-12-20 13:00', 11),
(14, 'BR', 3, 'Tainan', '2017-11-19 13:00', 'Kaohsiung International', '2017-11-19 15:00', 13),
(16, 'JAL', 0, 'Tokyo', '2017-11-12 13:00', 'Osaka', '2017-11-12 14:00', 7),
(17, 'FE', 0, 'Melbourne', '2017-12-25 13:00', 'Songshan', '2017-12-26 3:00', 4),
(25, 'GE', 2, 'Taoyuan International', '2017-12-19 13:00', 'Heathrow', '2017-12-20 09:00', 4),
(27, 'FE', 2, 'Charles de Gaulle', '2017-12-06 09:00', 'Taoyuan International', '2017-12-07 07:00', 4);

-- --------------------------------------------------------

--
-- 資料表結構 `customer_flight_booking`
--

CREATE TABLE `customer_flight_booking` (
  `name` varchar(40) NOT NULL,
  `flight_number` varchar(40) NOT NULL,
  `booking_id` varchar(20) NOT NULL,
  `customer_name` varchar(20) NOT NULL,
  `customer_foreign_name` varchar(20) NOT NULL,
  `customer_address` varchar(20) NOT NULL,
  `customer_phone_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `customer_flight_booking`
--

INSERT INTO `customer_flight_booking` (`name`, `flight_number`, `booking_id`, `customer_name`, `customer_foreign_name`, `customer_address`, `customer_phone_number`) VALUES
('GE', '2', '3GE5c', '盧廣仲', 'Crowd Lu', 'Taiwan', '0988745689'),
('BR', '2', '9BR3b', '簡君聿', 'ALEX', 'Taiwan', '0988719738'),
('CI', '0', '9CI3', '張忠謨', 'Chalie Puth', 'taipai', '0988745632'),
('CI', '0', '9CI6d', '周杰倫', 'Jay Chou', 'Taiwan Taipai', '0988719738');

-- --------------------------------------------------------

--
-- 資料表結構 `passengers`
--

CREATE TABLE `passengers` (
  `id` int(20) NOT NULL,
  `booking_id` varchar(20) NOT NULL,
  `passenger_name` varchar(20) NOT NULL,
  `passenger_foreign_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `passengers`
--

INSERT INTO `passengers` (`id`, `booking_id`, `passenger_name`, `passenger_foreign_name`) VALUES
(9, '9CI6d', '昆凌', 'Hannah Quinlivan'),
(10, '9CI6d', '周杰倫', 'Jay Chou'),
(11, '3GE5c', '盧廣仲', 'Crowd Lu'),
(12, '3GE5c', '陳綺貞', 'Cheer Chen'),
(14, '1BR1b', '小美', 'Marry'),
(15, '9BR3b', '查理', 'Charlie');

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `airline_company`
--
ALTER TABLE `airline_company`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `customer_flight_booking`
--
ALTER TABLE `customer_flight_booking`
  ADD PRIMARY KEY (`booking_id`);

--
-- 資料表索引 `passengers`
--
ALTER TABLE `passengers`
  ADD PRIMARY KEY (`id`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `airline_company`
--
ALTER TABLE `airline_company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- 使用資料表 AUTO_INCREMENT `passengers`
--
ALTER TABLE `passengers`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
