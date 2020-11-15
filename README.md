# walmartapi
API  for Walmart challenge

This development was created using spring boot + swagger to provide services that allow to search products by id, brand and description and apply 50% discount is the seach phrase is a palindrome.

### Installation

To initialiaze and run the container:

```sh/swagger-ui/index.html
$ make walmartapi-init
```

To run the containter (if it has been previously initialized)

```sh
$ make walmartapi-start
```

To stop the container:

```sh
$ make walmartapi-stop
```

### Tests


For tests run this command:

```sh
$ make walmartapi-run-test
```

### Swagger UI

If you want to make tests or see the API documents, go to the following URL:

http://localhost:8081/swagger-ui/index.html
