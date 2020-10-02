SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `firstName` varchar(50) NULL,
  `lastName` varchar(50) NULL,
  `email` varchar(50) NOT NULL UNIQUE,
  `password` varchar(128),
  `role` varchar(50) NOT NULL,
  `createdAt` timestamp NOT NULL,
  `updatedAt` timestamp NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('juan', 'Juan', 'Martin', 'juanmartin@mail.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('james', 'James', 'Bond', 'jbond@yahoo.net', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('lionel', 'Lionel', 'Mess', 'mess10@gmail.gol', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('carlos', 'Carlos', 'Bianchini' 'bianchini@hotmail.com.ar', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('diego', 'Diego', 'Somebody', 'diego1010@gmail.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('one', 'One User', 'Any', 'one@user.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('diegol', 'Diegol', 'Gol', 'diego@gol.com.ar', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('test', 'Test User', 'Prueba', 'test@user.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO `users` (`username`, `firstName`, `lastName`, `email`, `password`, `role`, `createdAt`) VALUES ('admin', 'Admin', 'User', 'admin@user.com', 'admin', 'Administrador', '2020-11-09 01:58:41');

-- ----------------------------
-- Table structure for notes
-- ----------------------------
DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  `createdAt` timestamp NOT NULL,
  `updatedAt` timestamp NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of notes
-- ----------------------------
INSERT INTO `notes` (`id`, `name`, `description`, `createdAt`) VALUES ('1', 'My Note 1', 'My first online note', '2020-11-09 01:58:41');
INSERT INTO `notes` (`id`, `name`, `description`, `createdAt`) VALUES ('2', 'Chinese Proverb', 'Those who say it can not be done, should not interrupt those doing it.', '2020-11-09 01:58:41');
INSERT INTO `notes` (`id`, `name`, `description`, `createdAt`) VALUES ('3', 'Long Note 3', 'This is a very large note, or maybe not...', '2020-11-09 01:58:41');
INSERT INTO `notes` (`id`, `name`, `description`, `createdAt`) VALUES ('4', 'Napoleon Hill', 'Whatever the mind of man can conceive and believe, it can achieve.', '2020-11-09 01:58:41');
INSERT INTO `notes` (`id`, `name`, `description`, `createdAt`) VALUES ('5', 'Note 5', 'A Random Note', '2020-11-09 01:58:41');

INSERT INTO `notes`
    (`name`, `description`)
VALUES
    ('Brian Tracy', 'Develop an attitude of gratitude, and give thanks for everything that happens to you, knowing that every step forward is a step toward achieving something bigger and better than your current situation.'),
    ('Zig Ziglar', 'Your attitude, not your aptitude, will determine your altitude.'),
    ('William James', 'The greatest discovery of my generation is that a human being can alter his life by altering his attitudes.'),
    ('Og Mandino', 'Take the attitude of a student, never be too big to ask questions, never know too much to learn something new.'),
    ('Earl Nightingale', 'Our attitude towards others determines their attitude towards us.'),
    ('Norman Vincent Peale', 'Watch your manner of speech if you wish to develop a peaceful state of mind. Start each day by affirming peaceful, contented and happy attitudes and your days will tend to be pleasant and successful.'),
    ('W. Clement Stone', 'There is little difference in people, but that little difference makes a big difference. The little difference is attitude. The big difference is whether it is positive or negative.'),
    ('Dale Carnegie', 'Happiness does not depend on any external conditions, it is governed by our mental attitude.'),
    ('Walt Disney', 'If you can dream it, you can do it.'),
    ('William Shakespeare', 'Our doubts are traitors and make us lose the good we oft might win by fearing to attempt.'),
    ('Albert Einstein', 'A person who never made a mistake never tried anything new.');

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE IF NOT EXISTS `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  `createdAt` timestamp NOT NULL,
  `updatedAt` timestamp NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `tasks_users_fk` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tasks
-- ----------------------------
INSERT INTO `tasks` (`id`, `name`, `status`, `userId`, `createdAt`) VALUES (1, 'Go to cinema', 1, 8, '2020-11-09 01:58:41');
INSERT INTO `tasks` (`id`, `name`, `status`, `userId`, `createdAt`) VALUES (2, 'Buy shoes', 0, 8, '2020-11-09 01:58:41');
INSERT INTO `tasks` (`id`, `name`, `status`, `userId`, `createdAt`) VALUES (3, 'Go to shopping', 0, 8, '2020-11-09 01:58:41');
INSERT INTO `tasks` (`id`, `name`, `status`, `userId`, `createdAt`) VALUES (4, 'Pay the credit card ;-)', 1, 8, '2020-11-09 01:58:41');
INSERT INTO `tasks` (`id`, `name`, `status`, `userId`, `createdAt`) VALUES (5, 'Do math homework...', 0, 8, '2020-11-09 01:58:41');
INSERT INTO `tasks` (`id`, `name`, `status`, `userId`, `createdAt`) VALUES (6, 'Just Testing...', 1, 1, '2020-11-09 01:58:41');


SET FOREIGN_KEY_CHECKS = 1;
