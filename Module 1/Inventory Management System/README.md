**# Inventory Management System**

A console-based **\*\*Inventory Management System developed in Java\*\***. The application allows users to manage products, categories, and stock through an interactive terminal menu.

The project is part of the Java Full Stack Practical Code collection and is located under:

\`\`\`text

Java Full Stack Practical Code/

└── Module Project/

    └── Module - 1/

        └── Inventory Management System/

\`\`\`

**---**

**## 1. Project Overview**

The Inventory Management System is a menu-driven Java application that helps users maintain product and category records. It supports product management, category management, stock operations, and low-stock reporting.

The application runs in the **\*\*VS Code PowerShell terminal\*\*** and does not require a graphical user interface.

**---**

**## 2. Features**

**### Product Management**

\- Add a new product

\- View all products

\- Search for a product by name

\- Update product details

\- Delete a product

\- Automatically generate the next product ID

\- Validate price and stock values

**### Category Management**

\- Add a new category

\- View all categories

\- Update category details

\- Delete a category

\- Automatically generate the next category ID

\- Prevent deletion when a category is used by a product

**### Stock Management**

\- Add stock to an existing product

\- Remove stock from an existing product

\- View all products and their stock levels

\- Validate stock quantities

**### Reports**

\- Display products with stock at or below the low-stock limit

\- The default low-stock limit is **\*\*5\*\***

**### Data Storage**

\- Product records are stored in \`products.dat\`

\- Category records are stored in \`categories.dat\`

\- Java object serialization is used for saving and loading data

**---**

**## 3. Technologies Used**

\- **\*\*Programming Language:\*\*** Java

\- **\*\*JDK Used:\*\*** Java 25

\- **\*\*IDE:\*\*** Visual Studio Code

\- **\*\*Terminal:\*\*** PowerShell

\- **\*\*Storage Method:\*\*** Java Serialization

\- **\*\*Application Type:\*\*** Console-Based Application

\- **\*\*Programming Concepts:\*\*** Classes, Objects, Encapsulation, Collections, File Handling, Serialization, and Exception Handling

**---**

**## 4. Project Structure**

\`\`\`text

Inventory Management System/

│

├── Main.java

├── InventoryManager.java

├── Product.java

├── Category.java

├── FileManager.java

├── products.dat

└── README.md

\`\`\`

**### File Description**

\| File | Purpose |

\|---|---|

\| \`Main.java\` | Contains the main method, menus, user input, and application flow |

\| \`InventoryManager.java\` | Handles product, category, and stock management operations |

\| \`Product.java\` | Defines product attributes such as ID, name, category, price, and stock |

\| \`Category.java\` | Defines category attributes such as ID and name |

\| \`FileManager.java\` | Saves and loads product and category data using serialization |

\| \`products.dat\` | Stores serialized product records |

\| \`categories.dat\` | Stores serialized category records when created |

**---**

**## 5. Requirements**

Install the following software before running the project:

1\. Java Development Kit (JDK)

2\. Visual Studio Code

3\. Java Extension Pack for Visual Studio Code (recommended)

Verify Java installation:

\`\`\`powershell

java -version

\`\`\`

Verify the Java compiler:

\`\`\`powershell

javac -version

\`\`\`

Example:

\`\`\`text

java version "25" 2025-09-16 LTS

\`\`\`

**---**

**## 6. How to Execute the Project in VS Code**

**### Step 1: Open the Project Folder**

Open the following folder in Visual Studio Code:

\`\`\`text

Inventory Management System

\`\`\`

The folder must contain:

\`\`\`text

Main.java

InventoryManager.java

Product.java

Category.java

FileManager.java

\`\`\`

**### Step 2: Open the Integrated Terminal**

In VS Code:

\`\`\`text

Terminal → New Terminal

\`\`\`

Alternatively, right-click the project folder and select:

\`\`\`text

Open in Integrated Terminal

\`\`\`

Confirm that the terminal is located inside the Inventory Management System folder.

**### Step 3: Compile All Java Files**

Run the following command:

\`\`\`powershell

javac -d out \*.java

\`\`\`

**#### Explanation**

\- \`javac\` is the Java compiler.

\- \`-d out\` places the compiled \`.class\` files inside the \`out\` directory.

\- \`\*.java\` compiles all Java source files in the current folder.

If compilation is successful, no error message will be displayed.

**### Step 4: Run the Application**

Execute the main class using:

\`\`\`powershell

java -cp out Main

\`\`\`

**#### Explanation**

\- \`java\` starts the Java runtime.

\- \`-cp out\` sets the classpath to the compiled output directory.

\- \`Main\` is the class containing the \`main()\` method.

The Inventory Management System menu will then appear in the terminal.

**---**

**## 7. Complete Execution Commands**

Run the following commands from the Inventory Management System folder:

**### Compile**

\`\`\`powershell

javac -d out \*.java

\`\`\`

**### Execute**

\`\`\`powershell

java -cp out Main

\`\`\`

**### Combined Commands**

\`\`\`powershell

javac -d out \*.java

java -cp out Main

\`\`\`

\> If the \`out\` folder does not exist, the \`javac -d out\` command creates it automatically.

**---**

**## 8. Main Menu**

After execution, the application displays the following main menu:

\`\`\`text

\==========================================

     INVENTORY MANAGEMENT SYSTEM

\==========================================

\==========================================

              MAIN MENU

\==========================================

1\. Product Management

2\. Category Management

3\. Stock Management

4\. Low Stock Report

5\. Exit

\==========================================

\`\`\`

Enter the number of the required option in the terminal.

**---**

**## 9. Product Management Menu**

Select option \`1\` from the main menu.

\`\`\`text

\------------------------------------------

          PRODUCT MANAGEMENT

\------------------------------------------

1\. Add Product

2\. View Products

3\. Search Product

4\. Update Product

5\. Delete Product

6\. Back

\`\`\`

**### Add Product**

1\. Select \`1\`.

2\. Enter the product name.

3\. Enter the category.

4\. Enter the price.

5\. Enter the initial stock quantity.

6\. The application generates a product ID automatically.

7\. The product is saved if the input is valid.

**### View Products**

Select \`2\` to display all stored products.

**### Search Product**

Select \`3\` and enter the product name to search for matching products.

**### Update Product**

Select \`4\`, enter the product ID, and provide the updated product information.

**### Delete Product**

Select \`5\`, enter the product ID, and confirm the deletion using:

\`\`\`text

yes

\`\`\`

Select \`6\` to return to the main menu.

**---**

**## 10. Category Management Menu**

Select option \`2\` from the main menu.

\`\`\`text

\------------------------------------------

          CATEGORY MANAGEMENT

\------------------------------------------

1\. Add Category

2\. View Categories

3\. Update Category

4\. Delete Category

5\. Back

\`\`\`

The category menu allows users to add, display, update, and delete categories.

A category cannot be deleted if it is being used by a product.

**---**

**## 11. Stock Management Menu**

Select option \`3\` from the main menu.

\`\`\`text

\------------------------------------------

             STOCK MANAGEMENT

\------------------------------------------

1\. Add Stock

2\. Remove Stock

3\. View Products

4\. Back

\`\`\`

**### Add Stock**

1\. Enter the product ID.

2\. Enter the quantity to add.

3\. The application updates and displays the new stock level.

**### Remove Stock**

1\. Enter the product ID.

2\. Enter the quantity to remove.

3\. The application validates the quantity and updates the stock.

**### View Products**

Displays the available products and their current stock values.

**---**

**## 12. Low Stock Report**

Select option \`4\` from the main menu.

The application displays products whose stock quantity is less than or equal to the configured low-stock limit.

The default limit in the application is:

\`\`\`text

5

\`\`\`

This feature helps identify products that may require restocking.

**---**

**## 13. Data Persistence**

The application uses Java serialization to store information in data files.

\`\`\`text

products.dat

categories.dat

\`\`\`

Product and category records are saved when changes are made and loaded when the application starts.

**### Important**

Run the application from the Inventory Management System folder so that the relative data-file paths work correctly.

Do not delete the \`.dat\` files unless you intentionally want to remove the stored data.

**---**

**## 14. Validation and Error Handling**

The application includes basic validation for:

\- Invalid menu choices

\- Negative product prices

\- Negative stock values

\- Invalid stock quantities

\- Products that do not exist

\- Categories that do not exist

\- Deleting categories used by products

\- Invalid user input

The application displays an appropriate message when an operation cannot be completed.

**---**

**## 15. Troubleshooting**

**### Error: \`javac\` Is Not Recognized**

Check whether the JDK is installed:

\`\`\`powershell

javac -version

\`\`\`

If the command fails, install the JDK and configure the Java PATH environment variable.

**### Error: \`Could not find or load main class Main\`**

Make sure that:

1\. Compilation was successful.

2\. The command is executed from the project folder.

3\. The classpath is correct.

4\. The compiled files exist inside the \`out\` directory.

Try:

\`\`\`powershell

java -cp out Main

\`\`\`

**### Error: File Not Found or Data Loading Error**

Ensure that the application is executed from the Inventory Management System directory. The application uses relative paths for its data files.

**### Compilation Errors**

Make sure all Java files are compiled together:

\`\`\`powershell

javac -d out \*.java

\`\`\`

**---**

**## 16. Learning Outcomes**

This project demonstrates:

\- Java classes and objects

\- Encapsulation using private fields and methods

\- ArrayList and collection handling

\- Menu-driven programming

\- File handling

\- Object serialization

\- CRUD operations

\- Input validation

\- Exception handling

\- Modular Java application design

\- Compilation and execution using the command line

**---**

**## 17. Result**

The Inventory Management System can be compiled and executed in Visual Studio Code using the Java compiler and Java runtime commands.

The application provides an interactive terminal menu for managing products, categories, stock quantities, and low-stock reports.

**---**

**## 18. Conclusion**

The Inventory Management System is a Java-based console application that demonstrates practical implementation of object-oriented programming, collection management, file handling, serialization, and menu-driven application development.

It provides a structured way to manage inventory records and can be further extended with a graphical interface, database connectivity, authentication, and advanced reporting.

**---**

**## Author**

**\*\*Devansh Verma\*\***

B.Tech – Computer Science and Engineering  

SRM Institute of Science and Technology
![alt text](<Screenshot 2026-09-23 162644.png>) ![alt text](<Screenshot 2026-09-23 162652.png>)