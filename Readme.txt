Toshal Rajendra Tambave
UTA ID: 1001529480
Programming Language: Java

How to run the code:
(Please note filename & name of cities are case sensitive)
1)Copy Find_route.java into omega 
2)Copy input file into same directory
3)run command- javac Find_route.java
		      java Find_route
4)Enter input in following format:
		      input_filename origin_city destination_city
5)Press enter

Code Structure:
There are two classes
1)class Find_route
	This deals with creating a adjacency matrix from the input file
	it takes rootnode & destNode from user and searches the matrix to find possible routes
	it implements bfs to check if path exists
	currently it only displays if route exists or not 
	path is not being displayed
	relevant code has been commented out as it could not be completed on time

2)Class ReadInput
	This deals with scanning the input file
	It divides the input into 3 columns citiA, citiB and distance to parse
	Then input is converted into sorted list so that adjacency can be created

