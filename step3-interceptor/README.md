## Demonstrates how to engage an interceptor to the microservice

Commands
--------
1.
curl -v http://localhost:8080/stockquote/IBM

2.
curl -v -X POST -H "Content-Type:application/json" -d '{"symbol":"GOOG","name":"Google Inc.", "high":190.23, "low":187.45}' http://localhost:8080/stockquote

