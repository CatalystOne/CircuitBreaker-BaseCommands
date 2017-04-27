package no.cantara.domainexample.commands;

import com.github.kevinsawicki.http.HttpRequest;
import no.cantara.base.commands.http.HttpResponse;
import no.cantara.domainexample.DomainExampleConfiguration;
import no.cantara.domainexample.tests.MyDomainContract;
import no.cantara.domainexample.tests.MyDomainObject;

import java.net.MalformedURLException;
import java.util.UUID;

public class GetSomethingFromDomainExampleCommand extends DomainExampleBaseCommand<MyDomainContract> {
    private UUID firstParameter;
    private UUID secondparameter;


    public GetSomethingFromDomainExampleCommand withFallback(boolean fallback) {
        return (GetSomethingFromDomainExampleCommand) super.withFallback(fallback);
    }

    public GetSomethingFromDomainExampleCommand withConfiguration(DomainExampleConfiguration configuration) {
        return (GetSomethingFromDomainExampleCommand) super.withConfiguration(configuration);
    }

    public GetSomethingFromDomainExampleCommand withPatientId(UUID patientId) {
        this.firstParameter = patientId;
        return this;
    }

    public GetSomethingFromDomainExampleCommand withPrescriptionId(UUID prescriptionId) {
        this.secondparameter = prescriptionId;
        return this;
    }

    @Override
    protected HttpRequest getRequest() throws MalformedURLException {
        return null;
    }

    @Override
    protected MyDomainContract dealWithResponse(HttpResponse response) {
        return new MyDomainContract(firstParameter, populateMyDomainObject());
    }

    @Override
    protected MyDomainContract getFallback(){
        if (fallback){
            return new MyDomainContract(firstParameter, populateMyDomainObject());
        }
        return null;
    }

    private MyDomainObject populateMyDomainObject() {
        return new MyDomainObject();
    }
}
