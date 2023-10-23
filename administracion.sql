-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2023 a las 03:49:22
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `administracion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `idComida` int(200) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `detalle` varchar(120) NOT NULL,
  `cantCalorias` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`idComida`, `nombre`, `detalle`, `cantCalorias`, `estado`) VALUES
(1, 'Pollo', 'pechuga a la plancha', 350, 'Inactivo'),
(2, 'Manzana', 'manzana verde', 52, 'Activo'),
(3, 'Granola', 'mix de granos', 471, 'Activo'),
(4, 'Merluza', 'Filet de merluza a la plancha', 212, 'Activo'),
(5, 'Hamburgueza', 'Hambuergueza de quinoa con vegetales teriyaki', 250, 'Inactivo'),
(6, 'Lasagna', 'Lasagna de berenjena ', 350, 'Activo'),
(7, 'Pizza', 'Pizza Integral Caprese', 380, 'Inactivo'),
(8, 'Ensalada Vegana', 'Mix de zanahorias con brocoli', 280, 'Activo'),
(9, 'Hamburgueza', 'Hambuergueza de quinoa con vegetales teriyaki', 250, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `fechaInicial` date NOT NULL,
  `pesoInicial` double NOT NULL,
  `pesoFinal` double NOT NULL,
  `pesoObtenido` double NOT NULL,
  `fechaFinal` date NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `pesoObtenido`, `fechaFinal`, `estado`) VALUES
(1, 'dieta de la luna llena', 14, '2023-10-05', 99, 70, 69, '2024-05-10', 'Activo'),
(2, 'Dieta de Ayuno', 13, '2020-11-23', 110, 78, 79, '2022-11-12', 'Activo'),
(3, 'Dieta Suprema', 3, '2020-12-23', 80, 64, 60, '2021-05-23', 'Activo'),
(4, 'Dieta Vegetariana', 1, '2023-05-05', 120, 90, 88, '2023-10-10', 'Activo'),
(5, 'Dieta Vegana', 6, '2023-11-10', 123, 90, 93, '2024-06-23', 'Activo'),
(6, 'Dieta Marina', 7, '2023-02-09', 90, 67, 66, '2023-11-23', 'Activo'),
(7, 'Dieta Marina', 11, '2023-11-23', 120, 90, 66, '2024-11-23', 'Activo'),
(8, 'Dieta Antartica', 8, '2023-09-23', 90, 68, 69, '2023-12-23', 'Activo'),
(9, 'Dieta Flexitariana', 5, '2023-10-12', 116.5, 96, 98, '2024-01-01', 'Activo'),
(10, 'Dieta Mixta', 6, '2023-10-12', 87.3, 65, 103, '2024-01-01', 'Activo'),
(12, 'Dieta Arabe', 3, '2023-10-12', 120.4, 100.5, 98.3, '2023-12-12', 'Activo'),
(13, 'Dieta Arabe', 4, '2023-10-23', 110.5, 90, 96, '2023-12-11', 'Activo'),
(14, 'Dieta Marina', 7, '2023-12-05', 190.5, 90.5, 90, '2023-06-12', 'Activo'),
(15, 'Dieta Vegana', 5, '2023-11-11', 110, 86, 95, '2023-12-12', 'Activo'),
(16, 'Dieta Vegetariana', 6, '2023-05-12', 89, 69, 70, '2023-10-12', 'Activo'),
(17, 'Dieta Matutina', 5, '2023-05-05', 128.5, 90, 0, '2023-10-05', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietacomida`
--

