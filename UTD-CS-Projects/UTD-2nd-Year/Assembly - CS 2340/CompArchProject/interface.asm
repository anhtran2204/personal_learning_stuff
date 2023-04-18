	.data
board:	
	#.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	#.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
	#.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	#.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
	#.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	#.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
	#.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	#.byte 	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
	#.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	#.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
	#.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	#.byte	' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '
	#.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	
	.byte	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	.byte 	'.', '.', '.', '.', '.', '.', '.', '.', '.'
	
prompt1: 	.asciiz "Enter the 1st coordinate: "
prompt2:	.asciiz "Enter the 2nd coordinate: "
error1:		.asciiz "Line already exists!\n"
error2:		.asciiz	"Coordinates must be adjacent!\n"
	
colA:		.asciiz "A"
colB:		.asciiz "B" 
colC: 		.asciiz "C"
colD:		.asciiz "D"
colE:		.asciiz "E"
colF:		.asciiz "F"
colG:		.asciiz "G"
colLabel:	.word	colA, colB, colC, colD, colE, colF, colG
rowLabel:	.word	1, 2, 3, 4, 5, 6, 7, 8, 9
boardSize:	.word	63
colSize:	.word	9
rowSize:	.word 	7
input:		.space 	4
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
	
	jal printRowLabel
	
	li $v0, 4
	la $a0, prompt1
	syscall
	
	li $v0, 8
	la $a0, input
	li $a1, 4
	syscall
	
	li $v0, 10
	syscall
	
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
		
		j printRow
	
printRow:
	li $s0, 0
	li $s1, 0
	lw $s2, rowSize
	lw $s3, colSize
	
	li $t0, 0
	outerLoop:
		bge $t0, $s2, exitOuterLoop
		li $t1, 0
		
		#lb $t2, board($s0)
		#lb $t3, space
		#bne $t2, $t3, printNormal
		#addi $s1, $s1, -4
		#	j innerLoop
		
		#printNormal:
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
		
			add $s0, $s0, 1
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
		
		jr $ra
	

	
	
