# Random-Number-Generator-JavaFx
This JavaFx project generates a random number by inputting two integer numbers. 

# How it works
This is how it looks like when you run it:

![Scene](https://user-images.githubusercontent.com/127019014/223148383-c9117fad-1956-4ad9-b09a-8ab57a643344.PNG)

Enter two integers in the textfields and click on the Generate button in order to get a random integer generated and displayed on the bottom.

![image](https://user-images.githubusercontent.com/127019014/223162271-0d5be311-075d-477f-9d4d-67a2d299ad15.png)

After a random number is generated, the user is forced to click on the clear button. 
The clear button deletes the previously generated random integer and clears the textfields

![clearButton](https://user-images.githubusercontent.com/127019014/223149521-7e709606-2893-4cb0-8ea7-59dded33c289.PNG)

# Handling input errors
The user can recognize the error and recover from it on their own
## Handling empty textfields
The user receives the feedback to enter a number which is displayed next to the empty textfield.

![emptyTextfields](https://user-images.githubusercontent.com/127019014/223149873-506f91b1-49a5-4293-9a01-c96a10f8f8e7.PNG)
![oneEmptyTextfield](https://user-images.githubusercontent.com/127019014/223150577-c9bcfcd5-1ca0-4dfe-91c1-b686fb1a0688.PNG)

## Handling invalid input e.g. letters instead of numbers
A regex checks if the input consists only of numbers. The user receives the feedback to enter a number which is displayed next to the empty textfield.

![image](https://user-images.githubusercontent.com/127019014/223152267-bab38759-e36d-4f09-b7db-0e097df55af2.png)
![image](https://user-images.githubusercontent.com/127019014/223152494-d526e371-d530-439d-816d-1bcfea6bfdeb.png)

