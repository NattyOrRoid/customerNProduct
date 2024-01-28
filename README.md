# Manage Customer & Product
This project is for managing customer & product (book)

# Module
## Customer Endpoint
The API provides the following endpoints to manage customers, before integrate need to include (/custAPI) before:
- `/customerRegistration`
  -  Method: `POST`
    - Request Body: `{First_Name, Last_Name, Email (Office, Personal), Family Members.}`
    - Explanation: This endpoint is used to register new customer . It will return a response with the status of the request if successful. If the customer already exist, exception will be thrown.

- `/customer`
  -  Method: `GET`
    - Request Body: `{}`
    - Explanation: This endpoint is used to retrieve customers data. It will return a response with the status of the request and the list of customers. If there's no customer exist, exception will be thrown.

- `/customer/{id}`
  - There's 3 Mapping will be used in this endpoint
    -  Method: `GET`
    - Request Body: `{id}`
    - Explanation: This endpoint is used to retrieve one customer data based on id. It will return a response with the status of the request and customer info. If there's no customer exist, exception will be thrown.

    -  Method: `PUT`
    - Request Body: `{id}`
    - Explanation: This endpoint is used to update customer data based on id. It will return a response with the status of the request and customer info. If there's no customer exist, exception will be thrown.

    -  Method: `DELETE`
    - Request Body: `{id}`
    - Explanation: This endpoint is used to delete customer data based on id. It will return a response with the status of the request. If customer can't be found, exception will be thrown.

## Product Endpoint
The API provides the following endpoints to manage books, before integrate need to include (/prodAPI) before:
- `/bookRegistration`
  -  Method: `POST`
    - Request Body: `{Book_Title, Book_Price, Author, Book_Quantity.}`
    - Explanation: This endpoint is used to register new book . It will return a response with the status of the request if successful. If the book with the same author already exist, exception will be thrown.

- `/books`
  -  Method: `GET`
    - Request Body: `{}`
    - Explanation: This endpoint is used to retrieve books data. It will return a response with the status of the request and the list of books. If there's no book exist, exception will be thrown.

- `/book/{id}`
- There's 3 Mapping will be used in this endpoint
    -  Method: `GET`
    - Request Body: `{id}`
    - Explanation: This endpoint is used to retrieve one book data based on id. It will return a response with the status of the request and book info. If there's no book exist, exception will be thrown.

    -  Method: `PUT`
    - Request Body: `{id}`
    - Explanation: This endpoint is used to update book data based on id. It will return a response with the status of the request and book info. If there's no customer exist, exception will be thrown.

    -  Method: `DELETE`
    - Request Body: `{id}`
    - Explanation: This endpoint is used to delete book data based on id. It will return a response with the status of the request. If book can't be found, exception will be thrown.