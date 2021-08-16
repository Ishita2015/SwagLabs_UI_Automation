# SwagLabs_Automation

This project aims to login into SwagLabs site, apply filters, add the highest/lowest price items from available items into the cart and place the order.

Steps:

1. Login to https://www.saucedemo.com/ using username and password.

2. Click on the Open Menu button on the top left corner (It's a small box with 3 lines).

3. Select 'About'.

4. Check if user is taken to https://saucelabs.com/ site

5. Click on the browser back button and Validate if you are taken back to the saucedemo PRODUCTS page.

6. Click on Filter and select 'High to Low' then add the first item (which has the highest price) to the cart. Repeat the same using filter 'Low to High' for adding the lowest price item into the cart.

7. Click on the Cart button available at the top right corner.

8. Validate if you are taken to YOUR CART page.

9. Click Checkout.

10. Validate if you are navigated to CHECKOUT: YOUR INFORMATION page.

11. Enter all details in the text boxes and click CONTINUE.

12. Validate if you are navigated to CHECKOUT: OVERVIEW & Total Price is shown in 'Total: $' format.

13. Click Finish

14. Validate if your order has been completed or not.

## Pre-requisite

For setup, read and follow the below instructions:

1. Install GIT (https://git-scm.com/downloads)
2. Install JDK (https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
3. Install Eclipse (https://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers)
	
## Quickstart

1. Open a Git Bash Prompt and run below command:
   `git clone https://github.com/Ishita2015/SwagLabs_Automation.git`

2. Open Eclipse:
	1. Import Project as Maven -> Existing Maven Projects
	2. Select `SwagLabs_Automation` project folder and click finish.

3. The project will be imported and there is nothing special to do.

4. Now, you can run the `testng.xml` as a TestNG suite and it adds the item into the cart and places the order.
