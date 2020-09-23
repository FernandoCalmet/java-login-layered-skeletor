-- ----------------------------
-- Table structure for USERS
-- ----------------------------
CREATE TABLE USERS (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  username VARCHAR(100) NOT NULL,
  firstName VARCHAR(100) NOT NULL,
  email VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(128),
  role VARCHAR(50) NOT NULL,
  createdAt TIMESTAMP NOT NULL,
  updatedAt TIMESTAMP
);

-- ----------------------------
-- Records of USERS
-- ----------------------------
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('juan', 'Juan', 'juanmartin@mail.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('james', 'James', 'jbond@yahoo.net', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('lionel', 'Lionel', 'mess10@gmail.gol', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('carlos', 'Carlos', 'bianchini@hotmail.com.ar', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('diego', 'Diego', 'diego1010@gmail.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('one', 'One User', 'one@user.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('diegol', 'Diegol', 'diego@gol.com.ar', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('test', 'Test User', 'test@user.com', 'AnyPass1000', 'Cliente', '2020-11-09 01:58:41');
INSERT INTO USERS (username, firstName, email, password, role, createdAt) VALUES ('admin', 'Admin User', 'admin@user.com', 'admin', 'Administrador', '2020-11-09 01:58:41');

-- ----------------------------
-- Table structure for NOTES
-- ----------------------------
CREATE TABLE NOTES (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(200),
  createdAt TIMESTAMP NOT NULL,
  updatedAt TIMESTAMP
 );

-- ----------------------------
-- Records of NOTES
-- ----------------------------
INSERT INTO NOTES (name, description, createdAt) VALUES ('My Note 1', 'My first online note', '2020-11-09 01:58:41');
INSERT INTO NOTES (name, description, createdAt) VALUES ('Chinese Proverb', 'Those who say it can not be done, should not interrupt those doing it.', '2020-11-09 01:58:41');
INSERT INTO NOTES (name, description, createdAt) VALUES ('Long Note 3', 'This is a very large note, or maybe not...', '2020-11-09 01:58:41');
INSERT INTO NOTES (name, description, createdAt) VALUES ('Napoleon Hill', 'Whatever the mind of man can conceive and believe, it can achieve.', '2020-11-09 01:58:41');
INSERT INTO NOTES (name, description, createdAt) VALUES ('Note 5', 'A Random Note', '2020-11-09 01:58:41');

-- ----------------------------
-- Table structure for TASKS
-- ----------------------------
CREATE TABLE TASKS (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(200),
  status SMALLINT NOT NULL DEFAULT 0,
  userId INTEGER NOT NULL REFERENCES USERS(id),
  createdAt TIMESTAMP NOT NULL,
  updatedAt TIMESTAMP
);

-- ----------------------------
-- Records of TASKS
-- ----------------------------
INSERT INTO TASKS (name, status, userId, createdAt) VALUES ('Go to cinema', 1, 8, '2020-11-09 01:58:41');
INSERT INTO TASKS (name, status, userId, createdAt) VALUES ('Buy shoes', 0, 8, '2020-11-09 01:58:41');
INSERT INTO TASKS (name, status, userId, createdAt) VALUES ('Go to shopping', 0, 8, '2020-11-09 01:58:41');
INSERT INTO TASKS (name, status, userId, createdAt) VALUES ('Pay the credit card ;-)', 1, 8, '2020-11-09 01:58:41');
INSERT INTO TASKS (name, status, userId, createdAt) VALUES ('Do math homework...', 0, 8, '2020-11-09 01:58:41');
INSERT INTO TASKS (name, status, userId, createdAt) VALUES ('Just Testing...', 1, 1, '2020-11-09 01:58:41');