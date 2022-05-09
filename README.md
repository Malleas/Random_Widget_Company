# Random Widget Company CST-451/452 Senior Capstone Project

This was a fork off CST-339 Java 3 using Spring Boot.  There was a few features i wanted to inlcude in this app from the original class that we never got to.  This repo are those changes and additions that i flet needed to be done.  This includes a full shopping cart experience.

[CST-339 original Repo] (https://github.com/Malleas/CST-339_CLC)

# Project Proposal
At Random Widgets, we are all about creating the most random widget for all our customers.  After our initial Kickstarter campaign to gain the capital, we needed to invest further into the company with increased production lines, we have some to a fork in the road that simple word of mouth sales is starting to exceed our phone sales representative’s ability to keep up.  

We are proposing the setup and development of a new product sales web allocation that will allow all our existing users to continue to shop without the need to wait in our ever-growing phone queues.  It will also allow us to market our product more easily to new customer’s.  Overall, the shopping experience should be easy and intuitive to provide the next step in growing our sales.


# Key Highlights

I wanted to show the reusability of core work used for sevral other projects and it's portability into a new project.  

The setup of standard CRUD operations from one class to the next had been done several times at this point and reusing the USER and PRODUCT entities withing the database was complete.  Since we only had a 2 week development cycle on this project, reusing existing code was going to be key to ensure a timely delivery.

Some key features of this project:
1.  RESTful API's for PRODUCT service can be found at localhost:8080/service/getProduct/{id}
2.  MVC used throughout the project.
3.  [Swagger Docs](http://localhost:8080/swagger-ui/index.html)
4.  Using spring security to limit usability.  Requires login to navigate to deeper pages.
5.  Passwords are hashed when creating a new user as well as on login so that no human readable passwords are stored.
6.  Using the spring session object to allow an easy shopping experience.  once user is logged in, they will have the ability to shop and purchse items. 

# Languages & Frameworks

The application back end was completed using JAVA with the Spring Boot framework.
Database used was MySql running on MAMP locally
CSS is supported by many Bootstrap libraries.  [Bootstrap](https://getbootstrap.com/)
