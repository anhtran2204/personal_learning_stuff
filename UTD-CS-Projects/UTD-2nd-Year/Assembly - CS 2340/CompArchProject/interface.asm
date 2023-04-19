	.data
board:	
		.byte  	'.', '.', '.', '.', '.', '.', '.', '.', '.'
		.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
		.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
		.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
		.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
		.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
		.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	
prompt: 	.asciiz "Enter the coordinates: "
error1:		.asciiz "Line already exists!\n"
error2:		.asciiz	"Coordinates must be adjacent!\n"
start:		.asciiz "The starting coordinate is: "
end:		.asciiz "The ending coordinate is: "
colA:		.asciiz "A"
colB:		.asciiz "B" 
colC: 		.asciiz "C"
colD:		.asciiz "D"
colE:		.asciiz "E"
colF:		.asciiz "F"
colG:		.asciiz "G"
colLabel:	.word	colA, colB, colC, colD, colE, colF, colG
rowLabel:	.word	1, 2, 3, 4, 5, 6, 7, 8, 9
boardSize:	.word	221
colSize:	.word	9
rowSize:	.word 	13
input:		.space 	16
row1: 		.space 	4
column1: 	.space 	4
row2: 		.space 	4
column2: 	.space 	4
newLine:	.asciiz "\n"
space:		.asciiz " "
lineAcross:	.asciiz	"_"
lineDown:	.asciiz	"|"
player: 	.asciiz "P"
computer:	.asciiz	"C"
			
	.text
.globl printBoard
printBoard:
	li $v0, 4
	la $a0, newLine
	syscall
	
	#jal printRow
	
	jal userInput
	
	#jal findColumn
	
	li $v0, 10
	syscall

userInput:
	sw $ra, ($sp)
	
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 8
	la $a0, input
	li $a1, 16
	syscall
	
	li $t0, 0
	lb $a0, input($t0)
	sb $a0, row1
	addi $t0, $t0, 1
	
	lb $a0, input($t0)
	sb $a0, column1
	addi $t0, $t0, 1
	
	lb $a0, input($t0)
	sb $a0, row2
	addi $t0, $t0, 1
	
	lb $a0, input($t0)
	sb $a0, column2
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, start
	syscall
	
	li $v0, 11
	lb $a0, row1
	syscall
	
	li $v0, 11
	lb $a0, column1
	syscall
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, end
	syscall
	
	li $v0, 11
	lb $a0, row2
	syscall
	
	li $v0, 11
	lb $a0, column2
	syscall
	
	lw $ra, ($sp)
	jr $ra
	
findColumn:
	lw $t0, column1
	
	
printRowLabel:
	lw $t0, colSize
	la $s0, rowLabel
	li $t1, 0
	
	li $v0, 4
	la $a0, space
	syscall		
	
	li $v0, 4
	la $a0, space
	syscall
		
	startLoop:
		bge $t1, $t0, exitLoop
		
		li $v0, 1
		lw $a0, 0($s0)
		syscall 
		
		li $v0, 4
		la $a0, space
		syscall
		
		addi $s0, $s0, 4
		addi $t1, $t1, 1
		
		j startLoop
	exitLoop:
		li $v0, 4
		la $a0, newLine
		syscall 
		
		jr $ra
	
printRow:
	sw $ra, ($sp)
	jal printRowLabel
	
	li $s0, 0
	li $s1, 0
	lw $s2, rowSize
	lw $s3, colSize
	
	li $t0, 0
	addi $t2, $t2, 2
	addi $t3, $t3, 1
	outerLoop:
		bge $t0, $s2, exitOuterLoop
		li $t1, 0
		
		checkEmptyRows:
			div $t0, $t2
			mfhi $t4
			bne $t3, $t4, printNormal
			addi $s1, $s1, -4
			j innerLoop
		
		printNormal:
			lw $a0, colLabel($s1)
			li $v0, 4
			syscall
		
			li $v0, 4
			la $a0, space
			syscall
		innerLoop:
			bge $t1, $s3, exitInnerLoop
			
			lb $a0, board($s0)
			li $v0, 11
			syscall
			
			la $a0, space
			li $v0, 4
			syscall
		
			addi $s0, $s0, 1
			addi $t1, $t1, 1 
			
			j innerLoop
		exitInnerLoop:
			la $a0, newLine
			li $v0, 4
			syscall
			
			addi $t0, $t0, 1
			addi $s1, $s1, 4
			j outerLoop
	exitOuterLoop:
		li $v0, 4
		la $a0, newLine
		syscall
		
		lw $ra, ($sp)
		jr $ra
	

	
	
