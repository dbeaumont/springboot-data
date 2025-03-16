#!/bin/bash

docker exec -t $(docker ps -q -f name=database) pg_dump -U admin appdb > backup.sql


