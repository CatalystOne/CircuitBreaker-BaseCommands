package no.cantara.base.command.soap;

import com.github.kevinsawicki.http.HttpRequest;
import no.cantara.base.command.BaseHttpPostHystrixCommand;

import java.net.URI;

/**
 * Add utillity methods for handling SOAP requests.
 * Created by baardl on 2017-03-29.
 */
public abstract class BaseSoapPostHystrixCommand extends BaseHttpPostHystrixCommand {

    private final String headerXml;
    private final String bodyXml;

    public BaseSoapPostHystrixCommand(URI serviceUri, String hystrixGroupKey, String headerXml, String bodyXml) {
        super(serviceUri, hystrixGroupKey);
        this.headerXml = headerXml;
        this.bodyXml = bodyXml;
    }

    @Override
    protected HttpRequest dealWithRequestBeforeSend(HttpRequest request) {
        super.dealWithRequestBeforeSend(request);
//        request.getConnection().addRequestProperty("SOAPAction", SOAP_ACTION);
        String query = buildSoapXml();
        request.contentType("text/xml;charset=UTF-8").send(query);
        return request;
    }

    protected abstract String buildSoapXml();

}
