package no.cantara.domainexample.commands;

import no.cantara.base.commands.http.BaseHystrixHttpCommand;
import no.cantara.domainexample.DomainExampleConfiguration;

public abstract class DomainExampleBaseCommand<Result> extends BaseHystrixHttpCommand<Result> {
    protected DomainExampleConfiguration configuration;
    protected boolean fallback=false;

    public DomainExampleBaseCommand() {
        super("DomainExampleBaseCommand", 2500);
    }

    public DomainExampleBaseCommand withConfiguration(DomainExampleConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public DomainExampleBaseCommand<Result> withFallback(boolean fallback) {
        this.fallback=fallback;
        return this;
    }
}
