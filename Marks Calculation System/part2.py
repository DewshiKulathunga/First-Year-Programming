# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# Student ID: w1809778        
  
# Date:  10.12.2020


#Error Handling
#CheckRange variable is taken find if a value is Out of Range
#Range list includes all variables which are in range 
#Program displays Total Incorrect if total of Pass,Defer and Fail marks are not equal to 120

#Getting Inputs, Process and Display Outputs
PassMark = input("Please enter your credits at pass : ")
try:
    PassMark = int(PassMark)
    
    Range = [0,20,40,60,80,100,120]         #Variables which are included in the range
    CheckRange = PassMark not in Range      #Checks if PassMark is not in Range and assigns the boolean answer to CheckRange variable.
    if CheckRange == True:                  
        print("Out of range")
    else:    
        defer = input("Please enter your credits at defer : ")
        try:
            defer = int(defer)

            CheckRange = defer not in Range
            if CheckRange == True:
                print("Out of Range")
            else:
                fail = input("Please enter your credits at fail : ")
                try:
                    fail = int(fail)

                    CheckRange = fail not in Range
                    if CheckRange == True:
                        print("Out of Range")
                    else:

                        total = PassMark + defer + fail

                        if total != 120:
                            print("Total Incorrect")

                        else:
                            if PassMark == 120:
                                print("Progress")

                            elif PassMark == 100:
                                print("Progress (module trailer)")

                            elif PassMark <= 80 and defer >=0 and fail<=60 or defer >= 20 and fail <= 60 or defer >= 40 and fail <= 60 or defer >= 60 and fail <= 60:
                                print("Do not Progress - module retriever")
    
                            elif PassMark == 40 and defer == 0 and fail == 80 or PassMark == 20 and defer<= 20 and fail >=80 or PassMark == 0 and defer <= 40 and fail >= 80:
                                print("Exclude")

                except ValueError:      #If Try integer PassMark gives a value error it displays integer required.
                    print("Integer Required")
                                    
        except ValueError:              #If Try integer defer gives a value error it displays integer required.
            print("Integer Requiresd")

except ValueError:                      #If Try integer fail gives a value error it displays integer required.
    print("Integer Required")

    

