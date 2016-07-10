DROP SCHEMA public CASCADE;

CREATE SCHEMA public;

ALTER SCHEMA public OWNER TO postgres;

SET client_encoding = 'UTF8';

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE appointment (
    id bigint NOT NULL,
    color character varying(255),
    end_date bytea,
    start_date bytea,
    text character varying(255),
    doctorinfo_id bigint,
    userdetail_id bigint
);

ALTER TABLE appointment OWNER TO postgres;

CREATE SEQUENCE appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE appointment_id_seq OWNER TO postgres;

CREATE TABLE carditem (
    id bigint NOT NULL,
    complaint text,
    date timestamp without time zone,
    prescription text,
    result text,
    doctor_id bigint,
    patientcard_id bigint
);

ALTER TABLE carditem OWNER TO postgres;

CREATE SEQUENCE carditem_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE carditem_id_seq OWNER TO postgres;

CREATE TABLE databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255)
);

ALTER TABLE databasechangelog OWNER TO postgres;

CREATE TABLE databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);

ALTER TABLE databasechangeloglock OWNER TO postgres;

CREATE TABLE department (
    id bigint NOT NULL,
    imagepath character varying(255),
    name character varying(255),
    hospital_id bigint
);

ALTER TABLE department OWNER TO postgres;

CREATE TABLE department_doctorinfo (
    departments_id bigint NOT NULL,
    doctors_id bigint NOT NULL
);

ALTER TABLE department_doctorinfo OWNER TO postgres;

CREATE SEQUENCE department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE department_id_seq OWNER TO postgres;

CREATE TABLE doctorinfo (
    id bigint NOT NULL,
    specialization character varying(255),
    userdetails_id bigint
);

ALTER TABLE doctorinfo OWNER TO postgres;

CREATE SEQUENCE doctorinfo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE doctorinfo_id_seq OWNER TO postgres;

CREATE TABLE feedback (
    id bigint NOT NULL,
    date bytea,
    message character varying(255),
    consumer_id bigint,
    producer_id bigint
);

ALTER TABLE feedback OWNER TO postgres;

CREATE SEQUENCE feedback_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE feedback_id_seq OWNER TO postgres;

CREATE TABLE hospital (
    id bigint NOT NULL,
    building character varying(5),
    city character varying(30),
    country character varying(30),
    street character varying(30),
    description character varying(150) NOT NULL,
    imagepath character varying(255),
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    name character varying(50) NOT NULL,
    CONSTRAINT hospital_latitude_check CHECK (((latitude <= (90)::double precision) AND (latitude >= ('-90'::integer)::double precision))),
    CONSTRAINT hospital_longitude_check CHECK (((longitude <= (180)::double precision) AND (longitude >= ('-180'::integer)::double precision)))
);

ALTER TABLE hospital OWNER TO postgres;

CREATE SEQUENCE hospital_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE hospital_id_seq OWNER TO postgres;

CREATE TABLE hospital_users (
    hospital_id bigint NOT NULL,
    managers_id bigint NOT NULL
);

ALTER TABLE hospital_users OWNER TO postgres;

CREATE SEQUENCE password_reset_token_gen_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE password_reset_token_gen_id_seq OWNER TO postgres;

CREATE TABLE password_reset_tokens (
    id bigint NOT NULL,
    expirydate timestamp without time zone,
    token character varying(255),
    user_id bigint NOT NULL
);

ALTER TABLE password_reset_tokens OWNER TO postgres;

CREATE TABLE patientcard (
    id bigint NOT NULL,
    userdetail_id bigint
);

ALTER TABLE patientcard OWNER TO postgres;

CREATE SEQUENCE patientcard_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE patientcard_id_seq OWNER TO postgres;

CREATE TABLE patientinfo (
    id bigint NOT NULL,
    cardid character varying(255)
);

ALTER TABLE patientinfo OWNER TO postgres;

CREATE SEQUENCE patientinfo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE patientinfo_id_seq OWNER TO postgres;

CREATE TABLE persistent_logins (
    series character varying(255) NOT NULL,
    last_used timestamp without time zone,
    token character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);

ALTER TABLE persistent_logins OWNER TO postgres;

CREATE TABLE role (
    id bigint NOT NULL,
    type character varying(255) NOT NULL
);

ALTER TABLE role OWNER TO postgres;

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE role_id_seq OWNER TO postgres;

CREATE TABLE role_users (
    users_id bigint NOT NULL,
    role_id bigint NOT NULL
);

ALTER TABLE role_users OWNER TO postgres;

CREATE TABLE userdetail (
    id bigint NOT NULL,
    address character varying(255),
    birthdate bytea,
    firstname character varying(255),
    gender character varying(255),
    imagepath character varying(255),
    lastname character varying(255),
    phone character varying(255),
    patientcard_id bigint
);

ALTER TABLE userdetail OWNER TO postgres;

CREATE SEQUENCE userdetail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE userdetail_id_seq OWNER TO postgres;

CREATE TABLE users (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    enabled boolean NOT NULL,
    password character varying(255) NOT NULL,
    userdetails_id bigint
);

ALTER TABLE users OWNER TO postgres;

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE users_id_seq OWNER TO postgres;

CREATE SEQUENCE verification_token_gen_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE verification_token_gen_id_seq OWNER TO postgres;

CREATE TABLE verifications_tokens (
    id bigint NOT NULL,
    expirydate timestamp without time zone,
    token character varying(255),
    user_id bigint NOT NULL
);

ALTER TABLE verifications_tokens OWNER TO postgres;

CREATE TABLE workscheduler (
    workscheduler character varying,
    doctorinfo_id bigint,
    id bigint NOT NULL
);

