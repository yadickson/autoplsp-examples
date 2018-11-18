# schema AUTOPLSP

### Ejecution

**Update:**

    mvn liquibase:update

    mvn liquibase:updateSQL

**Rollback**

    mvn liquibase:rollback -Dliquibase.rollbackTag=TAG

    mvn liquibase:rollbackSQL -Dliquibase.rollbackTag=TAG
