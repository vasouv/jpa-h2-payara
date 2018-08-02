FROM airhacks/glassfish
COPY ./target/jpa.war ${DEPLOYMENT_DIR}
