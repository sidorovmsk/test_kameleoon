# test_kameleoon

This project serves as the implementation of the back-end trial task provided in
the [Kameleoon Developers Portal](https://developers.kameleoon.com/private/back-end-trial-task/). The task involves
creating a back-end API with specific functionalities related to user accounts and quotes.

## Running the Project with Docker Compose

1. Make sure you have Docker and Docker Compose installed.

2. Open a terminal and navigate to the root directory of the project.

3. Create and start the containers using Docker Compose:

   ```bash
   docker-compose up -d

## API Operations

**Create User Account**

- **Endpoint:** `/api/users`
- **Method:** `POST`
- **Parameters:**
    - **Name:** User's full name.
    - **Email:** User's email address.
    - **Password:** User's chosen password.
    - **Date of Creation:** The date when the user account is created.

```json
{
  "name": "John Doe 2",
  "email": "john.doe@example.com",
  "password": "securePassword",
  "dateOfCreation": "2023-12-07T18:30:00"
}
```

**View User Information**

- Endpoint: `/users/{user_id}`
- Method: `GET`
- Returns information about a specific user.

**View Top 10 Quotes**

- Endpoint: `/quotes/top10`
- Method: `GET`

**View Worst 10 Quotes**

- Endpoint: `/quotes/worst10`
- Method: `GET`

**View Specific Quote**

- Endpoint: `http://localhost:8080/quotes/100`
- Method: `GET`

**Modify Specific Quote**

- Endpoint: `http://localhost:8080/quotes/100`
- Method: `PUT`
- Request Body:

```json
{
  "content": "New text"
}
```

**Upvote Quote**

- Endpoint: `/api/quotes/100/upvote`
- Method: `GET`

**Downvote Quote**

- Endpoint: `/api/quotes/100/downvote`
- Method: `GET`

**Get Random Quote**

- Endpoint: `/api/quotes/random`
- Method: `GET`

**Delete Quote**

- Endpoint: `/api/quotes/1`
- Method: `DELETE`

