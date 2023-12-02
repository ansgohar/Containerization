FROM postgres:16.1 as dumper

COPY users-DDL.sql /docker-entrypoint-initdb.d/

RUN ["sed", "-i", "s/exec \"$@\"/echo \"skipping...\"/", "/usr/local/bin/docker-entrypoint.sh"]

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV PGDATA=/data

RUN ["/usr/local/bin/docker-entrypoint.sh", "postgres"]

# final build stage
FROM postgres:16.1

COPY --from=dumper /data $PGDATA

# Comment
#RUN echo 'we are running Customized PostgreSQL container!'

