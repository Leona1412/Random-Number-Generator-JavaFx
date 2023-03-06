# Random-Number-Generator-JavaFx
This JavaFx project generates a random number by inputting two integer numbers. 

#How it works
This is how it looks like when you run it:
![Scene](https://user-images.githubusercontent.com/127019014/223148383-c9117fad-1956-4ad9-b09a-8ab57a643344.PNG)

Enter two integers in the textfields and clock on the Generate button in order to get a random integer generated.
![enterTwoInts](https://user-images.githubusercontent.com/127019014/223148956-16227ebd-3d11-4a5a-bbb7-29fecdee13ab.PNG)

The clear button deletes the previously generated random integer and clears the textfields
![clearButton](https://user-images.githubusercontent.com/127019014/223149521-7e709606-2893-4cb0-8ea7-59dded33c289.PNG)

#Handling input errors
##Empty textfields
The user receives the feedback to enter a number next to the empty textfield.
![emptyTextfields](https://user-images.githubusercontent.com/127019014/223149873-506f91b1-49a5-4293-9a01-c96a10f8f8e7.PNG)
![oneEmptyTextfield](https://user-images.githubusercontent.com/127019014/223150577-c9bcfcd5-1ca0-4dfe-91c1-b686fb1a0688.PNG)

##Invalid Input e.g. letters instead of numbers
A regex checks if the input consists only of numbers. The user receives the feedback to enter a number next to the empty textfield.
![image](https://user-images.githubusercontent.com/127019014/223152267-bab38759-e36d-4f09-b7db-0e097df55af2.png)
![image](https://user-images.githubusercontent.com/127019014/223152494-d526e371-d530-439d-816d-1bcfea6bfdeb.png)

