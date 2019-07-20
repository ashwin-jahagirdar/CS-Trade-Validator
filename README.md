# Endpoints
Health Check - GET http://localhost:8282/actuator/health

Shutdown - POST http://localhost:8282/actuator/shutdown

Validate multiple trades - POST http://localhost:8181/validate-trades/

Validate a single trade - POST http://localhost:8181/validate-trade/

# Pending issues
Validate the value date against the product type

Value date cannot fall on weekend or non-working day for currency
