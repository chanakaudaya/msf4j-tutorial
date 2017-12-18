## Demonstrates how to enable metrics

This example requires WSO2 Data Analytics Server (DAS) to be setup for HTTP monitoring. Follow the steps mentioned below.

### Download WSO2 DAS

Download WSO2 DAS and unpack it to some directory. This will be the DAS_HOME directory.

### Configure DAS

Run "das-setup/setup.sh" to setup DAS. Note that the DAS Home directory in the above step has to be provided as an input to that script.

The setup script will also copy the already built MSF4J HTTP Monitoring Carbon App (CAPP) to DAS.

### Start DAS

From DAS_HOME, run, bin/wso2server.sh to start DAS and make sure that it starts properly.

### Execute following Commands

1. curl -v http://localhost:8080/stockquote/IBM

2. curl -v -X POST -H "Content-Type:application/json" -d '{"symbol":"GOOG","name":"Google Inc.", "high":190.23, "low":187.45}' http://localhost:8080/stockquote

### Access the HTTP Monitoring dashboard
Go to [dashboard](http://localhost:9763/monitoring/). If everything works fine, you should see the metrics & information related to your microservices on this dashboard. Please allow a few minutes for the dashboard to be updated because the dashboard update batch task runs every few minutes.