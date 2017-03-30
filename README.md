# Hystrix-BaseCommands

Base Commands to be extended for your use for HTTP, REST and SOAP over Hystrix


## Example code

```java

/**
* A simple example Command extending BaseHttpGetHystrixCommand
*/
public class CommandGetOauth2ProtectedPing extends BaseHttpGetHystrixCommand<String> {

    String uri;

    public CommandGetOauth2ProtectedPing(String uri) {

        super(URI.create(uri), "oauth-ping-group");
        this.uri = uri;
    }


    @Override
    protected HttpRequest dealWithRequestBeforeSend(HttpRequest request) {
        return request.authorization("Bearer " + OAUth2Value.getMyOauth2Token());
    }

    @Override
    protected String getTargetPath() {
        return "/ping";
    }
}
```


## Binaries

Binaries and dependency information for Maven, Ivy, Gradle and others can be found at [http://mvnrepo.cantara.no](http://mvnrepo.cantara.no/index.html#nexus-search;classname~Whydah).

Example for Maven:

```xml
<dependency>
      <groupId>no.cantara.base</groupId>
      <artifactId>Hystrix-BaseCommands</artifactId>
      <version>0.1.2</version>
</dependency>
```