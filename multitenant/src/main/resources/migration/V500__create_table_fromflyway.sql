CREATE TABLE IF NOT EXISTS tenant2schema.tablefromflyway
(
    uid bigint NOT NULL,
    uname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tablefromflyway_pkey PRIMARY KEY (uid)
)