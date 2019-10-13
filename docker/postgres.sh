#!/usr/bin/env bash
sudo docker run --name stratman-pg \
    -p 5435:5432 \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -e POSTGRES_DB=stratman \
    --restart=always \
    -d postgres:11-alpine
