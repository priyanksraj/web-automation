# web-automation

Problem: Automate an end to end user e-commerce transaction flow using any open source tool for mobile.walmart.com<http://mobile.walmart.com> with an existing customer on chrome or safari browser.

I have used selenium webdriver to automate the flow.
I have used Page Object Model to design the automation for the checkout flow.

Technical Debts in the code

1. CartPage has elements inly to support single item in cart, if you add more than one item the cartPage cannot handle it. - Given more time I would like to fix it.
2. CheckoutPage - does not contain any kid of validation - it assumes default shipping method and default address will be automatically select. If the user does not have a shipping address the test case will fail.
3. Product search page selects the first item by default, there is no code to support pagination etc.

Thanks
Priyanka

