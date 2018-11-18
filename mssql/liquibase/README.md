# liquibase
Paquete para administrar la base de datos con liquibase

**Ejecutar**

```
Actualizar
 mvn liquibase:update
 mvn liquibase:updateSQL
```

```
Limpiar
mvn liquibase:rollback -Dliquibase.rollbackCount=400
mvn liquibase:rollbackSQL -Dliquibase.rollbackCount=400
```

