
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
    complaint character varying(255) NOT NULL,
    date timestamp without time zone,
    prescription character varying(255) NOT NULL,
    result character varying(255) NOT NULL,
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

CREATE TABLE databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);

ALTER TABLE databasechangeloglock OWNER TO postgres;

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

CREATE TABLE users(
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

CREATE TABLE workscheduler (
    doctor_id bigint,
    workscheduler character varying
);


ALTER TABLE workscheduler OWNER TO postgres;

CREATE TABLE verifications_tokens (
    id bigint NOT NULL,
    expirydate timestamp without time zone,
    token character varying(255),
    user_id bigint NOT NULL
);

ALTER TABLE verifications_tokens OWNER TO postgres;
