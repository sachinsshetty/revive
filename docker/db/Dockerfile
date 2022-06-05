FROM postgres:alpine3.15

ENV POSTGRES_USER revive_db
ENV POSTGRES_PASSWORD revive_db
ENV POSTGRES_DB revive_db

COPY postgresql_schema.sql /docker-entrypoint-initdb.d/
