Feature: Verify ORANGEHRM admin functionality
Scenario Outline: Admin is login page and in PIM module
When User enters <username> and password <password> and clicks on PIM
Then Admin isin PIM module
Examples:
|username|password|
|Admin   |admin123|
|admin   |admin   |

Scenario: Check  wheather Admin is able to configure optional  fields
Given User login succesfully and is in PIM module
When admin select the option configuration he is able to edit and save the modified optional fields



Scenario Outline: Check  wheather Admin is able to configure custom  fields
Given User login succesfully and is in PIM module
When admin select the option configuration and type the field name to be added<fieldname> and select screen and type and verify
 
Examples:
|fieldname             |
|Areas of interest     |
|Hobbies               |



Scenario Outline: Check  wheather Admin is able to view all employee details
Given User login succesfully and is in PIM module
When admin select the option Employee List enter the name of employee<employeename>and enter the id of employee<empid>and verify

Examples:
|employeename|empid|
|Peter Mac   |0007 |
|Lisa        |0208 |


Scenario Outline: Check  wheather Admin is able to add employee details
Given User login succesfully and is in PIM module
When admin select the option  Add Employee enter the name of employee<empname>and enter the id of employee<employeeid> and verify

Examples:
|empname       |employeeid|
|prasanna      | 0405     |
|dhatri        | 0438     |


Scenario Outline: Check  wheather Admin is able to generate report
Given User login succesfully and is in PIM module
When admin select the option report and enter the name of report to be generated<report> and view the generated report

Examples:
|report              |
|PIM Sample Report   |
|Employee Job Details|



                        
