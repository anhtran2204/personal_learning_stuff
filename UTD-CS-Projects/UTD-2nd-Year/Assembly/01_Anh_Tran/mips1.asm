# Data segment
.data	
	input1: .asciiz "Enter the first number: "	
	input2 : .asciiz "Enter the second number: "	
	message: .asciiz "The difference of X and Y (X - Y) is "
	X: .word 0
	Y: .word 0
	D: .word 0
	
# Code segment	
.text
	main:
		# Prompt asking user to enter 1st integer
		li $v0, 4
		la $a0, input1
		syscall
		
		# Get the 1st integer
		li $v0, 5
		syscall
		sw $v0, X
		
		# Prompt asking user to enter 2nd integer
		li $v0, 4
		la $a0, input2
		syscall
		
		# Get the 2nd integer
		li $v0, 5
		syscall
		sw $v0, Y
		
		# Do subtraction and store result in $t2
		lw $t0, X
		lw $t1 Y
		sub $t2, $t0, $t1
		sw $t2, D
		
		# Display message
		li $v0, 4
		la $a0, message
		syscall
		
		# Print result
		lw $a0, D
		li $v0, 1
		syscall
		
		# End program
		li $v0, 10
		syscall
	 
	
	
