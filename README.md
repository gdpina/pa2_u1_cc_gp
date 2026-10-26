
# Simulador de Descuentos con Quarkus

## Preguntas de análisis

### 1. ¿Dónde se aplica IoC y dónde se aplica DI?

La Inversión de Control (IoC) se aplica cuando Quarkus, mediante CDI y ArC, administra la creación y el ciclo de vida de los componentes del sistema.

La Inyección de Dependencias (DI) se aplica cuando Quarkus proporciona automáticamente los objetos que necesitan las clases. En `VentaService` se utiliza inyección por constructor para `DescuentoRegular` e inyección por atributo para `DescuentoVIP` y `Instance<Auditoria>`. En `Main` también se inyecta `VentaService`.

### 2. ¿Qué son los Qualifiers y por qué son necesarios?

Los Qualifiers permiten distinguir entre diferentes implementaciones de una misma interfaz.

En este proyecto se utiliza `@Named("regular")` para identificar `DescuentoRegular` y `@Named("vip")` para identificar `DescuentoVIP`. Son necesarios porque ambas clases implementan la interfaz `CalculadoraDescuento`, pero aplican porcentajes diferentes.

### 3. ¿Cuál es la diferencia entre @ApplicationScoped y @Dependent?

`@ApplicationScoped` permite que CDI reutilice una instancia administrada durante la vida de la aplicación. En este proyecto se utiliza en `VentaService`, `DescuentoRegular` y `DescuentoVIP`.

`@Dependent` hace que el ciclo de vida del objeto dependa del componente que lo solicita o administra. En este proyecto, `Auditoria` utiliza este alcance para crear una instancia por cada venta mediante `Instance<Auditoria>` y destruirla después de registrar la operación.

### 4. ¿Por qué las instancias @ApplicationScoped se reutilizan entre ventas?

Porque CDI mantiene una instancia administrada por aplicación para cada componente con alcance `@ApplicationScoped`. Por eso, al procesar varias ventas, se reutilizan los mismos componentes en lugar de crear una instancia nueva para cada operación.

Los UUID generados en `DescuentoRegular` y `DescuentoVIP` permiten observar sus identificadores y comprobar que las instancias se reutilizan durante la ejecución.

### 5. ¿Qué ocurre si se elimina el Qualifier del punto de inyección de CalculadoraDescuento?

Si se elimina el Qualifier de un punto de inyección donde ambas implementaciones están disponibles, CDI puede encontrar más de un componente que satisface la dependencia.

En este proyecto, si se elimina `@Named("REGULAR")` del constructor de `VentaService`, las implementaciones `DescuentoRegular` y `DescuentoVIP` pueden coincidir con el punto de inyección. Esto provoca una dependencia ambigua y puede impedir que Quarkus inicie correctamente la aplicación.

Por eso, los Qualifiers permiten seleccionar explícitamente la implementación correcta.

