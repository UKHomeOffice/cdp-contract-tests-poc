A very basic java POC to establish contract testing between a Consumer(Data Owner) and Provider(CDP) using Pact. 
The project contains a Consumer test which upon success generates a pact json to default location /target/pacts. The json is to be supplied to a provider, in this case placed under /test/resources/pacts to be picked up by provider tests for verification. 

Further work has to be done to automate the contract and verification results exchange for example via a pact broker.
