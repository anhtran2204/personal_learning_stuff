.data 
	grid:	.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."
		.asciiz " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "
		.asciiz ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", ".", " ", "."

	invalidOutput: .asciiz "Sorry, the  coordinates that you entered is invalid\n"
	userWin: .asciiz "User wins!\n"
	compWin: .asciiz "Computer wins!\n"
	boxCheck: .asciiz "It works\n"
	tempPrint: .asciiz "Sorry, the grid is incomplete\n"
	emptySpace: .byte ' '
	horizontalLine: .byte '_'
	verticalLine: .byte '|'
	userMarker: .asciiz "P"
	compMarker: .asciiz "C"
	
	nrows: .word 13
	ncolumns: .word 17
	size: .word 221
	userCol: .word 0
	userRow: .word 0
	return_ad: .word 0
	
	.eqv DATA_SIZE 8
	
	#.include "board.asm"
	
.text
.globl validInput, checkBox, checkCompletion
	validInput:
		#Resets all  variables to zero
    		li $t2, 0
    		li $t3, 0
    		li $t4, 0
    		li $t5, 0
    		li $t6, 0
    		li $t7, 0
    		li $t8, 0
    		li $t9, 0
    		li $a0, 0
    		li $a1, 0
    		li $a2, 0
    		li $a3, 0
    		li $s0, 0
    			
	
		
		lw $a1, nrows
		lw $a2, ncolumns
		
		mul $t2, $t0, $a2
		add $t2, $t2, $t1 #Finds the offset index from user-inputted coordinates
		
		
		lb $t3, board($t2) #finds the ascii character on the board at the specified index
		la $t7, emptySpace
		lb $t4, ($t7) #Loads empty space character into $t4
		
		and $t5, $t1, $t0
		andi $t5, $t5, 1
		addi $t6, $t6, 1 #Maniputlation to prevent storing characters in spaces where both row and column are odd
		beq $t5, $t6, invalidInput #checks to see if both the row and column coordinate values are odd, line can't be placed if both the row and column is odd
		bne $t3, $t4, invalidInput #checks to see if the space inputted by user is an open space
		
		andi $t5, $t0, 1 
		beq $t5, $zero, horizontalRow #Checks to see if the row is even or odd to determine the sign
		
		mul $t2, $t0, $a2
		add $t2, $t2, $t1 #Finds the offset index from user-inputted coordinates
		
		lb $t4, verticalLine($0)
		sb $t4, board($t2)  #changes the value of the array at the specified coordinate to a vertical line
		
		addi $a3, $zero, 0 #changes $a3 to 0 to prevent looping
		jr $ra #Jumps back to caller
		
		horizontalRow:
		
		mul $t2, $t0, $a2
		add $t2, $t2, $t1 #Finds the offset index from user-inputted coordinates

		lb $t4, horizontalLine($0)
		sb $t4, board($t2)  #changes the value of the array at the specified coordinate to a horizontal line
		
		addi $a3, $zero, 0 #changes $a3 to 0 to prevent looping
		jr $ra #Jumps back to caller
		
		invalidInput:
		addi $a3, $zero, 1 #changes $a3 to 1 to cause the program to loop and ask for input again
		
		jr $ra #Jumps back to caller
		
	
	checkCompletion:
		li $t0, 0 #Sets $t1 to 0
		li $t1, 0 #Sets $t2 to 0
		li $t3, 0 #Sets $t3 to 0
		li $t4, 0 #Sets $t4 to 0
		
		lw $a1, nrows
		lw $a2, ncolumns
		
		gridLoop:
		mul $t2, $t0, $a1
		add $t2, $t2, $t1 
		#mul $t2, $t2, DATA_SIZE 
		#add $t2, $t2, $a0 #Given that the row and column is specified in registers $t0 and $t1, the address of the coordinate is found
		
		lb $t5, board($t2) #Loads the value of the address 
		
		la $t7, emptySpace
		lb $t6, ($t7) #The value of an empty space (" ") is stored in $t4
		#lb $t6, emptySpace($0) #Loads the value of an empty space (" ") is stored in $t4
		
		beq $t5, $t6, incomplete #If the program detects an empty space, the program exits
		
		la $t7, userMarker
		lb $t6, ($t7)
		#lb $t6, userMarker($0) #Loads the value of a user marker ("X") is stored in $t4
		bne $t5, $t6, skip1 #Checks to see if the specified coordinate value in the array is equal to the user marker
		addi $t3, $t3, 1 #Adds one to $t3, will be used to determine winner 
		j skip2
		
		skip1:
		la $t7, compMarker
		lb $t6, ($t7)
		
		#lb $t6, compMarker($0) #Loads the value of a comp marker ("0") is stored in $t4
		bne $t5, $t6, skip2 #Checks to see if the specified coordinate value in the array is equal to the comp marker
		addi $t4, $t4, 1 #Adds one to $t4, will be used to determine winner 
		
		skip2:
		
		addi $t0, $t0, 1 #Adds one to the row index
		beq $t0, $a1, traverseRowReset #If the index hasn't reached the end of the row, the program jumps back to loop again
		j gridLoop
		
		traverseRowReset:
		add $t0, $zero, $zero #Resets the row index back to zero
		addi $t1, $t1, 1 #Increments the column index by 1 
		
		beq $t0, $a2, completeGrid # If the column index has reached the end of the column, jump out of the loop and determine the winner
		j gridLoop
		
		completeGrid:
		slt $t7, $t3, $t4 #Checks to see whether the user or computer has claimed more boxes
		bne $t7, $zero, computerWins
		
		userWins:
		la $a0, userWin
		li $v0, 4
		syscall #Prints out statement that the user has won the game
		addi $t8, $zero, 2
		jr $ra #Returns back to caller
		
		computerWins:
		la $a0, compWin
		li $v0, 4
		syscall #Prints out statement that the computer has won the game
		addi $t8, $zero, 1
		jr $ra #Returns back to caller
		
		incomplete:
		#la $a0, tempPrint
		#li $v0, 4
		#syscall 
		addi $t8, $zero, 0
		jr $ra #Returns back to caller
	
	checkBox:
		sw $ra, return_ad
		addi $a3, $zero, 0#Changes $a3 to 0 to prevent looping
		
		li $t3, 0

		lw $a1, nrows
		lw $a2, ncolumns
		
		andi $t2, $t0, 1
		
		beq $t2, $zero, isHorizontalCheck #Checks if the row is even or odd, if even, then the line is horizontal and will check whether a boz has been formed above or below
		
		addi $t7, $a2, -1 
		slt $t2, $t1, $t7
		beq $t2, $zero, verticalCheck2 #Checks to see if the line is at the last column to determine whether if a box was formed to the right
		
		addi $t2, $t1, 2#$t2 to hold the current column index shifted by 2
		
		mul $t3, $t0, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3) #stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, verticalLine
		lb $t6, ($t7) #Stores a vertical line into $t6

		
		bne $t5, $t6, verticalCheck2 #checks to see if the value at the specified index has a line and continues if it does
		
		addi $t2, $t1, 1 #$t2 to hold the current column index shifted by 1
		addi $t4, $t0, 1 #$t2 to hold the current row index shifted by 1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, horizontalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, verticalCheck2#checks to see if the value at the specified index has a line and continues if it does 
		
		addi $t2, $t1 1 #$t2 to hold the current column index shifted by 1
		addi $t4, $t0, -1 #$t2 to hold the current row index shifted by -1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t2)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, horizontalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, verticalCheck2#checks to see if the value at the specified index has a line and continues if it does 
		
		addi $t2, $t1, 1 #$t2 to hold the current column index shifted by 1
		
		mul $t3, $t0, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		beq $t9, $zero, userMarker1 #Checks to see whether its the user's turn or the computers turn
		
		la $t7, compMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a 
		
		j next1
		
		userMarker1:  
		la $t7, userMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		
		next1:
		addi $a3, $zero, 1 #Sets $a3 to 1 to loop again
		
		verticalCheck2:
		
		slt $t2, $zero, $t1
		beq $t2, $zero, exitBoxCheck#Checks to see if the line is at the first column to determine whether if a box was formed to the left
		
		addi $t2, $t1, -2 #$t2 to hold the current column index shifted by -2
		
		mul $t3, $t0, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)
		la $t7, verticalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, exitBoxCheck #checks to see if the value at the specified index has a line and continues if it does 
		
		addi $t2, $t1, -1 #$t2 to hold the current row index shifted by -1
		addi $t4, $t0, 1 #$t4 to hold the current row index shifted by 1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, horizontalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, exitBoxCheck #checks to see if the value at the specified index has a line and continues if it does 
		
		addi $t2, $t1, -1 #$t2 to hold the current column index shifted by -1
		addi $t4, $t0, -1 #$t4 to hold the current row index shifted by -1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, horizontalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, exitBoxCheck#checks to see if the value at the specified index has a line and continues if it does 
		
		addi $t2, $t1, -1  #$t2 to hold the current column index shifted by -1
		
		mul $t3, $t0, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		beq $t9, $zero, userMarker2#Checks to see whether the user won the square or the computer
		
		la $t7, compMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		j next2
		
		userMarker2:  
		
		la $t7, userMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		
		next2:
		
		addi $a3, $zero, 1 #Changes $a3 to 1 for looping
		
		j exitBoxCheck
		
		isHorizontalCheck:
		
		addi $t7, $a1, -1 
		slt $t2, $t0, $t7
		beq $t2, $zero, horizontalCheck2 #Checks to see if the line is at the last row to determine whether if a box was formed below
		
		addi $t2, $t0, 2 #$t2 to hold the current row index shifted by 2
		
		mul $t3, $t2, $a2
		add $t3, $t3, $t1 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, horizontalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, horizontalCheck2#checks to see if the value at the specified index has a line and continues if it does 
		
		addi $t2, $t1, 1 #$t2 to hold the current column index shifted by 1
		addi $t4, $t0, 1 #$t4 to hold the current row index shifted by 1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, verticalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, horizontalCheck2#checks to see if the value at the specified index has a line and continues if it does
		
		addi $t2, $t1, -1  #$t2 to hold the current column index shifted by -1
		addi $t4, $t0, 1 #$t4 to hold the current row index shifted by 1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, verticalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, horizontalCheck2#checks to see if the value at the specified index has a line and continues if it does
		
		addi $t2, $t0, 1 #$t2 to hold the current row index shifted by 1
		
		mul $t3, $t2, $a2
		add $t3, $t3, $t1 #Calculates and loads the index offset into $t3
		
		beq $t9, $zero, userMarker3#Checks to see whether the user won the square or the computer
		
		la $t7, compMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		
		j next3 
		
		userMarker3:  
		la $t7, userMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		
		next3:
		addi $a3, $zero, 1 #Changes $a3 to 1 for looping
		
		horizontalCheck2:
		
		slt $t2, $zero, $t0
		beq $t2, $zero, exitBoxCheck #Checks to see if the line is at the first row to determine whether if a box was formed above
		
		addi $t2, $t0, -2 #$t2 to hold the current row index shifted by -2
		
		mul $t3, $t2, $a2
		add $t3, $t3, $t1 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, horizontalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, exitBoxCheck#checks to see if the value at the specified index has a line and continues if it does
		
		addi $t2, $t1, 1 #$t2 to hold the current column index shifted by 1
		addi $t4, $t0, -1 #$t4 to hold the current row index shifted by -1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, verticalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, exitBoxCheck #checks to see if the value at the specified index has a line and continues if it does
		
		addi $t2, $t1, -1 #$t2 to hold the current column index shifted by -1
		addi $t4, $t0, -1 #$t4 to hold the current row index shifted by -1
		
		mul $t3, $t4, $a2
		add $t3, $t3, $t2 #Calculates and loads the index offset into $t3
		
		lb $t5, board($t3)#stores the ascii charcacter on the board at the index at $t3 into $t5
		la $t7, verticalLine
		lb $t6, ($t7)#Stores a vertical line into $t6
		
		bne $t5, $t6, exitBoxCheck#checks to see if the value at the specified index has a line and continues if it does
		
		addi $t2, $t0, -1 #$t2 to hold the current row index shifted by -1
		
		mul $t3, $t2, $a2
		add $t3, $t3, $t1 #Calculates and loads the index offset into $t3
		
		beq $t9, $zero, userMarker4#Checks to see whether the user won the square or the computer
		
		la $t7, compMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		j next4
		
		userMarker4:  
		
		la $t7, userMarker
		lb $t4, ($t7)  #Loads the horizontal line character to be added into the array
		sb $t4, board($t3)  #changes the value of the array at the specified coordinate to a horizontal line
		
		next4:
		addi $a3, $zero, 1 #Changes $a3 to 1 for looping
		
		j exitBoxCheck
		
		exitBoxCheck:
		
		lw $ra, return_ad
		jr $ra
	
	
		
	

			

		
