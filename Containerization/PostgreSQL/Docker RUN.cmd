
# Run new container with the deafult PostgreSQL image
docker container run -d --rm -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres --name users_db postgres:latest




# build custom image
docker image build . -t preloaded_users_db:16.1_v1

# start a container with the generated image
docker container run -d --rm -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres --name preloaded_users_db preloaded_users_db:16.1_v1

we can see in our database that the database was created. (password is postgres)
psql -h localhost -U postgres

docker container logs preloaded_users_db