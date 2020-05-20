FROM postgres:latest

COPY entrypoint.sh /docker-entrypoint-initdb.d/
COPY sql/ /tmp/sql

RUN chmod 755 /docker-entrypoint-initdb.d/entrypoint.sh

ENV PGDATA=/var/lib/postgresql/data/pgdata

CMD ["postgres"]