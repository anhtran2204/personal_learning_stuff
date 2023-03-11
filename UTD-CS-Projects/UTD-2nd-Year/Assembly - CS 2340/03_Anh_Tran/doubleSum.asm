	.data 
array: .word 404						# An array with a size of 101 (range 0 to 100 inclusive)
prompt: .asciiz "Enter an integer (0 to 100): "			
error: .asciiz "Invalid message!\n"
result1: .asciiz "The double sum of integers from 0 to "
result2: .asciiz " is "
length: .word 0							# Variable to indicate size of array
sum: .word 0							# Variable to hold sum of double integers
	
	.text
main:	
	li $v0, 4				# Print prompt asking for user input
	la $a0, prompt
	syscall
			
	li $v0, 5				# Asking for user input
	syscall
	
	sw $v0, length				# Store input onto the X variable
	lw $s1, length				# Load the value in X onto $s1 to compare the value with loop index
	sll $s1, $s1, 2				# Shift bits to the left to multiply array length to bit size (1 = 4 bits)
	add $s1, $s1, 4				# Increase by to not let the loop exit at the exact number (index <= length)
	
	beq $v0, $zero, errorDisplay		# If input value is 0 then branch to error to input again
	add $t0, $zero, $zero			# Initialize the loop index = 0
	add $s0, $zero, $zero			# Initialize the counter = 0
	add $s2, $zero, $zero			# Initialize the sum = 0
	j storeArray				# Jump to storing numbers into array
	
errorDisplay:		
	li $v0, 4				# Print the prompt for invalid value
	la $a0, error
	syscall
		
	j main					# Go back to input the valid number input
	
storeArray:
	beq $t0, $s1, exit			# If current loop index = length then exit loop
	sll $t1, $s0, 1				# Multiply 2*currValue 
	sw $t1, array($t0)			# Store 2*currValue into current array index
	add $s2, $s2, $t1			# Add 2*currValue to the sum
	add $s0, $s0, 1				# Increment counter by 1
	addi $t0, $t0, 4			# Increase index by 4 bits (index++ = +4 bits)
	
	j storeArray				# Loop again until branching
	
exit:
	sw $s2, sum				# Store the sum in the regiter into the variable
	
	li $v0, 4				# Print result 
	la $a0, result1
	syscall
	
	li $v0, 1
	lw $a0, length
	syscall
	
	li $v0, 4
	la $a0, result2
	syscall
	
	li $v0, 1
	lw $a0, sum
	syscall
	
	li $v0, 10				# Exit program
	syscall		
				
					
							
