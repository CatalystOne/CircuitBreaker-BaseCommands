package no.cantara.domainexample.commands.sql;

public class SqlUpdateCommand extends SqlNamedParameterCommand<SqlUpdateCommand, Integer> {

    @Override
    protected Integer executeQuery() {
        return jdbcTemplate.update(sql, parameters);
    }
}
