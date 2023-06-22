@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
          .driverClassName("org.mariadb.jdbc.Driver")
          .url("jdbc:mariadb://localhost:3306/todobdd?createDatabaseIfNotExist=true")
          .username("root")
          .password("fms2023")
          .build();	
    }
}