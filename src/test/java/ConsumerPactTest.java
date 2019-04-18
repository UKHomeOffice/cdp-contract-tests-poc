import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Rule;
import org.junit.Test;
/**
 * Defines the pact between us and the profile-manager service.
 */
public class ConsumerPactTest {

    private static final String PROVIDER = "google-server";
    private static final String CONSUMER = "google-client";
    private static final String IMAGE_ENDPOINT = "/imghp";
    /**
     * The mock provider we will use to verify our pact.
     */
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2(PROVIDER, this);

    /**
     * Builds a pact between us and the provider, defining our expectations from our interactions with the provider.
     *
     * @param builder pact builder
     * @return a new pact
     */
    @Pact(provider = PROVIDER, consumer = CONSUMER)
    public RequestResponsePact createPactWithProfileManager(PactDslWithProvider builder) {
        return builder
                .uponReceiving("a google search request")
                .method("GET")
                .path(IMAGE_ENDPOINT)
                .willRespondWith()
                .status(HttpStatus.SC_OK)
                .toPact();
    }


    /**
     * Verifies that we have defined our pact correctly and creates a pact file.
     * <p>
     * Requires that we exercise each of the interactions defined by the pact builder: we do this by firing REST calls
     * at the mock provider.
     * <p>
     * On successful completion,writes a pact JSON file (default location is target/pacts). We then supply this pact
     * file to the provider project, for input to its provider-side tests.
     */
    @Test
    @PactVerification(PROVIDER)
    public void verifyPactWithProfileManager() {
        RestAssured
                .when()
                .get(provider.getUrl() + IMAGE_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}