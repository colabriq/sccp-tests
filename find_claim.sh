#!/bin/bash

curl -v \
  -H "Accept: application/xml" \
  -X GET \
  -d "$DATA" \
  "http://localhost:8081/matches?sub=<https://ijmad.me/>&pre=<http://xmlns.com/foaf/0.1/name>"
  