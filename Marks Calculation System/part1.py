# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# Student ID: w1809778         
  
# Date:  10.12.2020


#Getting Inputs
PassMark = int(input("Please enter your credits at pass : "))
defer = int(input("Please enter your credits at defer : "))
fail = int(input("Please enter your credits at fail : "))

#Process & Display Outputs
if PassMark == 120:
    print("Progress")

elif PassMark == 100:
    print("Progress (module trailer)")

elif PassMark <= 80 and defer >=0 and fail<=60 or defer >= 20 and fail <= 60 or defer >= 40 and fail <= 60 or defer >= 60 and fail <= 60:
    print("Do not Progress - module retriever")
    
elif PassMark == 40 and defer == 0 and fail == 80 or PassMark == 20 and defer<= 20 and fail >=80 or PassMark == 0 and defer <= 40 and fail >= 80:
    print("Exclude")
