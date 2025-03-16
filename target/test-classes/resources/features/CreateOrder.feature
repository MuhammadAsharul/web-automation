# Feature: Purchase the order from ecommerce

# Background: Buyer landed to website
#     Given Buyer landing to ecommerce

# Scenario: Create Order Positive Case
#     Given Buyer logged to website
#     When Buyer add product to cart
#     And Buyer checkout product
#     And Buyer place order
#     Then Buyer will see message is displayed on confirmation page


# Scenario Outline: Create Order Positive Case
#     Given Buyer logged to website email <email> and password <password>
#     When Buyer add <product_name> to cart
#     And Buyer checkout <product_name>
#     And Buyer place order <destination>
#     Then Buyer will see message is displayed on confirmation page THANKYOU FOR THE ORDER.

#     Examples: 
#     | email               | password   | product_name | destination |
#     | masharul51@gmai.com | Boyolali15 | ZARA COAT 3  | Indonesia   |

# Scenario Outline: Login Negative Case
#     When Buyer logged to website email <email> and password <pasword>
#     Then buyer will see toaster
    
#     Examples: 
#     |email               | password   | 
#     |masharul51@gmai     | Boyolali15 | 
#     |masharul51@gmai.com | Boyolali   | 
#     |masharul51@gmai     | Boyolali   | 