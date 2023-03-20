.data
	prompt: .asciiz "\nGive me a number between 1 and 10 (0 to stop): "
	iterative: .asciiz "ITERATIVE: "
	recursive: .asciiz "RECURSIVE: "
	space: .asciiz " "
	new_line: .asciiz "\n"
	number: .word 0						# Variable to store user input		

.text 
	main:
		li $v0, 4					# Print prompt asking for user input
		la $a0, prompt
		syscall
	
		li $v0, 5					# Asking for user input
		syscall
		sw $v0, number
		
		li $v0, 4					# Print out the Iterative ver of count down
		la $a0, iterative
		syscall
		jal itr_countdown				# Jump to iterative procedure
		
		li $v0, 4
		la $a0, new_line
		syscall
		
		li $v0, 4					# Print out the Recursive ver of count down
		la $a0, recursive
		syscall
		jal rec_countdown				# Jump to recursive procedure
		
		li $v0, 10					# Exit program
		syscall
		
	itr_countdown:						
		lw $s0, number					# Load user input into $s0
		loop:
			# While $s0 not equal -1 continue
			# Else return result and exit procedure
			beq $s0, -1, itr_else			
		
			li $v0, 1
			la $a0, 0($s0)				# Load address of $s0 onto $a0 to print out
			syscall
		
			li $v0, 4
			la $a0, space
			syscall
		
			addi $s0, $s0, -1			# Decrement the $s0 by 1 for next iteration
			j loop					# Loop again
		
		itr_else:
			jr $ra					# Return result and exit procdure
	
	rec_countdown:
		lw $s1, number					# Load user input into $s1
		recursion:
			add $sp, $sp, -8			# Make space on the stack
			sw $s1, 4($sp)				# Load $s1 on the stack
			sw $ra, 0($sp)				# Load $ra on the stack
		
			# If $s1 not equal then continue
			# Else, return result and exit current recursion
			beq $s1, -1, rec_else				
		
			li $v0, 1 
			la $a0, 0($s1)				# Load address of $s1 onto $a0 to print
			syscall
		
			li $v0, 4
			la $a0, space
			syscall
		
			addi $s1, $s1, -1			# Decrement the $s0 by 1 for next recursion
			jal recursion
		
		rec_else:
			lw $s1, 4($sp)				# Return $s1 and clear out the stack
			lw $ra, 0($sp)				# Return $ra and clear out the stack
			addi $sp, $sp, 8			# Restore space of the stack
			jr $ra					# Return result and exit procedure
