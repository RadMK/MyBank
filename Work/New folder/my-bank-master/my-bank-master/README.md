BUild RESTful API for doing transfers between accounts.
## Requirements
1. Java - 1.8.x
2. Maven - 3.x.x

## Setup
**Build and run the app using maven**

```mvn spring-boot:run
```

The app will start running at <http://localhost:8082>.

## Explore Rest APIs

The app defines following APIs.

    POST /accounts/makeTransfer
    
##Test cases included in test class.

You can test using postman or any other rest client.

##Sample Request
http://localhost:8082/accounts/makeTransfer/
{
"fromAccountNumber" : 2347,
"toAccountNumber" : 1236,
"amount" :200
}

