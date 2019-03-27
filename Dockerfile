FROM payara/server-full
ENV JVM_ARGS="-Ddeployment.resource.validation=false" 
COPY /venda/target/shop-venda.war $DEPLOY_DIR
