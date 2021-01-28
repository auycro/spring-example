### MySQL 5.7.17

# Pull image
FROM mysql:8.0.23

# MySQL env
ENV MYSQL_ROOT_PASSWORD=admin
    #MYSQL_USER=foo \
    #MYSQL_PASS=foobar
    #ON_CREATE_DB=**False** \
    #REPLICATION_MASTER=**False** \
    #REPLICATION_SLAVE=**False** \
    #REPLICATION_USER=replica \
    #REPLICATION_PASS=replica

# Add root@% user
# RUN /bin/mysql -uroot -padmin -e "CREATE USER 'root'@'%' IDENTIFIED BY 'admin'"
# RUN /bin/mysql -uroot -padmin -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION"
COPY ./*.sql /docker-entrypoint-initdb.d/