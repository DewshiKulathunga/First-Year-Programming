# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# Student ID: w1809778        
  
# Date:  10.12.2020

#data is a list in a list which holds the data.

data = [[120,0,0],[100,20,0],[100,0,20],[80,20,20],[60,40,20],[40,40,40],[20,40,60],[20,20,80],[20,0,100],[0,0,120]]
progress = 0
trailer = 0
retriever = 0
exclude = 0
answer = ''    #used to find  if the answer from ReviewMarks function is process, trailer, retriever or exclude
total = 0

def ReviewMarks (answer):
    '''Get Inputs and find appropriate progression outcomes'''
    #Getting Inputs
    PassMark = data[0][0]   #Calling variables in list in a list as an input
    defer = data[0][1]
    fail = data[0][2]
    #Process and Display Progression Outcomes
    if PassMark == 120:
        print ("Progress")
        answer = 'progress'

    elif PassMark == 100:
        print("Progress(module trailer)")
        answer = 'trailer'
       
    elif PassMark <= 80 and defer >=0 and fail<=60 or defer >= 20 and fail <= 60 or defer >= 40 and fail <= 60 or defer >= 60 and fail <= 60:
        print("Do not Progress - module retriever")
        answer = 'retriever'
        
    elif PassMark == 40 and defer == 0 and fail == 80 or PassMark == 20 and defer<= 20 and fail >=80 or PassMark == 0 and defer <= 40 and fail >= 80:
        print("Exclude")
        answer = 'exclude'
    return answer

def horizontalHistogram(progress,trailer,retriever,exclude,total):
    '''Printing the Horizontal Histogram'''
    print("\n")
    print("Progress","\t",progress,"\t:",'*'*progress)
    print("Trailer","\t",trailer,"\t:",'*'*trailer)
    print("Retriever","\t",retriever,"\t:",'*'*retriever)
    print("Exclude","\t",exclude,"\t:",'*'*exclude)
    print("\n")
    print(total,"outcomes in total.")

while len(data) != 0: 
    Marks = ReviewMarks(answer)      #Calling function and assigning Marks variable with the returned answer from ReviewMarks function.
    total = total + 1
    data.pop(0)        #Removing a variable from a list in list


    if Marks == 'progress':
        progress = progress + 1
    elif Marks == 'trailer':
        trailer = trailer + 1
    elif Marks == 'retriever':
        retriever = retriever + 1
    elif Marks == 'exclude':
        exclude = exclude + 1

horizontalHistogram(progress,trailer,retriever,exclude,total)   #Calling HorizontalHistogram function
 



