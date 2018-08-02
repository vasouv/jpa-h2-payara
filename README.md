# JPA H2 with Payara

Payara 5 has H2 for embedded database instead of Derby. The connection pool is already set up in the server, so if you deploy an app that links to that connection pool you should be good to go.

## persistence.xml
```
<persistence-unit name="h2PU" transaction-type="JTA">
        <jta-data-source>jdbc/__default</jta-data-source>
        <properties>
            <property name="javax.persistence.schema-generation.database.action" value="drop-and-create" />
        </properties>
    </persistence-unit>
```

## Startup bean
For JAX-RS, the startup bean can be annotated @Startup + @Singleton. For JSF though, the startup bean must be annotated @ApplicationScoped + @Eager (from Omnifaces).
