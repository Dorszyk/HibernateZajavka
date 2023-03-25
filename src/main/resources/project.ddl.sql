CREATE TABLE project(

    project_id SERIAL NOT NULL,
    name VARCHAR(64) NOT NULL,
    description TEXT NOT NULL,
    deadline TIMESTAMP with time zone NOT NULL,
    PRIMARY KEY (project_id),
    UNIQUE (name)
);