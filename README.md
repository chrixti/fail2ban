This program will take two command line arguments: the name of a single log file and the name of an output file.
It'll read each line of the program in, extract the IP address from the line and determine whether the line is a failed login attempt or valid login attempt.
A bad attempt in the logs_processed.txt is indicated by "Invalid" and, once identified, the IP address will always be in the same position.
The number of times a particular IP address fails to login is tracked.
The program will then open the output file and print a list of IP addresses to that fail 3 or more times.
The list of IP addresses that have failed 3 or more times will appear in the output.txt file.

command line execution:
$ java Fail2Ban logs_processed.txt output.txt

!! This was a homework assingment for Intro to Programming in Java
