
# Setting up a MongoDB container
sudo docker search mongodb

# we need to create a directory called “mongodb” to hold the docker-compose file

tree mongodb

sudo docker-compose up -d





docker run -d -p 27017:27017 --name test-mongo mongo:latest




