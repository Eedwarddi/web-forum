# web-forum

## Requirements

- MySQL 8.0.13

To run this application you need to create a file with your database information. Create a file named persistence-mysql.properties in src/main/resources

Template for persistence-mysql.properties:

```
#
# JDBC connection properties
#
# Your MySQL url. Example: jdbc.url=jdbc:mysql://localhost:3306/forumdb
jdbc.url=

# Your MySQL user. Example: jdbc.user=username
jdbc.user=

#Your MySQL password. Example: jdbc.password=password123
jdbc.password=


```
Insert your mysql url, username, and password.

## Endpoints

**GET categories**

Endpoint: `/categories`

Example URL: `http://localhost:8080/web-forum/api/categories`

Server returns:

```json
[
    {
        "id": 1,
        "title": "Movies"
    },
    {
        "id": 2,
        "title": "Music"
    },
    {
        "id": 3,
        "title": "Video Games"
    }
]
```

**POST thread**

Endpoint: `/threads`

Example URL: `http://localhost:8080/web-forum/api/threads`

Example body of the call:

```json
{
	"title" : "This a title for a thread",
	"content" : "Content of the thread",
	"category" : {
	    "id": 3
    }
}
```

Server returns:

```json
{
    "id": 68,
    "title": "This a title for a thread",
    "content": "Content of the thread",
    "category": {
        "id": 3,
        "title": "Video Games"
    }
}
```

**GET threads by category**

Endpoint: `/categories/{categoryId}/threads`

Example URL: http://localhost:8080/web-forum/api/categories/2/threads

Server returns:
```json
[
    {
        "id": 22,
        "title": "Title for a thread belonging in category 2",
        "content": "Content of the thread",
        "category": {
            "id": 2,
            "title": "Music"
        }
    },
    {
        "id": 23,
        "title": "Another title for a thread belonging in category 2",
        "content": "Content of the thread",
        "category": {
            "id": 2,
            "title": "Music"
        }
    }
]
```

**POST reply**

Endpoint: `/replies`

Example URL: `http://localhost:8080/web-forum/api/replies`

Example body of the call:

```json
{
	"comment" : "A comment for a thread",
	"thread" : {
	    "id": 67
	}
}
```

Server returns:

```json
{
    "id": 4,
    "comment": "A comment for a thread",
    "thread": {
        "id": 67,
        "title": "Title for a thread",
        "content": "Content of the thread",
        "category": {
            "id": 3,
            "title": "Video Games"
        }
    }
}
```
