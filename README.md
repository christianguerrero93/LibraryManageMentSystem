# LibraryManagementSystem

LibraryManagementSystem created in Java which connects to Mysql and allows the user to add data to the database as well as retrieve data. Command Line was used to allow the user to interact with the database and choose whether they are a borrower, librarian or administrator. I have always been an avid reader which gave me the idea for the project.

Librarian Functionality was added which can do the following

1) Retrieve from the database the List of LibraryBranches using names or locations and if the user enters the wrong Library Branch printed on the screen the user is let known so they can re enter again since it does not exist in the database
2) Based on user input the Librarian can either update the Library Branch Address or Library Branch Name
3) Librarian also can update the number of Copies of each book associated with the LibraryBranch.

Borrower Functionality was added which can do the following

1) Borrower enters there card number and if the card number is not in the database the user is let known please try again since incorrect number added
2) The Borrower has the option of checking out a book or returning a book
3) The list of Library Branches is printed on the screen and the user chooses which one they are associated with if correct branch chosen since not in database told the user to enter again
4) Then the list of Books was printed on the screen based on the Library Branch associated
5) Made sure only to print books that have at least one copy since there cant be a negative number of copies
6) If the user checks out a book it is added to a Book Loan which adds a Due Date and DueOut. Local Date Time API was used to add the current date and to add the due date to a week Later
7) Once the user checks out a book the number of copies of the book is decremented by one
8) If the user returns a book it is removed from the Book Loans Table
9) Once the user returns a book the number of copies of the book is incremented by one

Administrator Functionality was added which can do the following

When creating the database I added auto increment on the primary key to add a unique key each time so Admin can add items
Each Option below printed all the data associated with each table 

1) ADD/UPDATE/DELETE Book
2) ADD/UPDATE/DELETE Author
3) ADD/UPDATE/DELETE Publisher
4) ADD/UPDATE/DELETE LibraryBranch
5) ADD/UPDATE/DELETE Borrower
6) Override Due Date From Book Loans

Below is the schema created for the project

![librarymanagement schema](https://user-images.githubusercontent.com/26370037/52392980-2eb89d80-2a72-11e9-9d0d-275dfd63045c.PNG)
