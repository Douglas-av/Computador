--
-- File generated with SQLiteStudio v3.2.1 on seg set 30 21:43:45 2019
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Animais
CREATE TABLE Animais (
    id              INTEGER       PRIMARY KEY AUTOINCREMENT
                                  NOT NULL,
    nome            VARCHAR (255) NOT NULL,
    nome_cientifico VARCHAR (255),
    status          VARCHAR (255) NOT NULL,
    habitat         VARCHAR (255) NOT NULL,
    estado                        NOT NULL
);


-- Table: estados
CREATE TABLE estados (
    nome                             VARCHAR (255)   PRIMARY KEY
                                                     NOT NULL,
    possiveis_consequencias          VARCHAR (255)   NOT NULL,
    ano_possivel_consequencia        DATE            NOT NULL,
    porcentagem_agua_desaparecimento DECIMAL (10, 2) NOT NULL
);


-- Table: Geleiras
CREATE TABLE Geleiras (
    id              INTEGER       PRIMARY KEY AUTOINCREMENT
                                  NOT NULL,
    estado          CHAR (2)      NOT NULL,
    ultimo_dado     VARCHAR (255) NOT NULL,
    ano_ultimo_dado DATE          NOT NULL,
    dado_atual      VARCHAR (255) NOT NULL,
    ano_dado_atual  DATETIME      NOT NULL
);


-- Table: NivelDaAgua
CREATE TABLE NivelDaAgua (
    nome                             VARCHAR (255)   PRIMARY KEY
                                                     NOT NULL,
    ultimo_dado                      VARCHAR         NOT NULL,
    ano_ultimo_dado                  DATE            NOT NULL,
    dado_atual                       VARCHAR (255)   NOT NULL,
    ano_dado_atual                   DATE            NOT NULL,
    estimativa                       VARCHAR (255)   NOT NULL,
    ano_estimativa                   DATE            NOT NULL,
    porcentagem_aumento_ultimo_atual DECIMAL (10, 2) NOT NULL,
    porcentagem_aumento_atual_futura DECIMAL (10, 2) NOT NULL
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
