#!/bin/bash

./stop.sh
docker-compose build frontend
./start.sh

