FROM certbot/certbot

VOLUME ["/etc/letsencrypt", "/var/lib/letsencrypt", "/var/www/html"]

COPY setup-duckdns.sh /setup-duckdns.sh

RUN pip install --upgrade pip && \
    pip install certbot-dns-duckdns && \
    chmod +x /setup-duckdns.sh

ENTRYPOINT ["/bin/sh", "-c", "\
    /setup-duckdns.sh && \
    certbot certonly \
    --agree-tos \
    --no-eff-email \
    --email lucy.poplawska@student.kdg.be \
    --non-interactive \
    --authenticator dns-duckdns \
    --dns-duckdns-credentials /etc/letsencrypt/duckdns.ini \
    --dns-duckdns-propagation-seconds 120 \
    -d poplawska-lucy.duckdns.org"]