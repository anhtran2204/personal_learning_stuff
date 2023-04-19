	.data
prompt: 	.asciiz "Enter the coordinates for connection: "
start:		.asciiz "The starting coordinate is: "
end:		.asciiz "The ending coordinate is: "
str: 		.space 16
row1: 		.space 4
column1: 	.space 4
row2: 		.space 4
column2: 	.space 4
newLine:	.asciiz "\n"

	.text
input:
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 8
	la $a0, str
	li $a1, 16
	syscall
	
	li $t0, 0
	lb $a0, str($t0)
	sb $a0, row1
	addi $t0, $t0, 1
	
	lb $a0, str($t0)
	sb $a0, column1
	addi $t0, $t0, 1
	
	lb $a0, str($t0)
	sb $a0, row2
	addi $t0, $t0, 1
	
	lb $a0, str($t0)
	sb $a0, column2
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, start
	syscall
	
	li $v0, 4
	la $a0, row1
	syscall
	
	li $v0, 4
	la $a0, column1
	syscall
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, end
	syscall
	
	li $v0, 4
	la $a0, row2
	syscall
	
	li $v0, 4
	la $a0, column2
	syscall
	
	li $v0, 10         # exit
	syscall