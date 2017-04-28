package no.cantara.domainexample;


import no.cantara.base.util.Property;

import java.net.URI;

public interface DomainExampleConfiguration {
    @Property(key = "domainexample.uri")
    URI getDomainExampleServerUri();

    @Property(key = "domainexample.username")
    String getUsername();

    @Property(key = "domainexample.password")
    String getPassword();

}
