# spring-docker


<p>#create mysql</p>

docker volume create mysql_data
docker volume create mysql_config

docker network create mysqlnet

docker run --rm -d \
-v mysql_data:/var/lib/mysql \
-v mysql_config:/etc/mysql/conf.d \
--network mysqlnet \
--name mysqlserver \
-e MYSQL_USER=petclinic -e MYSQL_PASSWORD=petclinic \
-e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=petclinic \
-p 3306:3306 mysql:8.0a

<p>#spring</p>
docker build -t spring-docker:v0.1.3 .

docker run --rm \                     
--name springboot-server \
--network mysqlnet \
-e MYSQL_URL=jdbc:mysql://mysqlserver/petclinic \
-e MYSQL_ROOT_PASSWORD=root -p 8080:8080 spring-docker:v0.1.1


##

  docker run --rm -d \
--name springboot-server \
--network mysqlnet \
-e MYSQL_URL=jdbc:mysql://mysqlserver/crm \
-e MYSQL_ROOT_PASSWORD=root \
-p 8080:8080 spring-docker:v0.0.4


docker-compose -f docker-compose.dev.yml up --build
