CREATE TABLE cpu
(
    id        BIGINT           NOT NULL,
    name      VARCHAR(255)     NOT NULL,
    frequency DOUBLE PRECISION NOT NULL,
    cores     INTEGER          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE gpu
(
    id          BIGINT           NOT NULL,
    name        VARCHAR(255)     NOT NULL,
    memory_size INTEGER          NOT NULL,
    clock_speed DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id)
);