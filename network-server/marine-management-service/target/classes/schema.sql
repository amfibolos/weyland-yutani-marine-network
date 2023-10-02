CREATE TABLE IF NOT EXISTS `marines`
(
    id            INT AUTO_INCREMENT,
    first_name    VARCHAR(50)  NOT NULL,
    last_name     VARCHAR(50)  NOT NULL,
    military_rank VARCHAR(50)  DEFAULT NULL,
    space_force   VARCHAR(100) DEFAULT NULL,
    division      VARCHAR(100) DEFAULT NULL,
    base          VARCHAR(100) DEFAULT NULL,
    idsn          VARCHAR(100) NOT NULL UNIQUE,
    email         VARCHAR(100) NOT NULL UNIQUE,
    created_at    datetime     NOT NULL,
    created_by    varchar(20)  NOT NULL,
    updated_at    datetime     DEFAULT NULL,
    updated_by    varchar(20)  DEFAULT NULL,
    PRIMARY KEY (id)
);


select * from marines;