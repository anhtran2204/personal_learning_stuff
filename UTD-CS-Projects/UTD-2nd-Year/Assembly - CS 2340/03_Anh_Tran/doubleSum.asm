.data 
	prompt: .asciiz "Enter an integer (0 to 100): "			
	error: .asciiz "Invalid number!\n"
	result1: .asciiz "The double sum of integers from 0 to "
	result2: .asciiz " is "
	input: .word 0							# Variable to store input
	arraySize: . word 101						# Variable to store array length
	array: .word 101						# An array with a size of 101 (range 0 to 100 inclusive)
	
.text
	# Registers:
	#   t0 -- array pointer
	#   t1 -- array length
	#   t2 -- input
	#   t3 -- sum
	#   t4 -- counter
	#   t5 -- placeholder
	main:	
		li $v0, 4				# Print prompt asking for user input
		la $a0, prompt
		syscall
			
		li $v0, 5				# Asking for user input
		syscall
	
		sw $v0, input				# Store input onto the X variable
		lw $t2, input				# Load input onto register $t2
		sll $t5, $t2, 2				# Load the value in X onto $s1 to compare the value with loop index
		lw $t1, arraySize			# Load array size onto register $t1
		
		beq $t5, $zero, exit			# Exit program if input = 0
		blt $t5, $zero, errorDisplay		# If input value is < 0 then branch to error
		bgt $t5, $t1, errorDisplay		# If input value is > limit then branch to error
		
		add $t3, $zero, $zero			# Initialize sum = 0
		add $t4, $zero, $zero			# Initialize counter = 0
		add $t5, $zero, $zero
		
		la $t0, array				# Initialize the array pointer = base addr of array
		j storeArray				# Jump to storing numbers into array
		
	storeArray:
		bgt $t4, $t2, addToSum			# If current loop index > length then exit loop
		sll $t5, $t4, 1				# Multiply 2*currValue
		sw $t5, ($t0)				# Store 2*currValue into current array index
		addi $t0, $t0, 4			# Increment array address by 4
		add $t4, $t4, 1				# Increment counter by 1
					
		j storeArray				# Loop again until branching
	
	addToSum:
		la $t0, array				# Initialize the array pointer again
		add $t4, $zero, $zero			
	loop:	bgt $t4, $t2, printSum			# If current loop index > length then exit loop	
		lw $t5, 0($t0)				# Load word onto placeholder
		add $t3, $t3, $t5			# Add to sum
		addi $t0, $t0, 4			# Increment array address by 4
		add $t4, $t4, 1				# Increment counter by 1
		
		j loop
	
	printSum:
		li $v0, 4				# Print result 
		la $a0, result1
		syscall
	
		li $v0, 1
		add $a0, $t2, $zero
		syscall
		
		li $v0, 4
		la $a0, result2
		syscall
		
		li $v0, 1
		add $a0, $t3, $zero
		syscall
		
		j exit
		
	errorDisplay:		
		li $v0, 4				# Print the prompt for invalid value
		la $a0, error
		syscall
		
	exit:
		li $v0, 10				# Exit program
		syscall		
				
					
							
