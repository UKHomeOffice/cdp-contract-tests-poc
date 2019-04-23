Introduction:
========================================

A very basic java-maven POC to establish contract testing between a Consumer(Data Owner) and Provider(CDP) using Pact. 
The project contains a Consumer test which upon success generates a pact json to default location /target/pacts. The json is to be supplied to a provider, in this case placed under /test/resources/pacts to be picked up by provider tests for verification. 

Running the tests:
-----------------

This exercise has 3 steps:

Step 1: Execute the ConsumerPactTest.java test class to successfully generate the pact json, in this case it will be google-client-google-server.json generated under target/pacts directory by default

Step 2: The pact json made available for verification by the provider test by creating a test/resources/pacts directory and placing the json under it.

Step 3: Execute the ProviderPactTest.java test class to trigger a request to google endpoint and verify that the response is matched in this case a 200 is returned.

Future:
-----------------

Note that this is a very basic set up and further work has to be done to automate the contract and verification results exchange for example via a pact broker. We also have to design correct repositories to hold the tests. 


