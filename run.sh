docker build -t java/database ./database
docker run -p 5433:5432 -d --name database java/database
cd cartao
mvn clean package
docker build -t java/cartao .
cd ..
cd venda
mvn clean package
cd ..
docker build -t java/app .
docker run -p 8082:8080 -d --name cartao --link database:host-banco java/cartao
docker run -p 4848:4848 -p 8081:8080 --name app --link cartao:host-cartao --link database:host-banco java/app