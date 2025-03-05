DO $$
BEGIN
        IF NOT EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEME_NAME = 'TEST')
            EXECUTE 'CREATE SCHEMA TEST';
        END IF;
END $$;

CREATE TABLE IF NOT EXISTS test.alt_orgx (
                          alt_org_id BIGINT NOT NULL,
                          org_id INT NOT NULL,
                          alt_sys_cd  CHAR(10),
                          alt_ref VARCHAR(40),
                          alt_ref_type CHAR(10),
                          trigger_autogen_cascade BOOLEAN,
                          tms_control_id BIGINT NOT NULL,
                          version_num SMALLINT,
                          sys_user VARCHAR(60),
                          sys_dt TIMESTAMP,
                          proposal_user VARCHAR(60),
                          proposal_dt TIMESTAMP,
                          created_by_role BOOLEAN
);