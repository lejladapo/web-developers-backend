# Web developers
This project was created for the Software Engineering course. The main goal of the project was to create a platform to connect developers and people that wanted to create a website for their business. With this website, clients are able to post a project (work opportunity) and developers can choose to deliver that project.

## Technologies
JDK 17

## Necessary installation
1. A development environment (Intellij)
2. GitBash
3. Postman
4. pgAdmin4
5. Heroku CLI

For Intellij, go to the JetBrains website and create an account. Then, download the program based on your operating system.
For GitBash, simply go to the website Git-scm and download the program based on your operating system.
Download Postman and pgAdmin4 based on your operating system. When it comes to the pgAdmin4, it is important to note that you have to put the port to `5432` when installing it. In addition, it will ask you type password twice and it is important that you type the same password. The password should be the same for all members of the team. For this project, it is `admin`.
Download Heroku CLI based on your operating system and you will use it to push new code to the Heroku site.

## Framework and dependencies
Spring

The project was created by going to the `https://start.spring.io/` and selecting Lombok and Spring Web as dependencies.

## Dependencies
1. Lombok
2. Spring Web
3. Persistence
4. PostgreSQL
5. Testing
6. JWT

Lombok and SpringWeb were already added when we created the project. When it comes to the all other dependencies, we will add them in `pom.xml` file and then resolve Maven by going to the left bottom corner and hovering on the icon of two windows. Then, you should click on Maven and click on `refresh`.

## Environment variables
The project has environment variables to have better security since it is hosted on Heroku. If we did not have them, everybody would be able to know the username and password of our database. It allows us to have personalized configurations, but it also makes it easy to deploy our projects without having to store sensitive values in our codebase. They can be found in the `application.yml` file.
1. `APP_DB_URL`
2. `APP_DB_PORT`
3. `APP_DB_NAME`
4. `APP_USERNAME`
5. `APP_PASSWORD`

These variables are set for Heroku and the following ones are used locally.

1. `localhost`
2. `5432`
3. `web_developers_db`
4. `postgres`
5. `admin`

## Launch
Go to the GitBash and go to the folder where you want to place the project. Once you are in the folder, type `git clone https://github.com/lejladapo/web-developers-backend.git`.
To run the project, open Intellij and select the project that you want to open. However, you will not click on the project itself, but will click on the arrow next to it to expand the project files. You will click on the `pom.xml` file and open it as a project, not as a file.
In addition, you will need to set up a database in pgAdmin4 which will be called `web_developers_db`. This database is stored locally.

## Development server
Click run button or `Shift + F10` to build the project. Navigate to `http://localhost:4200/`. The project is connected to the `web-developers-frontend` project. 
The project is also hosted on Heroku. If you update the project, you should not only push the changes to the GitHub repository, but also to the Heroku. To do that run the command in GitBash `git push heroku master`. 
To navigate to Heroku, go to `https://dashboard.heroku.com/apps/web-developers-se`.

## Running unit tests
To run unit tests, navigate to src/test/java. Then, find the class that you want to run. Simply click on the button next to the class' function to run that specific test. If you want to run all tests in the class, then click the button next to the class' name.
