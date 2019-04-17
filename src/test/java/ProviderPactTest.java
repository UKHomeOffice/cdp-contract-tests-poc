import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeoutException;

/**
 * Provider-side test for consumer-driven contracts defined as pacts. The Pact runner generates tests for
 * each interaction of each defined pact, and runs these tests against the service running at @TestTarget.
 */
@RunWith(PactRunner.class)
@Provider("google-server")
@PactFolder("src/test/resources/pacts")
public class ProviderPactTest {

    @TestTarget
    public static Target target;

    @BeforeClass
    public static void setUp() throws TimeoutException {
        String baseUrl = "http://google.com:80";
        try {
            target = new HttpTarget(new URL(baseUrl));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }
}