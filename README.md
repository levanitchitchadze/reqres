
# Reddit Test Automation 

It's a mini project for Reqres api automation.


# Installation

**❗ You need to have JDK 21.**

copy url from git repository 

git clone https://github.com/levanitchitchadze/reqres.git

cd reqres 


### Run project
run project with

$: `mvn clean test`


# project layout scheme
```
reqres
├── .idea/
├── .mvn/
├── src/
│   └── test/
│       └── java/
│           └── api/
│               ├── clients/                    //api request logic
│               │   ├── LoginClient.java
│               │   ├── RegisterClient.java
│               │   └── UserClient.java
│               ├── models/                     //POJO models
│               │   └── request/
│               │       ├── Login.java
│               │       ├── Register.java
│               │       ├── UserCreate.java
│               │       └── UserUpdate.java
│               ├── tests/                      //Testng tests
│               │   ├── LoginTest.java
│               │   ├── RegisterTest.java
│               │   └── UsersTest.java
│               └── utils/                      //Widely used tools
│                   ├── ConfigReader.java
│                   └── Endpoints.java
├── .gitignore
├── pom.xml
└── testng.xml

```

## Color Reference

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Example Color | ![#0a192f](https://via.placeholder.com/10/0a192f?text=+) #0a192f |
| Example Color | ![#f8f8f8](https://via.placeholder.com/10/f8f8f8?text=+) #f8f8f8 |
| Example Color | ![#00b48a](https://via.placeholder.com/10/00b48a?text=+) #00b48a |
| Example Color | ![#00d1a0](https://via.placeholder.com/10/00b48a?text=+) #00d1a0 |

