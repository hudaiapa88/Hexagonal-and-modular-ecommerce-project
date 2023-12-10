#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "postgres" --dbname "order_db" <<-EOSQL

    CREATE DATABASE order_db;
    GRANT ALL PRIVILEGES ON DATABASE order_db TO docker;

EOSQL