# Endpoints
Health Check - GET http://localhost:8282/actuator/health

Shutdown - POST http://localhost:8282/actuator/shutdown

Validate Trades - POST http://localhost:8181/validate-trades/

Note - This service expects a list of trades to be validated. Use JSON array notation even for a single trade. 

# Pending issues
Validate the value date against the product type

Value date cannot fall on weekend or non-working day for currency
