# SpringBoot-Crud-Mongo
SpringBoot-Crud-Mongo

Add Book Api curl:
```
curl --location --request POST 'localhost:9000/bookstore/addbook' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookId": 2367,
    "bookName": "Python Masterclass on Data Science",
    "authorName": "R. K. Desai"
}'
```

Get All Books Api curl:
```
curl --location --request GET 'localhost:9000/bookstore/findallbooks'
```

Get Book by id Api curl:
Here 2367 is Book id.
```
curl --location --request GET 'localhost:9000/bookstore/findallbooks/2367'
```

Update Book by id Api curl:
Here 2367 is Book id.
```
curl --location --request PUT 'localhost:9000/bookstore/updatebook/2367' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookId": 2367,
    "bookName": "Python Masterclass on Data Science 001",
    "authorName": "R. K. Desai"
}'
```

Delete Book by id Api curl:
Here 2367 is Book id.
```
curl --location --request DELETE 'localhost:9000/bookstore/deletebook/2367'
```
