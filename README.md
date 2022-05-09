# Random Widget Company CST-451/452 Senior Capstone Project

This was a fork off CST-339 Java 3 using Spring Boot.  There was a few features i wanted to inlcude in this app from the original class that we never got to.  This repo are those changes and additions that i flet needed to be done.  This includes a full shopping cart experience.

[CST-339 original Repo] (https://github.com/Malleas/CST-339_CLC)

# How to run / install
There are some prerequisites to running this application locally, listed below:
1.  Ensure you have MAMP (or whatever AMP version works on your OS) installed and running.
2.  Clone the project.  When cloned, do a maven clean & install.  If using Intellij, right click on the project root and click on maven->reload project.
## Database setup
1.  Locate the finalDDL.sql and execute to setup tables.
2.  Locate the role.sql and execute to populate roles table.  NOTE:  You can not create a new user without the roles table having data in it.
3.  Use the Products_Mockt_Data.csv and import this data into your PRODUCTS table to preload data.

## Running the application
From here it's as easy as going to localhost:8080 in your browser.  You will need to create a user first to navigate past login/registration pages.

# Project Proposal
At Random Widgets, we are all about creating the most random widget for all our customers.  After our initial Kickstarter campaign to gain the capital, we needed to invest further into the company with increased production lines, we have some to a fork in the road that simple word of mouth sales is starting to exceed our phone sales representative’s ability to keep up.  

We are proposing the setup and development of a new product sales web allocation that will allow all our existing users to continue to shop without the need to wait in our ever-growing phone queues.  It will also allow us to market our product more easily to new customer’s.  Overall, the shopping experience should be easy and intuitive to provide the next step in growing our sales.


# Key Highlights

I wanted to show the reusability of core work used for sevral other projects and it's portability into a new project.  

The setup of standard CRUD operations from one class to the next had been done several times at this point and reusing the USER and PRODUCT entities withing the database was complete.  Since we only had a 2 week development cycle on this project, reusing existing code was going to be key to ensure a timely delivery.

Some key features of this project:
1.  RESTful API's for PRODUCT service can be found at localhost:8080/service/getProduct/{id}
2.  MVC used throughout the project.
3.  Swagger Docs http://localhost:8080/swagger-ui/index.html)
4.  Using spring security to limit usability.  Requires login to navigate to deeper pages.
5.  Passwords are hashed when creating a new user as well as on login so that no human readable passwords are stored.
6.  Using the spring session object to allow an easy shopping experience.  once user is logged in, they will have the ability to shop and purchse items. 

# Languages & Frameworks

The application back end was completed using JAVA with the Spring Boot framework.
Database used was MySql running on MAMP locally
CSS is supported by many Bootstrap libraries.  [Bootstrap](https://getbootstrap.com/)

# Design Documentation
## Sitemap
![CST-339_SiteMap](https://user-images.githubusercontent.com/40237581/167412222-f2e7ec26-080e-45ba-a670-bc531bf55718.png)
## Logical System Diagram
![Logical System Diagram drawio](https://user-images.githubusercontent.com/40237581/167412370-327835f0-7295-4167-bd11-a0cedeee3e66.png)
## Shopping Cart Logic Flow Diagram
![shopping cart logic flow drawio](https://user-images.githubusercontent.com/40237581/167412476-58c364a5-7bd8-41d6-bb48-815f198b6b9e.png)