CREATE TABLE `dietacomida` (
  `idDietaComida` int(11) NOT NULL,
  `idDieta` int(50) NOT NULL,
  `idComida` int(58) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dietacomida`
--

INSERT INTO `dietacomida` (`idDietaComida`, `idDieta`, `idComida`) VALUES
(1, 7, 5),
(2, 8, 8),
(4, 9, 6),
(5, 7, 1),
(6, 7, 4),
(7, 7, 7),
(8, 1, 2),
(9, 1, 5),
(10, 7, 6),
(11, 2, 2),
(12, 2, 9),
(15, 8, 4),
(20, 7, 7),
(21, 6, 4),
(22, 6, 9),
(30, 9, 3),
(42, 3, 1),
(43, 3, 7),
(44, 4, 2),
(45, 4, 8),
(46, 5, 1),
(47, 5, 8),
(61, 5, 6),
(62, 3, 5),
(63, 3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietasvarias`
--

CREATE TABLE `dietasvarias` (
  `id_Dieta` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dietasvarias`
--

INSERT INTO `dietasvarias` (`id_Dieta`, `nombre`) VALUES
(1, 'dieta de la luna llena'),
(2, 'Dieta de Ayuno'),
(3, 'Dieta Suprema'),
(4, 'Dieta Vegetariana'),
(5, 'Dieta Vegana'),
(6, 'Dieta Marina'),
(7, 'Dieta Artica'),
(8, 'Dieta Antartica'),
(9, 'Dieta Flexitariana'),
(10, 'Dieta Mixta'),
(11, 'Dieta Arabe'),
(16, 'Dieta Metropolitana'),
(17, 'Dieta Romana'),
(18, 'Dieta Matutina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `dni`, `apellido`, `nombre`, `domicilio`, `telefono`, `estado`) VALUES
(1, 23675432, 'Perez', 'Mariela', 'Las Heras', '345-87655', 'Activo'),
(2, 40987111, 'Salazar ', 'Marcelina', 'Maipu S/N', '11-55334534', 'Activo'),
(3, 345678, 'Lopez', 'Juan', 'San Luis', '2664-62766', 'Activo'),
(4, 12123300, 'Reynoso ', 'Lucrecia', 'San Cristobal 11', '11-5356334', 'Activo'),
(5, 33412795, 'Bonifacio', 'Hector Ramiro', 'Los Nogales 123', '354-5632322', 'Activo'),
(6, 32723567, 'Albornoz', 'Claudia', 'Moron 345', '345-23655', 'Inactivo'),
(7, 4573345, 'IBANEZ', 'Anahi', 'Puyrredon', '355-62766', 'Activo'),
(8, 29765345, 'AVALOS', 'Agustina', 'Lumbreras', '365453323', 'Inactivo'),
(9, 28765435, 'GODOY', 'Nancy', 'Las Heras ', '342267435', 'Activo'),
(10, 234533233, 'VELIZ', 'Mario Felipe', 'Belgrano 250', '3876502243', 'Activo'),
(11, 25754363, 'PEDRAZA', 'Lautaro', 'San Luis 431', '3533578554', 'Inactivo'),
(12, 31840303, 'ALDERETE', 'Diego Eduardo', 'Belgrano 936', '3876502243', 'Activo'),
(13, 50008803, 'Alderete', 'Dylan Eduardo', 'Rio Piedras', '3876502243', 'Activo'),
(14, 59765876, 'Patron', 'Thiago', 'San Lorenzo 783', '3876502255', 'Activo'),
(15, 21213551, 'Castroman', 'Rodolfo', 'Rio Piedras', '3876503344', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `usuario`, `clave`) VALUES
(1, 'Diego', 'Alderete', 'killerchipy', '12345'),
(2, 'Valeria', 'Chica', 'valech', '12345'),
(3, 'Marko', 'Wonka', 'mwonka', '12345'),
(4, 'Analia', 'MONTEROS', 'analiaM2023', '12345');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`idComida`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD PRIMARY KEY (`idDietaComida`),
  ADD KEY `idComida` (`idDieta`),
  ADD KEY `idDieta` (`idComida`);

--
-- Indices de la tabla `dietasvarias`
--
ALTER TABLE `dietasvarias`
  ADD PRIMARY KEY (`id_Dieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `idComida` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  MODIFY `idDietaComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT de la tabla `dietasvarias`
--
ALTER TABLE `dietasvarias`
  MODIFY `id_Dieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD CONSTRAINT `dietacomida_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `comida` (`idComida`),
  ADD CONSTRAINT `dietacomida_ibfk_2` FOREIGN KEY (`idComida`) REFERENCES `dieta` (`idDieta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
