	.data
input:		.space 16
row:		.byte 1
col:		.byte 0
vertLine:	.byte '|'

	.text
main:
	li $v0, 8
	la $a0, input
	li $a1, 16
	syscall
	
	li $t0, 0
	
	#lb $a0, input($t0)
	#addi $t0, $t0, 1
	
	#lb $a1, input($t0)
	#addi $t0, $t0, 1
	
	#lb $a2, input($t0)
	#addi $t0, $t0, 1
	
	#lb $a3, input($t0)
	#addi $t0, $t0, 1
	
	lb $a0, row
	lb $a1, col
	lb $a2, vertLine
	jal createBoard
	
	li $v0, 10
	syscall