CREATE TABLE cached_employee
(
    employee_id SERIAL                   NOT NULL,
    name        VARCHAR(20)              NOT NULL,
    surname     VARCHAR(20)              NOT NULL,
    salary      NUMERIC(20)              NOT NULL,
    since       TIMESTAMP with time zone NOT NULL,
    PRIMARY KEY (employee_id)
);