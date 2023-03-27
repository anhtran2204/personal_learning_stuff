.data
	result: .asciiz "The double sum of integers from 0 to "
	compare: .asciiz "Bigger"
	compare2: .asciiz "Smaller"
	number: .word 100
	
.text
	main:
		li $v0, 4
		la $a0, result
		syscall
		
		li $v0, 1
		la $a0, number
		syscall
		
		li $v0, 5
		syscall
		
		bgt $v0, $a0, else
		la $a0, compare2
		li $v0, 4
		syscall
		
	else: 
		la $a0, compare
		li $v0, 4
		syscall
		
		li $v0, 10
		syscall