# SpringPagination
This is Demo for spirng boot pagination
Api Requests:

GET : localhost:8080/api/getallbooks

Resp :

[
    {
        "bid": 1,
        "bookName": "JAVA",
        "bookNo": "447GT",
        "auther": "Ramesh"
    },
    {
        "bid": 2,
        "bookName": "SQL",
        "bookNo": "447GTQ",
        "auther": "HIMESH"
    },
    {
        "bid": 3,
        "bookName": "SPRING",
        "bookNo": "447WGT",
        "auther": "MAMA"
    },
    {
        "bid": 4,
        "bookName": "SPRING MVC",
        "bookNo": "E447GT",
        "auther": "MANAS"
    },
    {
        "bid": 5,
        "bookName": "SPRING BOOT",
        "bookNo": "T447GT",
        "auther": "LOKI"
    },
    {
        "bid": 6,
        "bookName": "DS",
        "bookNo": "447GTT",
        "auther": "SIDDHARTHA"
    },
    {
        "bid": 7,
        "bookName": "ALGO",
        "bookNo": "447GYT",
        "auther": "UDAY"
    },
    {
        "bid": 8,
        "bookName": "PYTHON",
        "bookNo": "447HGT",
        "auther": "KRISHNA"
    },
    {
        "bid": 9,
        "bookName": "JAVASCRIPT",
        "bookNo": "J447GT",
        "auther": "LOKA"
    }
]


2: GET : localhost:8080/api/getbook?page=3

Resp :


    "totalItems": 5,
    "resp": [
        {
            "bid": 7,
            "bookName": "ALGO",
            "bookNo": "447GYT",
            "auther": "UDAY"
        },
        {
            "bid": 8,
            "bookName": "PYTHON",
            "bookNo": "447HGT",
            "auther": "KRISHNA"
        }
    ],
    "currentPage": 3
}
