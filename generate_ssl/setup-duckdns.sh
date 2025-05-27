#!/bin/sh

mkdir -p /etc/letsencrypt
echo "dns_duckdns_token = ${DUCKDNS_TOKEN}" > /etc/letsencrypt/duckdns.ini
chmod 600 /etc/letsencrypt/duckdns.ini