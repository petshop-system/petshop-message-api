# Petshop Message API

An API to produce messages and working as a fail fast.


![Diagram](./diagramas/petshop-system.drawio.png "Diagram")

## Schedule

To send a message to schedule a service to Petshop System.

### Request a schedule

Example:

* Request:

```
curl -vL --location 'http://localhost:5003/petshop-message-api/schedule/register' \
--header 'Content-Type: application/json' \
--data '{
    "booking": "2024-03-30 00:00:00",
    "pet_id": 1,
    "service_employee_attention_id": 3
}'
```

* Response: 

```
HTTP/1.1 202 
Content-Length: 0
Date: Mon, 15 Jan 2024 17:50:34 GMT
```

