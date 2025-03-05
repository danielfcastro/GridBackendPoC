DO $$
BEGIN
        IF NOT EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEME_NAME = 'TEST')
            EXECUTE 'CREATE SCHEMA TEST';
        END IF;
END $$;

CREATE TABLE IF NOT EXISTS test.myTable (
                          id BIGINT NOT NULL,
                          age INT NOT NULL,
                          name  CHAR(10),
                          description VARCHAR(40)
);