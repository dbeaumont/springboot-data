#!/bin/bash

docker exec -t $(docker ps -q -f name=database) psql -U admin -d appdb -c "SELECT * FROM data"

