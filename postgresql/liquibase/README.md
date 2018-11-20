# Proyecto de ejemplo para postgresql

mvn liquibase:update

mvn liquibase:rollback -Dliquibase.rollbackCount=400

mvn liquibase:rollback -Dliquibase.rollbackTag='initial-database'



