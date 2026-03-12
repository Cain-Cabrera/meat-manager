CREATE TABLE IF NOT EXISTS client (
    id        BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(58)  NOT NULL,
    last_name VARCHAR(58)  NOT NULL,
    dni       VARCHAR(8)   NOT NULL,
    email     VARCHAR(255) NOT NULL UNIQUE,
    age       INT          NOT NULL
    );