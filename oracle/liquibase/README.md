# Create user on database


```sql
CREATE TABLESPACE AUTOPLSP DATAFILE '/opt/oracle/oradata/ORCLCDB/AUTOPLSP.dbf' SIZE 2096M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
```

```sql
CREATE TEMPORARY TABLESPACE AUTOPLSP_TMP TEMPFILE '/opt/oracle/oradata/ORCLCDB/AUTOPLSP_TMP.dbf'  SIZE 2096M REUSE EXTENT MANAGEMENT LOCAL UNIFORM SIZE 100M;
```

```
-- Only on oracle12c
alter session set "_ORACLE_SCRIPT"=true; 
```

```sql
CREATE USER AUTOPLSP IDENTIFIED BY  "AUTOPLSP.." DEFAULT TABLESPACE AUTOPLSP QUOTA 2048M ON AUTOPLSP TEMPORARY TABLESPACE AUTOPLSP_TMP QUOTA 2048M ON system;
```

```sql
GRANT connect , resource, CREATE PROCEDURE, CREATE TYPE, CREATE VIEW, CREATE TABLE, CREATE SEQUENCE to AUTOPLSP;
```

# schema AUTOPLSP

### Ejecution

**Update:**

```script
$ mvn liquibase:update
```
```script
$ mvn liquibase:updateSQL
```

**Rollback**

```script
$ mvn liquibase:rollback -Dliquibase.rollbackTag=TAG
```
```script
$ mvn liquibase:rollbackSQL -Dliquibase.rollbackTag=TAG
```