ALTER TABLE workscheduler OWNER TO postgres;

ALTER TABLE ONLY appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (id);

ALTER TABLE ONLY carditem
    ADD CONSTRAINT carditem_pkey PRIMARY KEY (id);

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);

ALTER TABLE ONLY doctorinfo
    ADD CONSTRAINT doctorinfo_pkey PRIMARY KEY (id);

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);

ALTER TABLE ONLY hospital
    ADD CONSTRAINT hospital_pkey PRIMARY KEY (id);

ALTER TABLE ONLY password_reset_tokens
    ADD CONSTRAINT "password_reset_tokensPK" PRIMARY KEY (id);

ALTER TABLE ONLY patientcard
    ADD CONSTRAINT patientcard_pkey PRIMARY KEY (id);

ALTER TABLE ONLY patientinfo
    ADD CONSTRAINT patientinfo_pkey PRIMARY KEY (id);

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);

ALTER TABLE ONLY databasechangeloglock
    ADD CONSTRAINT pk_databasechangeloglock PRIMARY KEY (id);

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);

ALTER TABLE ONLY role_users
    ADD CONSTRAINT role_users_pkey PRIMARY KEY (users_id, role_id);

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);

ALTER TABLE ONLY role
    ADD CONSTRAINT uk_93vn3jeavtylq20tjdx2p2kkd UNIQUE (type);

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT uk_mb4c7ta7x0g5jxjuaqw47ayov UNIQUE (token);

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT uk_rpl2mjerve4d0pcau4usm8lmg UNIQUE (username);

ALTER TABLE ONLY userdetail
    ADD CONSTRAINT userdetail_pkey PRIMARY KEY (id);

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY verifications_tokens
    ADD CONSTRAINT "verifications_tokensPK" PRIMARY KEY (id);

ALTER TABLE ONLY workscheduler
    ADD CONSTRAINT "workschedulerPK" PRIMARY KEY (id);

ALTER TABLE ONLY verifications_tokens
    ADD CONSTRAINT "FK_79hy0bqeu0oobh0thq8bgbae1" FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE ONLY workscheduler
    ADD CONSTRAINT "FK_a5ufm3i0ew6t3nfua44q1mqvw" FOREIGN KEY (doctorinfo_id) REFERENCES doctorinfo(id);

ALTER TABLE ONLY password_reset_tokens
    ADD CONSTRAINT "FK_la2ts67g4oh2sreayswhox1i6" FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE ONLY doctorinfo
    ADD CONSTRAINT fk_1r6dadb3ajbaxwkpdx1v4u9n9 FOREIGN KEY (userdetails_id) REFERENCES userdetail(id);

ALTER TABLE ONLY users
    ADD CONSTRAINT fk_2xe4lqrkwymg4aoshgadolask FOREIGN KEY (userdetails_id) REFERENCES userdetail(id);

ALTER TABLE ONLY role_users
    ADD CONSTRAINT fk_67w5hj99v5nvjexfv0cf1mxus FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fk_7uda74mreyd8pe0bc0rgm1ufe FOREIGN KEY (consumer_id) REFERENCES users(id);

ALTER TABLE ONLY carditem
    ADD CONSTRAINT fk_8hgkscyrlwhgtdgcljai40128 FOREIGN KEY (patientcard_id) REFERENCES patientcard(id);

ALTER TABLE ONLY appointment
    ADD CONSTRAINT fk_b51bk1hxlblc0fq7l65dkcnc5 FOREIGN KEY (userdetail_id) REFERENCES userdetail(id);

ALTER TABLE ONLY role_users
    ADD CONSTRAINT fk_cunrd1kjdr3pwcekkhw8r5k2l FOREIGN KEY (users_id) REFERENCES users(id);

ALTER TABLE ONLY department_doctorinfo
    ADD CONSTRAINT fk_ej88rho1obqsgettqaymg2ax8 FOREIGN KEY (departments_id) REFERENCES department(id);

ALTER TABLE ONLY userdetail
    ADD CONSTRAINT fk_exlldeucxpa91uwds0hpc97o FOREIGN KEY (patientcard_id) REFERENCES patientcard(id);

ALTER TABLE ONLY appointment
    ADD CONSTRAINT fk_hx479pw4gje0ktsjfwvl9pwn8 FOREIGN KEY (doctorinfo_id) REFERENCES doctorinfo(id);

ALTER TABLE ONLY department_doctorinfo
    ADD CONSTRAINT fk_ibochgjqx1dyr7ysbeg0royt9 FOREIGN KEY (doctors_id) REFERENCES doctorinfo(id);

ALTER TABLE ONLY hospital_users
    ADD CONSTRAINT fk_o7prsdub8c63s5w469e06q83 FOREIGN KEY (managers_id) REFERENCES users(id);

ALTER TABLE ONLY carditem
    ADD CONSTRAINT fk_ohvlr9w2h9pvsj2bg12ox9b9 FOREIGN KEY (doctor_id) REFERENCES users(id);

ALTER TABLE ONLY patientcard
    ADD CONSTRAINT fk_ov506nbhqxddqios9pxlb21ie FOREIGN KEY (userdetail_id) REFERENCES userdetail(id);

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fk_pvf13utfatebavsixvqxwo3ob FOREIGN KEY (producer_id) REFERENCES users(id);

ALTER TABLE ONLY department
    ADD CONSTRAINT fk_spotjwwrelb9dhulkiivbl62b FOREIGN KEY (hospital_id) REFERENCES hospital(id);

ALTER TABLE ONLY hospital_users
    ADD CONSTRAINT fk_tcu91xpek54a086jamuakvoh8 FOREIGN KEY (hospital_id) REFERENCES hospital(id);
