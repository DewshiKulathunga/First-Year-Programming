# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# Student ID: w1809778        
  
# Date:  10.12.2020

progress = 0
trailer = 0
retriever = 0
exclude = 0
answer = ''    #used to find  if the answer from ReviewMarks function is process, trailer, retriever or exclude
total = 0
lines = 0      #used to find the highest number of times repeated from process, trailer, retriever and excluded

def ReviewMarks (answer):
    '''Get Inputs and find appropriate progression outcomes'''
    #Getting Input, Process and Display Progression Outcomes
    PassMark = input("\n\nPlease enter your credits at pass : ")
    try:
        PassMark = int(PassMark)
    
        Range = [0,20,40,60,80,100,120]          #Variables which are included in the range
        CheckRange = PassMark not in Range        
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
                                    answer = 'progress'

                                elif PassMark == 100:
                                    print("Progress (module trailer)")
                                    answer = 'trailer'

                                elif PassMark <= 80 and defer >=0 and fail<=60 or defer >= 20 and fail <= 60 or defer >= 40 and fail <= 60 or defer >= 60 and fail <= 60:
                                    print("Do not Progress - module retriever")
                                    answer = 'retriever'
    
                                elif PassMark == 40 and defer == 0 and fail == 80 or PassMark == 20 and defer<= 20 and fail >=80 or PassMark == 0 and defer <= 40 and fail >= 80:
                                    print("Exclude")
                                    answer = 'exclude'

                    except ValueError:
                        print("Integer Required")
                                    
            except ValueError:
                print("Integer Requiresd")

    except ValueError:
        print("Integer Required")
    return answer

def horizontalHistogram(progress,trailer,retriever,exclude,total):
    '''Printing the Horizontal Histogram'''
    print("-------------------------------------------")
    print("Horizontal Histogram")
    print("Progress","\t",progress,"\t:",'*'*progress)
    print("Trailer","\t",trailer,"\t:",'*'*trailer)
    print("Retriever","\t",retriever,"\t:",'*'*retriever)
    print("Exclude","\t",exclude,"\t:",'*'*exclude)
    print("\n")
    print(total,"outcomes in total.")

print("Staff Version with Histogram")

Marks = ReviewMarks(answer)   #Calling the ReviewMarks function for the first time and assigning Marks variable with the returned answer from ReviewMarks function.

if Marks == 'progress':
    progress = progress + 1
    total = total + 1
elif Marks == 'trailer':
    trailer = trailer + 1
    total = total + 1
elif Marks == 'retriever':
    retriever = retriever + 1
    total = total + 1
elif Marks == 'exclude':
    exclude = exclude + 1
    total = total + 1
    
print("\n\nWould you like to enter another set of data?")
Repeat = input("Enter 'y' for yes or 'q' to quit and view results: ")  #Repeat variable is used first time to find if the user wants to enter another set of data.

while Repeat == 'y':
    Marks = ReviewMarks(answer)  #Calling the ReviewMarks function while the user wante to enter another set of data and assigning Marks variable with the returned answer from ReviewMarks function.
    if Marks == 'progress':
        progress = progress + 1
        total = total + 1
    elif Marks == 'trailer':
        trailer = trailer + 1
        total = total + 1
    elif Marks == 'retriever':
        retriever = retriever + 1
        total = total + 1
    elif Marks == 'exclude':
        exclude = exclude + 1
        total = total + 1
    print("\n\nWould you like to enter another set of data?")
    Repeat = input("Enter 'y' for yes or 'q' to quit and view results:")  #Repeat variable is used to find if the user wants to enter aother set of data.

if Repeat == 'q':   #user enters q to exit from the process
    print("\n")

#Printing Horizontal Histogram
horizontalHistogram(progress,trailer,retriever,exclude,total)    #Calling HorizontalHistogram function

#Printing Vertical Histogram   
print("-------------------------------------------")
print("Vertical Histogram")
print("\n")
print("Progress","    ","Trailer","    ","Retriever","    ","Exclude")

if (progress >= trailer) and (progress >= retriever) and (progress >= exclude):
    lines = (progress)
elif (trailer > progress) and (trailer > retriever) and (trailer > exclude):
    lines = (trailer)
elif (retriever > progress) and (retriever > trailer) and (retriever > exclude):
    lines = (retriever)
elif (exclude > progress) and (exclude > trailer) and (exlude > retriever):
    lines = (exclude)
elif (progress == trailer == retriever == exclude):
    lines = (progress)
else:
    pass

i = lines       #lines variable is assigned to variable i

while (i > 0):
    if (progress > 0):
        print("    *      ",end = '')
        progress = progress - 1
    else:
        print("           ",end = '')

    if (trailer > 0):
        print("     *      ",end = '')
        trailer = trailer - 1
    else:
        print("            ",end = '')

    if (retriever > 0):
        print("       *      ",end = '')
        retriever = retriever - 1
    else:
        print("              ",end = '')

    if (exclude > 0):
        print("       *      ",end = '\n')
        exclude = exclude - 1
    else:
        print("              ",end = '\n')

    i = i - 1

print("\n")
print(total,"outcomes in total.")
