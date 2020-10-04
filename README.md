# LAB-AREP-SECURE-APP

#Introduction

In this repository is a solution to the laboratory 7 of business architectures, we made a secure application in 
all its fronts and ensure both authorization and authentication and accounting, we built a spark service that will be responsible for authenticating the respective users
and in addition I use the model of 12 steps to increase the security of our application, we generate the keystore with this model, the certificates and the truststore that 
were shared between the two services, the login service and sample service.



## Architecture

The architecture was defined in class and we can see an image of it below:

![](https://media.discordapp.net/attachments/425125409621803010/762427803848933406/unknown.png?width=728&height=333)

The two server components are located in 2 different instances of EC2 as shown in the following image:

![](https://media.discordapp.net/attachments/352624122301513730/762429188674158602/unknown.png?width=728&height=127)

For the java components, a docker was used and the containers were run in each of the machines, as can be seen in the following images:

- Login Service

![](https://media.discordapp.net/attachments/352624122301513730/762430070652403772/unknown.png?width=728&height=174)


- Other Service

![](https://media.discordapp.net/attachments/352624122301513730/762430388101971998/unknown.png?width=728&height=172)

For the application to be secure, it was decided to generate their respective certificates to run with https. In addition, users must be authenticated so that they can see the secure content of the page.

In the following images we can see the certificate of the page and also what happens if the user is not authenticated:

![](https://media.discordapp.net/attachments/352624122301513730/762431534426226738/unknown.png?width=728&height=371)

![](https://media.discordapp.net/attachments/352624122301513730/762431949628375101/unknown.png?width=728&height=96)

If a user is authenticated, we can observe that he can correctly access the secure content, in addition we can observe that he connects with the other application through the truststore that was shared between machines so that they know each other.

![](https://media.discordapp.net/attachments/352624122301513730/762432655010562058/unknown.png?width=583&height=473)
![](https://media.discordapp.net/attachments/352624122301513730/762432780859605021/unknown.png)

The other service or example service also has its respective certificate as we can see below:

![](https://media.discordapp.net/attachments/352624122301513730/762433039137112084/unknown.png?width=675&height=473)

Finally, in order to make the user's credentials secure, the sha1 encryption algorithm was used for the password.

![](https://media.discordapp.net/attachments/352624122301513730/762433546567680000/unknown.png?width=728&height=443)

## Run the app

The application is not running at the moment, however a video was made demonstrating the operation and the source code information was saved
in two different repositories

  - Login Service
  
  Continuos Integration
  
  [![CircleCI](https://circleci.com/gh/AlejandroBohal/LabArep-LoginService.svg?style=svg)](https://circleci.com/gh/AlejandroBohal/LabArep-LoginService)
  
  Repository Link
  
  https://github.com/AlejandroBohal/LabArep-LoginService
  
  - Logic Service (example)
  
  Continuos Integration
  
  [![CircleCI](https://circleci.com/gh/AlejandroBohal/Lab7Arep-ExampleService.svg?style=svg)](https://circleci.com/gh/AlejandroBohal/Lab7Arep-ExampleService)
  
  Repository Link
  
  https://github.com/AlejandroBohal/Lab7Arep-ExampleService


## Documentation and testing

Each repository has its own documentation and an access link to it. If you want to generate it, clone the respective repository and execute the following command:

```
  mvn javadoc:javadoc
```

To run the test you need to clone any repository and run the following command:

```
  mvn test
```


## Live demo

You can find a live demo of this project in the following link:

https://www.youtube.com/watch?v=l0TPii592cU







