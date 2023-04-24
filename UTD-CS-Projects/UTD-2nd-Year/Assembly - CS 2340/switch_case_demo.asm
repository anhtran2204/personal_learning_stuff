	.data
input: 		.space 16
byteVar1:	.space 	4
byteVar2:	.space 	4
row1:		.space 4
col1: 		.space 4
row2:		.space 4
col2:		.space 4
A:		.byte	'A'
B:		.byte	'B'
prompt:		.asciiz	"Enter coordinates to connect > "
msg1:		.asciiz	"Same!\n"
msg2:		.asciiz	"Different!\n"
newLine:	.byte '\n'
space:		.byte ' '
and$:		.asciiz " and "

	.text
main:
	jal askInput
	
	lb $t0, row1
	lb $t1, row2
	
	#li $t2, 0
	caseA:
		la $t2, A
		lb $a0,	0($t2),  
		firstA:
		bne $t0, $a0, secondA
		li $s0, 0
		secondA:
		bne $t1, $a0, caseB
		li $s1, 0
		j checkEqual
	caseB: 
		la $t2, B
		lb $a0,	0($t2),
		firstB:
		bne $t0, $a0, secondB
		li $s0, 1
		secondB:
		bne $t1, $a0, checkEqual
		li $s1, 1
	checkEqual:
		beq $s0, $s1, same
		
		lb $a0, row1
		li $v0, 11
		syscall
		
		li $v0, 4
		la $a0, and$
		syscall
		
		lb $a0, row2
		li $v0, 11
		syscall
		
		jal addSpace
		
		li $v0, 4
		la $a0, msg2
		syscall
		j done
	same:
		lb $a0, row1
		li $v0, 11
		syscall
		
		li $v0, 4
		la $a0, and$
		syscall
		
		lb $a0, row2
		li $v0, 11
		syscall
		
		jal addSpace
		
		li $v0, 4
		la $a0, msg1
		syscall
	done:
		li $v0, 10
		syscall
		
askInput:
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	li $v0, 4
	la $a0, prompt
	syscall

	li $v0, 8
	la $a0, input
	li $a1, 16
	syscall
	
	jal addNewLine
	jal splitString
	lw $ra, 0($sp)
  	addi $sp, $sp, 4
	jr $ra
	
splitString:
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	li $t0, 0
	
	lb $a0, input($t0)
	li $v0, 11
	syscall
	sb $a0, row1	
	addi $t0, $t0, 1
	
	jal addNewLine
		
	lb $a0, input($t0)
	li $v0, 11
	syscall
	addi $a0, $a0, -48
	sb $a0, col1
	addi $t0, $t0, 1
	
	jal addNewLine
	
	lb $a0, input($t0)
	li $v0, 11
	syscall
	sb $a0, row2
	addi $t0, $t0, 1

	jal addNewLine
		
	lb $a0, input($t0)
	li $v0, 11
	syscall
	addi $a0, $a0, -48
	sb $a0, col2
	
	jal addNewLine
	
	lw $ra, 0($sp)
  	addi $sp, $sp, 4
	jr $ra

addSpace:
	lb $a0, space($0)
	li $v0, 11
	syscall
	jr $ra

addNewLine:
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	jr $ra
