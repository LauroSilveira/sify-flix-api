CREATE SCHEMA SIFY_SCHEMA;
CREATE TABLE sify_schema.ship
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name  VARCHAR(255),
    model VARCHAR(255),
    size  DOUBLE PRECISION,
    CONSTRAINT pk_ship PRIMARY KEY (id)
);