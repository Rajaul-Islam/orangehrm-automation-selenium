

#  HRM Suite Automation with TestNG

This is Simple automation of an HRM Management Suite.
I have used TestNg as a test framework and Faker library
to generate random users. Here I have automated user
login and creation and an automated employee search, and employee Information Update System.


## Automation Video
##






## How to run this project

- Clone This project
- open build.gradle file in IntelliJ IDEA
- Then Hit the following command in the terminal

```bash
  allure generate allure-results --clean -o allure-report
  allure serve allure-results
```
## Tools and Tech
- IntelliJ IDEA
- Selenium with TestNG
- Allure
- Gradle


## Test Case:
https://docs.google.com/spreadsheets/d/16Ok6JD1ylwbG48nBUL2UlweG0opYqSVI/edit?usp=sharing&ouid=105413695096846736430&rtpof=true&sd=true



# Allure report Screenshots

![image](https://github.com/user-attachments/assets/e79b67ce-fb20-4e8e-a51d-a3f2d33c527d)
![image](https://github.com/user-attachments/assets/d522b3ee-5e70-4b78-8685-f7d2bffe76bc)






## Scenerio

1. Login to orange hrm demo site
https://opensource-demo.orangehrmlive.com/

2. Create 2 new employees and save it to a JSON list
3. Now go to PIM dashboard and search by 1st user name. Assert that the user is found.
4. Now click on the user from the search table and update the id by random userid
5. Now again search the user by new user id from the PIM dashboard menu and assert that the user is found
6. Now logout from admin and log in with the 2nd user from your JSON list
7. Now click on My Info menu
8. Select Gender and Blood Type and save it
9. Click on contact details and input address and email
10. Logout the user


