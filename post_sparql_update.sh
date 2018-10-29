#!/bin/bash

read -r -d '' DATA <<'EOF'

INSERT DATA { 
  <https://ijmad.me/>  foaf:name 'Ian Maddison' .
  <https://ijmad.me/>  foaf:age 35
}

EOF

echo $VAR

curl -v \
  -H "Accept: application/xml" \
  -H "Content-Type: application/sparql-update" \
  -X POST \
  -d "$DATA" \
  "http://localhost:8080/sparql"
  